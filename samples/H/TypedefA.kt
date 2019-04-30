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

import com.google.errorprone.annotations.Immutable
import com.uber.errorprone.annotations.DoNotMock
import com.uber.errorprone.annotations.KotlinOnly
import com.uber.model.core.adapter.gson.GsonSerializable
import com.uber.model.core.annotation.ThriftElement
import com.uber.model.core.annotation.TypeSafeWrapper
import com.uber.model.core.wrapper.TypeSafeString
import javax.annotation.Generated
import kotlin.String
import kotlin.jvm.JvmStatic

@Generated(
    "com.uber.codegen.compiler.KotlinThriftCodeGenCodeGenerator",
    comments = "This code was generated by the Uber ThriftCodeGen Compiler from: example.thrift"
)
@ThriftElement
@Immutable
@DoNotMock("Create a real instance via wrap().")
@TypeSafeWrapper
@GsonSerializable(TypedefA_GsonTypeAdapter::class)
class TypedefA @KotlinOnly constructor(value: String) : TypeSafeString(value) {
  companion object {
    /**
     * Creates a new instance from another wrapper's value. Useful for quick conversions.
     */
    @JvmStatic
    fun wrapFrom(other: TypeSafeString): TypedefA = wrap(other.get())

    @JvmStatic
    fun wrap(value: String): TypedefA = TypedefA(value)
  }
}
