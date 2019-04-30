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
