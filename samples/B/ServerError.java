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

package com.uber.model.core.generated.example;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.errorprone.annotations.Immutable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.uber.errorprone.annotations.DoNotMock;
import com.uber.errorprone.annotations.DoNotSubclass;
import com.uber.model.core.adapter.gson.GsonSerializable;
import com.uber.model.core.annotation.Property;
import com.uber.model.core.annotation.RequiredMethods;
import com.uber.model.core.annotation.ThriftElement;
import javax.annotation.Generated;

@Generated(
  value = "com.uber.codegen.compiler.JavaThriftCodeGenCodeGenerator",
  comments = "This code was generated by the Uber ThriftCodeGen Compiler from: example.thrift"
)
@ThriftElement
@DoNotMock("Create a real instance via the builder(), builderWithDefaults(), or stub().")
@Immutable
@DoNotSubclass("This should be treated as final, and is only non-final for legacy reasons")
@GsonSerializable(ServerError_GsonTypeAdapter.class)
public class ServerError {
  private final InternalServerErrorCode code;

  private final String message;

  @LazyInit private transient volatile String $toString;

  @LazyInit private transient volatile int $hashCode;

  @LazyInit private transient volatile boolean $hashCodeMemoized;

  private ServerError(InternalServerErrorCode code, String message) {
    this.code = code;
    this.message = message;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Property
  public InternalServerErrorCode code() {
    return code;
  }

  @Property
  public String message() {
    return message;
  }

  /** Initializes a builder to the same property values as as this existing instance's values. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @VisibleForTesting(otherwise = VisibleForTesting.NONE)
  public static Builder builderWithDefaults() {
    return builder().code(InternalServerErrorCode.values()[0]).message("Stub");
  }

  @VisibleForTesting(otherwise = VisibleForTesting.NONE)
  public static ServerError stub() {
    return builderWithDefaults().build();
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (o instanceof ServerError) {
      ServerError that = (ServerError) o;
      return this.code.equals(that.code) && this.message.equals(that.message);
    }
    return false;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "ServerError(" + "code=" + code + ", " + "message=" + message + ")";
    }
    return $toString;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int h = 1;
      h *= 1000003;
      h ^= code.hashCode();
      h *= 1000003;
      h ^= message.hashCode();
      $hashCode = h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @DoNotMock
  @ThriftElement.Builder
  public static final class Builder {
    @LazyInit private InternalServerErrorCode code;

    @LazyInit private String message;

    private Builder() {}

    private Builder(ServerError source) {
      this.code = source.code();
      this.message = source.message();
    }

    @SuppressWarnings("BannedClassNewInstance")
    public Builder code(InternalServerErrorCode code) {
      if (code == null) {
        throw new NullPointerException("Null code");
      }
      this.code = code;
      return this;
    }

    @SuppressWarnings("BannedClassNewInstance")
    public Builder message(String message) {
      if (message == null) {
        throw new NullPointerException("Null message");
      }
      this.message = message;
      return this;
    }

    /**
     * Builds an instance.
     *
     * <p><em>NOTE:</em> The following required properties must be set in order to be valid.
     *
     * <ul>
     *   <li>{@link #code}
     *   <li>{@link #message}
     * </ul>
     */
    @RequiredMethods({"code", "message"})
    public ServerError build() {
      String missingPropertySpecs = "";
      if (code == null) {
        missingPropertySpecs += " code";
      }
      if (message == null) {
        missingPropertySpecs += " message";
      }
      if (!missingPropertySpecs.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missingPropertySpecs);
      }
      return new ServerError(code, message);
    }
  }
}
