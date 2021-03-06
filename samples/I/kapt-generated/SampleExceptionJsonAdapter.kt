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

// Code generated by moshi-kotlin-codegen. Do not edit.
package com.uber.model.core.generated.example

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String

class SampleExceptionJsonAdapter(moshi: Moshi) : JsonAdapter<SampleException>() {
    private val options: JsonReader.Options =
            JsonReader.Options.of("optionalField1", "optionalField2", "requiredEnumField", "optionalField3", "optionalField4", "optionalField5", "optionalField6")

    private val nullableLongAdapter: JsonAdapter<Long?> =
            moshi.adapter<Long?>(Long::class.javaObjectType, kotlin.collections.emptySet(), "optionalField1")

    private val nullableDoubleAdapter: JsonAdapter<Double?> =
            moshi.adapter<Double?>(Double::class.javaObjectType, kotlin.collections.emptySet(), "optionalField2")

    private val sampleEnumAdapter: JsonAdapter<SampleEnum> =
            moshi.adapter<SampleEnum>(SampleEnum::class.java, kotlin.collections.emptySet(), "requiredEnumField")

    private val nullableTypedefBAdapter: JsonAdapter<TypedefB?> =
            moshi.adapter<TypedefB?>(TypedefB::class.java, kotlin.collections.emptySet(), "optionalField3")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "optionalField4")

    private val nullableIntAdapter: JsonAdapter<Int?> =
            moshi.adapter<Int?>(Int::class.javaObjectType, kotlin.collections.emptySet(), "optionalField5")

    private val nullableTypedefDAdapter: JsonAdapter<TypedefD?> =
            moshi.adapter<TypedefD?>(TypedefD::class.java, kotlin.collections.emptySet(), "optionalField6")

    override fun toString(): String = "GeneratedJsonAdapter(SampleException)"

    override fun fromJson(reader: JsonReader): SampleException {
        var optionalField1: Long? = null
        var optionalField1Set: Boolean = false
        var optionalField2: Double? = null
        var optionalField2Set: Boolean = false
        var requiredEnumField: SampleEnum? = null
        var optionalField3: TypedefB? = null
        var optionalField3Set: Boolean = false
        var optionalField4: String? = null
        var optionalField4Set: Boolean = false
        var optionalField5: Int? = null
        var optionalField5Set: Boolean = false
        var optionalField6: TypedefD? = null
        var optionalField6Set: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    optionalField1 = nullableLongAdapter.fromJson(reader)
                    optionalField1Set = true
                }
                1 ->  {
                    optionalField2 = nullableDoubleAdapter.fromJson(reader)
                    optionalField2Set = true
                }
                2 -> requiredEnumField = sampleEnumAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'requiredEnumField' was null at ${reader.path}")
                3 ->  {
                    optionalField3 = nullableTypedefBAdapter.fromJson(reader)
                    optionalField3Set = true
                }
                4 ->  {
                    optionalField4 = nullableStringAdapter.fromJson(reader)
                    optionalField4Set = true
                }
                5 ->  {
                    optionalField5 = nullableIntAdapter.fromJson(reader)
                    optionalField5Set = true
                }
                6 ->  {
                    optionalField6 = nullableTypedefDAdapter.fromJson(reader)
                    optionalField6Set = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = SampleException(
                requiredEnumField = requiredEnumField ?: throw JsonDataException("Required property 'requiredEnumField' missing at ${reader.path}"))
        result = result.copy(
                optionalField1 = if (optionalField1Set) optionalField1 else result.optionalField1,
                optionalField2 = if (optionalField2Set) optionalField2 else result.optionalField2,
                optionalField3 = if (optionalField3Set) optionalField3 else result.optionalField3,
                optionalField4 = if (optionalField4Set) optionalField4 else result.optionalField4,
                optionalField5 = if (optionalField5Set) optionalField5 else result.optionalField5,
                optionalField6 = if (optionalField6Set) optionalField6 else result.optionalField6)
        return result
    }

    override fun toJson(writer: JsonWriter, value: SampleException?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("optionalField1")
        nullableLongAdapter.toJson(writer, value.optionalField1)
        writer.name("optionalField2")
        nullableDoubleAdapter.toJson(writer, value.optionalField2)
        writer.name("requiredEnumField")
        sampleEnumAdapter.toJson(writer, value.requiredEnumField)
        writer.name("optionalField3")
        nullableTypedefBAdapter.toJson(writer, value.optionalField3)
        writer.name("optionalField4")
        nullableStringAdapter.toJson(writer, value.optionalField4)
        writer.name("optionalField5")
        nullableIntAdapter.toJson(writer, value.optionalField5)
        writer.name("optionalField6")
        nullableTypedefDAdapter.toJson(writer, value.optionalField6)
        writer.endObject()
    }
}
