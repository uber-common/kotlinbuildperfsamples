package com.uber.model.core.generated.example;

import com.google.errorprone.annotations.RestrictedApi;
import com.uber.presidio.realtime.core.Data;
import com.uber.presidio.realtime.core.RealtimeClient;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "com.uber.realtime.android.servicebuilder.RealtimeJavaServiceBuilder",
  comments = "This code was generated by the Uber ThriftCodeGen Compiler for use with Dagger."
)
public final class SampleServiceClient_Factory<D extends Data>
    implements Factory<SampleServiceClient<D>> {
  private final Provider<RealtimeClient<D>> clientProvider;

  @RestrictedApi(
    explanation = "This should only be accessed from Dagger code",
    link = "",
    whitelistAnnotations = Generated.class
  )
  public SampleServiceClient_Factory(Provider<RealtimeClient<D>> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  @RestrictedApi(
    explanation = "This should only be accessed from Dagger code",
    link = "",
    whitelistAnnotations = Generated.class
  )
  public SampleServiceClient<D> get() {
    return provideInstance(clientProvider);
  }

  @SuppressWarnings("CallingProviderGetDuringInit")
  @RestrictedApi(
    explanation = "This should only be accessed from Dagger code",
    link = "",
    whitelistAnnotations = Generated.class
  )
  public static <D extends Data> SampleServiceClient<D> provideInstance(
      Provider<RealtimeClient<D>> clientProvider) {
    return new SampleServiceClient<D>(clientProvider.get());
  }

  @RestrictedApi(
    explanation = "This should only be accessed from Dagger code",
    link = "",
    whitelistAnnotations = Generated.class
  )
  public static <D extends Data> SampleServiceClient_Factory<D> create(
      Provider<RealtimeClient<D>> clientProvider) {
    return new SampleServiceClient_Factory<D>(clientProvider);
  }

  @RestrictedApi(
    explanation = "This should only be accessed from Dagger code",
    link = "",
    whitelistAnnotations = Generated.class
  )
  public static <D extends Data> SampleServiceClient<D> newSampleServiceClient(
      RealtimeClient<D> client) {
    return new SampleServiceClient<D>(client);
  }
}