Kotlin Build Performance Samples
================================

This is sample code for the measurements in our "Measuring Kotlin Build Performance" blog post. Please read the post for full context.

https://eng.uber.com/measuring-kotlin-build-performance/

## Tech Stack

* Code gen thrift with [Thrifty](https://github.com/microsoft/thrifty) (schema only), can generate Java/Kotlin, applies custom postprocessing to add any other features such as serialization.
* BUCK for builds (varies, but will collect version when script runs)
  * Note this repo currently is just sample code but not buildable. We may explore this in the future.
* [Retrofit](https://github.com/square/retrofit) 2.5/[OkHttp](https://github.com/square/okhttp) 3.12 for services
* [Okio](https://github.com/square/okio) 2.2.2 for `ByteString` representations of thrift `binary` types.
* [Gson](https://github.com/google/gson) 2.8.5 for JSON serialization in Java (and the `M` kotlin variant).
* [Moshi](https://github.com/square/moshi) 1.8.0 for JSON serialization in Kotlin
* Kotlin 1.3.21
* In Java, we just use `Unit` for void types
* In Kotlin, we use some functions like let/apply/etc
* [ThreeTenBp](https://github.com/ThreeTen/threetenbp) 1.3.6
  * Specifically just `Instant`
* [Dagger](https://github.com/google/dagger) 2.16.1
  * Generated services can be injected, and we generate the factory that dagger looks for
    * These can be generated directly or left to the Dagger compiler to generate during apt.
* [RxJava](https://github.com/reactivex/rxjava) 1.3.8 & 2.2.4 + RxJava2Interop 0.13.3
  * Network stack only supports RxJava 1 right now, but we expose RxJava 2 endpoints
* Internal library called Lumber, basically like [Timber](https://github.com/JakeWharton/timber)
* Internal immutable collections library + json adapters for them. Basically identical to [Guava’s](https://github.com/google/guava/tree/master/guava/src/com/google/common/collect).
  * Would use these in kotlin code gen too, since Kotlin mutability doesn’t carry over to Java consumers
* Small runtime for the code gen pipeline

## Shape of Models

Example models for each matrix type + build.gradle file can be found in the `samples` directory.

### Core thrift elements

#### Struct

**Java**
* Standard POJO w/ toString/hashcode/equals and memoized values
* Some annotations on the top
* Builders + test helpers
* For json serialization, an annotation on the file indicates to either gson or moshi to reflectively look up an adapter class based on the name
* For default values - inlined in the builder property defaults.

**Kotlin**
* Standard data class
* Some annotations on the top
* Some `@JvmName` annotations to not break existing java users
* Builders + test helpers
* For json serialization, an annotation on the file indicates to either gson or moshi to reflectively look up an adapter class based on the name
* For default values - inlined in the builder property defaults or data class property default values
* Default values for nullable properties is set to null

#### Enum

Standard in both java and kotlin

#### Typedef

**Java**
* Wrapper class around its backing type with static helper wrap/wrapFrom methods
* String/uuid/url classes extend a base class with toString/hashcode/equals shared
* Other primitives are each implemented on demand
* Global `typeadapter` factory creates reflective adapter on-demand at runtime for json serialization

**Kotlin**
* Basically same implementation as java
* Would ideally like to make these inline classes in pure kotlin, but can’t interop nicely to java

#### Union

**Java**
* All nullable fields, one synthetic (and required) “type” field to indicate the “present” type. Like a tagged union, but the type value is the field name that is present on the wire.
* Standard hashcode/equals implementation w/ memoized values. Custom toString() implementation for more readable string
* Builder is only available for json adapters
* Static creator methods for each possible type

**Kotlin**
* All nullable fields, one synthetic (and required) “type” field to indicate the “present” type. Like a tagged union, but the type value is the field name that is present on the wire.
* Data class, custom toString() implementation for more readable string
* Builder is only available for json adapters or java interop
* Static creator methods for each possible type
  * Note - we can’t use sealed classes for this in Kotlin because elements are potentially reused

#### Exception

Basically identical to structs, can be returned as error bodies in endpoint responses

#### Service

* Return a `Single<Response<T, E>>` type where T is the response type and E is the possible set of errors defined for that endpoint.
* For `void` return types in thrift, return Kotlin's `Unit`.
* For 204 types, return a singleton/object instance of type (see “NoContent” class examples)
  * Based on the implementation in [this PR](https://github.com/square/retrofit/pull/3003)

**API**
* Both java and kotlin are standard Retrofit interfaces
* Not exposed directly to consumers. Some endpoints accept just a Map of request body elements

**Client** 
* Wrapper over the API. Handles piping arguments down, sometimes is API sugar over endpoints with empty request bodies or wrapping up parameters into a map for the request body
* Pipes endpoints through our network stack (“RealtimeClient”), including routing of error handling
* Data transactions (not in sample code) optionally enabled on some endpoints to hide response type and route data through a repository-style stream instead.
* This is where a lot of generics are! As well as lambdas and member references.
* Some synthetic types in our network stack

**Push models (singletons)**
* These are models that are sent through our push pipeline, designated via annotation in thrift
* **Java** - standard singleton object with private constructor and public static final INSTANCE with custom `toString()`.
* `INSTANCE` singleton pattern designed to match kotlin objects interop from Java
* **Kotlin** - standard object with custom `toString()`

**Errors classes**

Similar structure to unions, but not tagged with a type field. “Tag” is based on either status code or rpc field header in the response

*Java*
* Like standard unions but no builders or generated json adapters.
* Static “of___” creator functions for instance creation
* “Unknown” fallback type where no properties are present, but this can return true to indicate it’s an unrecognized status code/rpc header error value.
* Static “create” function that generated clients pass by reference to realtimeclient for deserializing error bodies into exception types. Works with ErrorAdapter interface to contextually deserialize json based on http status code or rpc header value.

*Kotlin*
* Like standard unions but no builders or generated json adapters.
* Static “of___” creator functions for instance creation
* “Unknown” fallback type where no properties are present, but this can return true to indicate it’s an unrecognized status code/rpc header error value.
* Static “create” function that generated clients pass by reference to realtimeclient for deserializing error bodies into exception types. Works with ErrorAdapter interface to contextually deserialize json based on http status code or rpc header value.

#### Generated adapters

**Gson**
Java - generates java Gson `TypeAdapter`s. Heavily adapted from [auto-value-gson](https://github.com/rharter/auto-value-gson)’s generated adapters.
Kotlin - also generates java Gson `TypeAdapter`s like java models do

**Moshi**
Kotlin-only - uses Moshi kotlin code gen frontend to generate models. Based on [this PR](https://github.com/square/moshi/pull/816).

**Dagger factories**
* Generated clients can be constructor injected via `@Inject` annotation
* We can let Dagger generate the *_Factory.java classes, or also generate it up-front ourselves to avoid the apt cost.
* If we use kapt, dagger only generates Java. If generating directly, we can generate kotlin with the same signature.
* Java - `SampleServiceClient_Factory.java`
* Kotlin - `SampleServiceClient_Factory.kt`
