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
import com.squareup.moshi.Types
import com.ubercab.common.collect.ImmutableMap
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.String

class BadRequestJsonAdapter(moshi: Moshi) : JsonAdapter<BadRequest>() {
    private val options: JsonReader.Options = JsonReader.Options.of("code", "message", "data")

    private val badRequestCodeAdapter: JsonAdapter<BadRequestCode> =
            moshi.adapter<BadRequestCode>(BadRequestCode::class.java, kotlin.collections.emptySet(), "code")

    private val stringAdapter: JsonAdapter<String> =
            moshi.adapter<String>(String::class.java, kotlin.collections.emptySet(), "message")

    private val nullableImmutableMapOfStringStringAdapter: JsonAdapter<ImmutableMap<String, String>?> =
            moshi.adapter<ImmutableMap<String, String>?>(Types.newParameterizedType(ImmutableMap::class.java, String::class.java, String::class.java), kotlin.collections.emptySet(), "data")

    override fun toString(): String = "GeneratedJsonAdapter(BadRequest)"

    override fun fromJson(reader: JsonReader): BadRequest {
        var code: BadRequestCode? = null
        var message: String? = null
        var data: ImmutableMap<String, String>? = null
        var dataSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 -> code = badRequestCodeAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'code' was null at ${reader.path}")
                1 -> message = stringAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'message' was null at ${reader.path}")
                2 ->  {
                    data = nullableImmutableMapOfStringStringAdapter.fromJson(reader)
                    dataSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = BadRequest(
                code = code ?: throw JsonDataException("Required property 'code' missing at ${reader.path}"),
                message = message ?: throw JsonDataException("Required property 'message' missing at ${reader.path}"))
        result = result.copy(
                data = if (dataSet) data else result.data)
        return result
    }

    override fun toJson(writer: JsonWriter, value: BadRequest?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("code")
        badRequestCodeAdapter.toJson(writer, value.code)
        writer.name("message")
        stringAdapter.toJson(writer, value.message)
        writer.name("data")
        nullableImmutableMapOfStringStringAdapter.toJson(writer, value.data)
        writer.endObject()
    }
}
