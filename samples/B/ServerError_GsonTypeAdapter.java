package com.uber.model.core.generated.example;

import androidx.annotation.Nullable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.uber.model.core.adapter.gson.GsonSerializable;
import java.io.IOException;
import javax.annotation.Generated;

@Generated(
  value = "GsonTypeProcessor",
  comments = "This code was generated by the Uber GsonTypeProcessor"
)
@GsonSerializable.ConstructorParameterCount(1)
final class ServerError_GsonTypeAdapter extends TypeAdapter<ServerError> {
  private final Gson gson;

  @LazyInit private volatile TypeAdapter<InternalServerErrorCode> internalServerErrorCode_adapter;

  public ServerError_GsonTypeAdapter(Gson gson) {
    this.gson = gson;
  }

  @Override
  public void write(JsonWriter jsonWriter, ServerError object) throws IOException {
    if (object == null) {
      jsonWriter.nullValue();
      return;
    }
    jsonWriter.beginObject();
    jsonWriter.name("code");
    if (object.code() == null) {
      jsonWriter.nullValue();
    } else {
      if (internalServerErrorCode_adapter == null) {
        this.internalServerErrorCode_adapter =
            (gson.getAdapter(com.uber.model.core.generated.example.InternalServerErrorCode.class));
      }
      internalServerErrorCode_adapter.write(jsonWriter, object.code());
    }
    jsonWriter.name("message");
    jsonWriter.value(object.message());
    jsonWriter.endObject();
  }

  @Nullable
  @Override
  public ServerError read(JsonReader jsonReader) throws IOException {
    if (jsonReader.peek() == JsonToken.NULL) {
      jsonReader.nextNull();
      return null;
    }
    jsonReader.beginObject();
    ServerError.Builder _builder = ServerError.builder();
    while (jsonReader.hasNext()) {
      String _name = jsonReader.nextName();
      if (jsonReader.peek() == JsonToken.NULL) {
        jsonReader.nextNull();
        continue;
      }
      switch (_name) {
        case "code":
          {
            if (internalServerErrorCode_adapter == null) {
              this.internalServerErrorCode_adapter =
                  (gson.getAdapter(
                      com.uber.model.core.generated.example.InternalServerErrorCode.class));
            }
            _builder.code(internalServerErrorCode_adapter.read(jsonReader));
            break;
          }
        case "message":
          {
            _builder.message(jsonReader.nextString());
            break;
          }
        default:
          {
            jsonReader.skipValue();
          }
      }
    }
    jsonReader.endObject();
    return _builder.build();
  }
}
