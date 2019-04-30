/*
 * Copyright (c) 2019 Uber Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

namespace java com.uber.model.core.generated.example

typedef string TypedefA
typedef i32 TypedefB
typedef bool TypedefC
typedef i64 TypedefD

enum SampleEnum {
  MEMBER_0 = 0,
  MEMBER_1 = 1,
  MEMBER_2 = 2
}

struct SampleRequest {
  1: optional i64 optionalField1
  2: optional double optionalField2
  3: required SampleEnum requiredEnumField
  4: optional TypedefB optionalField3
  5: optional string optionalField4
  6: optional i32 optionalField5
  7: optional TypedefD optionalField6
} (
  // This triggers generation of a singleton push model type
  backend.mobile.push.messageType = "push_sample"
)

enum SampleUnionUnionType {
  UNKNOWN = 0,
  OPTION1 = 1 (codegen.annotations.wireName = "option1"),
  OPTION2 = 2 (codegen.annotations.wireName = "option2"),
  OPTION3 = 3(codegen.annotations.wireName = "option3"),
}

union SampleUnion {
  1: optional SampleUnionUnionType type = SampleUnionUnionType.UNKNOWN (codegen.annotations.visibilityOverride = "required")
  2: optional string option1
  3: optional bool option2
  4: optional i32 option3
} (backend.mobile.unknownCaseFallback = "UNKNOWN")

exception SampleException {
  1: optional i64 optionalField1
  2: optional double optionalField2
  3: required SampleEnum requiredEnumField
  4: optional TypedefB optionalField3
  5: optional string optionalField4
  6: optional i32 optionalField5
  7: optional TypedefD optionalField6
}

enum BadRequestCode {
  BAD_REQUEST
}

exception BadRequest {
  1: required BadRequestCode code
  2: required string message
  3: optional map<string, string> data
}

enum UnauthenticatedCode {
  UNAUTHENTICATED
}

exception Unauthenticated {
  1: required UnauthenticatedCode code
  2: required string message
  3: optional string errorCode
}

exception NoContent {

} (
  codegen.annotations.singleton = "true"
)

enum RateLimitedCode {
  RATE_LIMITED
}

exception RateLimited {
  1: required RateLimitedCode code
  2: required string message
}

enum InternalServerErrorCode {
  SERVER_ERROR
}

exception ServerError {
  1: required InternalServerErrorCode code
  2: required string message
}

service SampleService {

  SampleUnion endpoint1(
    1: required string pathParam (backend.http.ref = "params.examplePath")
    2: required string queryParam (backend.http.ref = "query.exampleQuery")
    3: required SampleRequest request
  ) throws (
    1: BadRequest badRequest (backend.http.status = "400")
    2: Unauthenticated unauthenticated (backend.http.status = "401")
    3: ServerError serverError (backend.http.status = "500")
    // RPC style error that comes over a header
    4: RateLimited rateLimited
    5: NoContent noContent (backend.http.status = "204")
  ) (
    backend.http.method = "GET"
    codegen.annotations.retrofit.path = "/sample",
    backend.mobile.service.errorClass = "com.uber.model.core.generated.example.Endpoint1Errors"
  )

  void emptyResponse(
    1: required string param1
    2: required string param2
  ) throws (
    1: BadRequest badRequest (backend.http.status = "400")
    2: Unauthenticated unauthenticated (backend.http.status = "401")
    3: ServerError serverError (backend.http.status = "500")
    // RPC style error that comes over a header
    4: RateLimited rateLimited
    5: NoContent noContent (backend.http.status = "204")
  ) (
    backend.http.method = "POST"
    codegen.annotations.retrofit.path = "/sample/endpoint2"
    backend.http.req.def.boxed = "true",
    backend.mobile.service.errorClass = "com.uber.model.core.generated.example.EmptyResponseErrors"
  )
}
