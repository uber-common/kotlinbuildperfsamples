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

package com.uber.model.core.generated.example;

import com.google.errorprone.annotations.CheckReturnValue;
import com.uber.errorprone.annotations.DoNotSubclass;
import com.uber.presidio.realtime.core.Data;
import com.uber.presidio.realtime.core.RealtimeClient;
import com.uber.presidio.realtime.core.Response;
import io.reactivex.Single;
import javax.annotation.Generated;
import javax.inject.Inject;
import kotlin.Unit;

/** Client implementation that backs {@link SampleServiceApi} */
@Generated(
  value = "ThriftCodeGen Compiler",
  comments = "This code was generated by the Uber ThriftCodeGen Compiler from: example.thrift"
)
@SuppressWarnings("ThrowableResultOfMethodCallIgnored")
@DoNotSubclass("This should be treated as final, and is only non-final for legacy reasons")
public class SampleServiceClient<D extends Data> {
  private final RealtimeClient<D> realtimeClient;

  @Inject
  public SampleServiceClient(RealtimeClient<D> client) {
    this.realtimeClient = client;
  }

  /** Corresponds to {@link SampleServiceApi#emptyResponse} */
  @CheckReturnValue
  public Single<Response<Unit, EmptyResponseErrors>> emptyResponse(
      final String param1, final String param2) {
    return realtimeClient
        .requestBuilder()
        .api(SampleServiceApi.class)
        .endpoint(EmptyResponseErrors::create, api -> api.emptyResponse(param1, param2))
        .build();
  }

  /** Corresponds to {@link SampleServiceApi#endpoint1} */
  @CheckReturnValue
  public Single<Response<SampleUnion, Endpoint1Errors>> endpoint1(
      final String pathParam, final String queryParam) {
    return realtimeClient
        .requestBuilder()
        .api(SampleServiceApi.class)
        .endpoint(Endpoint1Errors::create, api -> api.endpoint1(pathParam, queryParam))
        .build();
  }
}
