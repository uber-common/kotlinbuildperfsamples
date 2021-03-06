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
  override fun get(): SampleServiceClient<D> = provideInstance<D>(clientProvider)

  companion object {
    @RestrictedApi(
        explanation = "This should only be accessed from Dagger code",
        link = "",
        whitelistAnnotations = [Generated::class]
    )
    @JvmStatic
    fun <D : Data> provideInstance(clientProvider: Provider<RealtimeClient<D>>):
        SampleServiceClient<D> = SampleServiceClient<D>(clientProvider.get())

    @RestrictedApi(
        explanation = "This should only be accessed from Dagger code",
        link = "",
        whitelistAnnotations = [Generated::class]
    )
    @JvmStatic
    fun <D : Data> create(clientProvider: Provider<RealtimeClient<D>>):
        SampleServiceClient_Factory<D> = SampleServiceClient_Factory<D>(clientProvider)

    @RestrictedApi(
        explanation = "This should only be accessed from Dagger code",
        link = "",
        whitelistAnnotations = [Generated::class]
    )
    @JvmStatic
    fun <D : Data> newSampleServiceClient(client: RealtimeClient<D>): SampleServiceClient<D> =
        SampleServiceClient<D>(client)
  }
}
