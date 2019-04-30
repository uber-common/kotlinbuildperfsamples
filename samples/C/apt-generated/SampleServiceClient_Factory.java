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

import com.uber.presidio.realtime.core.Data;
import com.uber.presidio.realtime.core.RealtimeClient;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://google.github.io/dagger"
)
public final class SampleServiceClient_Factory<D extends Data> implements Factory<SampleServiceClient<D>> {
  private final Provider<RealtimeClient<D>> clientProvider;

  public SampleServiceClient_Factory(Provider<RealtimeClient<D>> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  public SampleServiceClient<D> get() {
    return provideInstance(clientProvider);
  }

  public static <D extends Data> SampleServiceClient<D> provideInstance(
      Provider<RealtimeClient<D>> clientProvider) {
    return new SampleServiceClient<D>(clientProvider.get());
  }

  public static <D extends Data> SampleServiceClient_Factory<D> create(
      Provider<RealtimeClient<D>> clientProvider) {
    return new SampleServiceClient_Factory<D>(clientProvider);
  }

  public static <D extends Data> SampleServiceClient<D> newSampleServiceClient(
      RealtimeClient<D> client) {
    return new SampleServiceClient<D>(client);
  }
}
