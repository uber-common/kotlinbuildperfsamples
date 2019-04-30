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
data class Unauthenticated @KotlinOnly constructor(
  @Property @get:JvmName("code") val code: UnauthenticatedCode,
  @Property @get:JvmName("message") val message: String,
  @Property @get:JvmName("errorCode") val errorCode: String? = null
) {
  /**
   * Initializes a builder to the same property values as as this existing instance's values.
   */
  @JavaOnly
  fun toBuilder() = Builder(code = this.code, message = this.message, errorCode = this.errorCode)

  @DoNotMock
  @ThriftElement.Builder
  class Builder internal constructor(
    private var code: UnauthenticatedCode? = null,
    private var message: String? = null,
    private var errorCode: String? = null
  ) {
    fun code(code: UnauthenticatedCode) = apply {
      this.code = code
    }

    fun message(message: String) = apply {
      this.message = message
    }

    fun errorCode(errorCode: String?) = apply {
      this.errorCode = errorCode
    }

    /**
     * Builds an instance.
     *
     * **NOTE:** The following required properties must be set in order to be valid.
     * - [code]
     * - [message]
     */
    @RequiredMethods("code","message")
    fun build(): Unauthenticated {
      return Unauthenticated(
          code = code ?: throw NullPointerException("code is null!"),
          message = message ?: throw NullPointerException("message is null!"),
          errorCode = errorCode
          )
    }
  }

  companion object {
    @JavaOnly
    @JvmStatic
    fun builder() = Builder()

    @JavaOnly
    @JvmStatic
    @VisibleForTesting(otherwise = 5)
    fun builderWithDefaults() = builder()
            .code(UnauthenticatedCode.values()[0])
            .message("Stub")

    @JavaOnly
    @JvmStatic
    @VisibleForTesting(otherwise = 5)
    fun stub() = builderWithDefaults().build()
  }
}
