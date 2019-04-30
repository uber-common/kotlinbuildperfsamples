// Code generated by moshi-kotlin-codegen. Do not edit.
package com.uber.model.core.generated.example

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import javax.annotation.Generated
import kotlin.String

@Generated(
        value = ["class com.uber.codegen.typeprocessors.moshi.MoshiKotlinTypeProcessor"],
        comments = "Generated from ThriftCodeGen"
)
class RateLimitedJsonAdapter(moshi: Moshi) : JsonAdapter<RateLimited>() {
    private val options: JsonReader.Options = JsonReader.Options.of("code", "message")

    private val rateLimitedCodeAdapter: JsonAdapter<RateLimitedCode> =
            moshi.adapter<RateLimitedCode>(RateLimitedCode::class.java,
            kotlin.collections.emptySet(), "code")

    private val stringAdapter: JsonAdapter<String> = moshi.adapter<String>(String::class.java,
            kotlin.collections.emptySet(), "message")

    override fun toString(): String = "GeneratedJsonAdapter(RateLimited)"

    override fun fromJson(reader: JsonReader): RateLimited {
        var code: RateLimitedCode? = null
        var message: String? = null
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 -> code = rateLimitedCodeAdapter.fromJson(reader) ?:
                        throw JsonDataException("""Non-null value 'code' was null at ${reader.path}""")
                1 -> message = stringAdapter.fromJson(reader) ?:
                        throw JsonDataException("""Non-null value 'message' was null at ${reader.path}""")
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = RateLimited(
                code = code ?:
                        throw JsonDataException("""Required property 'code' missing at ${reader.path}"""),
                message = message ?:
                        throw JsonDataException("""Required property 'message' missing at ${reader.path}"""))
        return result
    }

    override fun toJson(writer: JsonWriter, value: RateLimited?) {
        if (value == null) {
            throw
                    NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("code")
        rateLimitedCodeAdapter.toJson(writer, value.code)
        writer.name("message")
        stringAdapter.toJson(writer, value.message)
        writer.endObject()
    }
}
