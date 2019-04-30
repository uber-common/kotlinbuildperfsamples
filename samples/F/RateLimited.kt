package com.uber.model.core.generated.example

import androidx.annotation.VisibleForTesting
import com.google.errorprone.annotations.Immutable
import com.squareup.moshi.JsonClass
import com.uber.errorprone.annotations.DoNotMock
import com.uber.errorprone.annotations.JavaOnly
import com.uber.errorprone.annotations.KotlinOnly
import com.uber.model.core.annotation.Property
import com.uber.model.core.annotation.RequiredMethods
import com.uber.model.core.annotation.ThriftElement
import javax.annotation.Generated
import kotlin.String
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

@Generated(
    "com.uber.codegen.compiler.KotlinThriftCodeGenCodeGenerator",
    comments = "This code was generated by the Uber ThriftCodeGen Compiler from: example.thrift"
)
@ThriftElement
@DoNotMock("Create a real instance via the constructor (Kotlin) or builder(), builderWithDefaults(), or stub() (Java).")
@Immutable
@JsonClass(generateAdapter = true)
data class RateLimited @KotlinOnly constructor(@Property @get:JvmName("code") val code:
    RateLimitedCode, @Property @get:JvmName("message") val message: String) {
  /**
   * Initializes a builder to the same property values as as this existing instance's values.
   */
  @JavaOnly
  fun toBuilder(): Builder = Builder(code = this.code, message = this.message)

  @DoNotMock
  @ThriftElement.Builder
  class Builder internal constructor(private var code: RateLimitedCode? = null, private var message:
      String? = null) {
    fun code(code: RateLimitedCode): Builder = apply {
      this.code = code
    }

    fun message(message: String): Builder = apply {
      this.message = message
    }

    /**
     * Builds an instance.
     *
     * **NOTE:** The following required properties must be set in order to be valid.
     * - [code]
     * - [message]
     */
    @RequiredMethods("code","message")
    fun build(): RateLimited {
      return RateLimited(
          code = code ?: throw NullPointerException("code is null!"),
          message = message ?: throw NullPointerException("message is null!")
          )
    }
  }

  companion object {
    @JavaOnly
    @JvmStatic
    fun builder(): Builder = Builder()

    @JavaOnly
    @JvmStatic
    @VisibleForTesting(otherwise = 5)
    fun builderWithDefaults(): Builder = builder()
            .code(RateLimitedCode.values()[0])
            .message("Stub")

    @JavaOnly
    @JvmStatic
    @VisibleForTesting(otherwise = 5)
    fun stub(): RateLimited = builderWithDefaults().build()
  }
}
