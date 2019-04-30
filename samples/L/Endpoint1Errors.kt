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
import com.google.errorprone.annotations.RestrictedApi
import com.uber.presidio.realtime.core.RealtimeClient
import com.uber.presidio.realtime.core.error.Error
import com.uber.presidio.realtime.core.error.ErrorAdapter
import com.uber.presidio.realtime.core.error.RequestException
import java.io.IOException
import java.lang.Exception
import javax.annotation.Generated
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic
import kotlin.jvm.Throws

/**
 * Errors for [SampleServiceClient.endpoint1]
 */
@Generated(
    "ThriftCodeGen Compiler",
    comments = "This code was generated by the Uber ThriftCodeGen Compiler from: example.thrift"
)
@Immutable
class Endpoint1Errors private constructor(
  private val _code: String,
  @get:JvmName("badRequest") val badRequest: BadRequest? = null,
  @get:JvmName("unauthenticated") val unauthenticated: Unauthenticated? = null,
  @get:JvmName("serverError") val serverError: ServerError? = null,
  @get:JvmName("rateLimited") val rateLimited: RateLimited? = null,
  @get:JvmName("noContent") val noContent: NoContent? = null
) : Error() {
  internal val _toString: String by lazy<String> {
    val _presentField: String
    val _presentFieldValue: String
    if (badRequest != null) {
      _presentField = "badRequest"
      _presentFieldValue = badRequest.toString()
    } else if (unauthenticated != null) {
      _presentField = "unauthenticated"
      _presentFieldValue = unauthenticated.toString()
    } else if (serverError != null) {
      _presentField = "serverError"
      _presentFieldValue = serverError.toString()
    } else if (rateLimited != null) {
      _presentField = "rateLimited"
      _presentFieldValue = rateLimited.toString()
    } else {
      _presentField = "noContent"
      _presentFieldValue = noContent.toString()
    }
    return@lazy "Endpoint1Errors(" + _presentField + "=" + _presentFieldValue + ")"
  }


  override fun code(): String = _code

  override fun toString(): String = _toString

  companion object {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    @JvmStatic
    fun unknown(): Endpoint1Errors = Endpoint1Errors(UNKNOWN_CODE)

    @JvmStatic
    fun ofBadRequest(value: BadRequest): Endpoint1Errors = Endpoint1Errors(_code = "BAD_REQUEST",
        badRequest = value)

    @JvmStatic
    fun ofUnauthenticated(value: Unauthenticated): Endpoint1Errors = Endpoint1Errors(_code =
        "UNAUTHENTICATED", unauthenticated = value)

    @JvmStatic
    fun ofServerError(value: ServerError): Endpoint1Errors = Endpoint1Errors(_code = "SERVER_ERROR",
        serverError = value)

    @JvmStatic
    fun ofRateLimited(value: RateLimited): Endpoint1Errors = Endpoint1Errors(_code = "RATE_LIMITED",
        rateLimited = value)

    @JvmStatic
    fun ofNoContent(): Endpoint1Errors = Endpoint1Errors(_code = "", noContent = NoContent)

    @RestrictedApi(
        explanation = "This is intended only to be used from generated clients.",
        link = "",
        whitelistAnnotations = [Generated::class,
            RealtimeClient.TemporaryNonGeneratedRealtimeUsage::class]
    )
    @Throws(IOException::class)
    @Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")
    fun create(errorAdapter: ErrorAdapter): Endpoint1Errors {
      try {
        val requestException = errorAdapter.requestException()
        when (requestException.kind()) {
          RequestException.Kind.RPC_CODE -> {
            // RPC-style codes
            when (requestException.rpcCode()) {
              "rateLimited" -> {
                return ofRateLimited(errorAdapter.read<RateLimited>(RateLimited::class.java))
              }
            }
          }
          RequestException.Kind.STATUS_CODE -> {
            // REST-style HTTP status codes
            when (requestException.statusCode()) {
              400 -> {
                return ofBadRequest(errorAdapter.read<BadRequest>(BadRequest::class.java))
              }
              204 -> {
                errorAdapter.close()
                return ofNoContent()
              }
              500 -> {
                return ofServerError(errorAdapter.read<ServerError>(ServerError::class.java))
              }
              401 -> {
                return ofUnauthenticated(errorAdapter.read<Unauthenticated>(Unauthenticated::class.java))
              }
            }
          }
        }
      } catch (ignored: Exception) {
        // Gracefully fall back to unknown
      }
      return unknown()
    }
  }
}
