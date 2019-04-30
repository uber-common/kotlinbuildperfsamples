package com.uber.model.core.generated.example

import com.google.errorprone.annotations.RestrictedApi
import com.uber.presidio.realtime.core.Data
import com.uber.presidio.realtime.core.RealtimeClient
import dagger.internal.Factory
import javax.annotation.Generated
import javax.inject.Provider
import kotlin.jvm.JvmStatic

@Generated(
    "com.uber.realtime.android.servicebuilder.kotlin.RealtimeKotlinServiceBuilder",
    comments = "This code was generated by the Uber ThriftCodeGen Compiler for use with Dagger."
)
class SampleServiceClient_Factory<D : Data>(private val clientProvider: Provider<RealtimeClient<D>>)
    : Factory<SampleServiceClient<D>> {
  override fun get() = provideInstance(clientProvider)

  companion object {
    @RestrictedApi(
        explanation = "This should only be accessed from Dagger code",
        link = "",
        whitelistAnnotations = [Generated::class]
    )
    @JvmStatic
    fun <D : Data> provideInstance(clientProvider: Provider<RealtimeClient<D>>) =
        SampleServiceClient<D>(clientProvider.get())

    @RestrictedApi(
        explanation = "This should only be accessed from Dagger code",
        link = "",
        whitelistAnnotations = [Generated::class]
    )
    @JvmStatic
    fun <D : Data> create(clientProvider: Provider<RealtimeClient<D>>) =
        SampleServiceClient_Factory<D>(clientProvider)

    @RestrictedApi(
        explanation = "This should only be accessed from Dagger code",
        link = "",
        whitelistAnnotations = [Generated::class]
    )
    @JvmStatic
    fun <D : Data> newSampleServiceClient(client: RealtimeClient<D>) =
        SampleServiceClient<D>(client)
  }
}