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

package com.uber.model.core.generated.example

import com.google.errorprone.annotations.CheckReturnValue
import com.uber.presidio.realtime.core.Data
import com.uber.presidio.realtime.core.RealtimeClient
import com.uber.presidio.realtime.core.Response
import com.uber.presidio.realtime.core.error.ErrorAdapter
import io.reactivex.Single
import javax.annotation.Generated
import javax.inject.Inject
import kotlin.String
import kotlin.Unit

/**
 * Client implementation that backs [SampleServiceApi] */
@Generated(
    "ThriftCodeGen Compiler",
    comments = "This code was generated by the Uber ThriftCodeGen Compiler from: example.thrift"
)
class SampleServiceClient<D : Data> @Inject constructor(private val realtimeClient:
    RealtimeClient<D>) {
  /**
   * Corresponds to [SampleServiceApi.emptyResponse]
   */
  @CheckReturnValue
  fun emptyResponse(param1: String, param2: String): Single<Response<Unit, EmptyResponseErrors>> =
      realtimeClient
    .requestBuilder()
    .api<SampleServiceApi>(SampleServiceApi::class.java)
    .endpoint<Unit, EmptyResponseErrors>({ e: ErrorAdapter -> EmptyResponseErrors.create(e) }) {
        api: SampleServiceApi ->
      api.emptyResponse(param1, param2)
    }
    .build()

  /**
   * Corresponds to [SampleServiceApi.endpoint1]
   */
  @CheckReturnValue
  fun endpoint1(pathParam: String, queryParam: String): Single<Response<SampleUnion,
      Endpoint1Errors>> = realtimeClient
    .requestBuilder()
    .api<SampleServiceApi>(SampleServiceApi::class.java)
    .endpoint<SampleUnion, Endpoint1Errors>({ e: ErrorAdapter -> Endpoint1Errors.create(e) }) { api:
        SampleServiceApi ->
      api.endpoint1(pathParam, queryParam)
    }
    .build()
}
