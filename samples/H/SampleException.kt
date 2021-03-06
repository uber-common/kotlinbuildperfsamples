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
import com.uber.errorprone.annotations.DoNotMock
import com.uber.errorprone.annotations.JavaOnly
import com.uber.errorprone.annotations.KotlinOnly
import com.uber.model.core.adapter.gson.GsonSerializable
import com.uber.model.core.annotation.Property
import com.uber.model.core.annotation.RequiredMethods
import com.uber.model.core.annotation.ThriftElement
import javax.annotation.Generated
import kotlin.Double
import kotlin.Int
import kotlin.Long
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
@GsonSerializable(SampleException_GsonTypeAdapter::class)
data class SampleException @KotlinOnly constructor(
  @Property @get:JvmName("optionalField1") val optionalField1: Long? = null,
  @Property @get:JvmName("optionalField2") val optionalField2: Double? = null,
  @Property @get:JvmName("requiredEnumField") val requiredEnumField: SampleEnum,
  @Property @get:JvmName("optionalField3") val optionalField3: TypedefB? = null,
  @Property @get:JvmName("optionalField4") val optionalField4: String? = null,
  @Property @get:JvmName("optionalField5") val optionalField5: Int? = null,
  @Property @get:JvmName("optionalField6") val optionalField6: TypedefD? = null
) {
  /**
   * Initializes a builder to the same property values as as this existing instance's values.
   */
  @JavaOnly
  fun toBuilder(): Builder =
      Builder(optionalField1 = this.optionalField1, optionalField2 = this.optionalField2, requiredEnumField = this.requiredEnumField, optionalField3 = this.optionalField3, optionalField4 = this.optionalField4, optionalField5 = this.optionalField5, optionalField6 = this.optionalField6)

  @DoNotMock
  @ThriftElement.Builder
  class Builder internal constructor(
    private var optionalField1: Long? = null,
    private var optionalField2: Double? = null,
    private var requiredEnumField: SampleEnum? = null,
    private var optionalField3: TypedefB? = null,
    private var optionalField4: String? = null,
    private var optionalField5: Int? = null,
    private var optionalField6: TypedefD? = null
  ) {
    fun optionalField1(optionalField1: Long?): Builder = apply {
      this.optionalField1 = optionalField1
    }

    fun optionalField2(optionalField2: Double?): Builder = apply {
      this.optionalField2 = optionalField2
    }

    fun requiredEnumField(requiredEnumField: SampleEnum): Builder = apply {
      this.requiredEnumField = requiredEnumField
    }

    fun optionalField3(optionalField3: TypedefB?): Builder = apply {
      this.optionalField3 = optionalField3
    }

    fun optionalField4(optionalField4: String?): Builder = apply {
      this.optionalField4 = optionalField4
    }

    fun optionalField5(optionalField5: Int?): Builder = apply {
      this.optionalField5 = optionalField5
    }

    fun optionalField6(optionalField6: TypedefD?): Builder = apply {
      this.optionalField6 = optionalField6
    }

    /**
     * Builds an instance.
     *
     * **NOTE:** The following required properties must be set in order to be valid.
     * - [requiredEnumField]
     */
    @RequiredMethods("requiredEnumField")
    fun build(): SampleException {
      return SampleException(
          optionalField1 = optionalField1,
          optionalField2 = optionalField2,
          requiredEnumField = requiredEnumField ?: throw NullPointerException("requiredEnumField is null!"),
          optionalField3 = optionalField3,
          optionalField4 = optionalField4,
          optionalField5 = optionalField5,
          optionalField6 = optionalField6
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
            .requiredEnumField(SampleEnum.values()[0])

    @JavaOnly
    @JvmStatic
    @VisibleForTesting(otherwise = 5)
    fun stub(): SampleException = builderWithDefaults().build()
  }
}
