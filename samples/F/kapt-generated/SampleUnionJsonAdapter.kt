// Code generated by moshi-kotlin-codegen. Do not edit.
package com.uber.model.core.generated.example

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.Int
import kotlin.String

class SampleUnionJsonAdapter(moshi: Moshi) : JsonAdapter<SampleUnion>() {
    private val options: JsonReader.Options =
            JsonReader.Options.of("type", "option1", "option2", "option3")

    private val sampleUnionUnionTypeAdapter: JsonAdapter<SampleUnionUnionType> =
            moshi.adapter<SampleUnionUnionType>(SampleUnionUnionType::class.java, kotlin.collections.emptySet(), "type")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "option1")

    private val nullableBooleanAdapter: JsonAdapter<Boolean?> =
            moshi.adapter<Boolean?>(Boolean::class.javaObjectType, kotlin.collections.emptySet(), "option2")

    private val nullableIntAdapter: JsonAdapter<Int?> =
            moshi.adapter<Int?>(Int::class.javaObjectType, kotlin.collections.emptySet(), "option3")

    override fun toString(): String = "GeneratedJsonAdapter(SampleUnion)"

    override fun fromJson(reader: JsonReader): SampleUnion {
        var type: SampleUnionUnionType? = null
        var option1: String? = null
        var option1Set: Boolean = false
        var option2: Boolean? = null
        var option2Set: Boolean = false
        var option3: Int? = null
        var option3Set: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 -> type = sampleUnionUnionTypeAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'type' was null at ${reader.path}")
                1 ->  {
                    option1 = nullableStringAdapter.fromJson(reader)
                    option1Set = true
                }
                2 ->  {
                    option2 = nullableBooleanAdapter.fromJson(reader)
                    option2Set = true
                }
                3 ->  {
                    option3 = nullableIntAdapter.fromJson(reader)
                    option3Set = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = SampleUnion()
        result = result.copy(
                type = type ?: result.type,
                option1 = if (option1Set) option1 else result.option1,
                option2 = if (option2Set) option2 else result.option2,
                option3 = if (option3Set) option3 else result.option3)
        return result
    }

    override fun toJson(writer: JsonWriter, value: SampleUnion?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("type")
        sampleUnionUnionTypeAdapter.toJson(writer, value.type)
        writer.name("option1")
        nullableStringAdapter.toJson(writer, value.option1)
        writer.name("option2")
        nullableBooleanAdapter.toJson(writer, value.option2)
        writer.name("option3")
        nullableIntAdapter.toJson(writer, value.option3)
        writer.endObject()
    }
}