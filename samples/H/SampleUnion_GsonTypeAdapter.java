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
final class SampleUnion_GsonTypeAdapter extends TypeAdapter<SampleUnion> {
  private final Gson gson;

  @LazyInit private volatile TypeAdapter<SampleUnionUnionType> sampleUnionUnionType_adapter;

  public SampleUnion_GsonTypeAdapter(Gson gson) {
    this.gson = gson;
  }

  @Override
  public void write(JsonWriter jsonWriter, SampleUnion object) throws IOException {
    if (object == null) {
      jsonWriter.nullValue();
      return;
    }
    jsonWriter.beginObject();
    jsonWriter.name("type");
    if (object.type() == null) {
      jsonWriter.nullValue();
    } else {
      if (sampleUnionUnionType_adapter == null) {
        this.sampleUnionUnionType_adapter =
            (gson.getAdapter(com.uber.model.core.generated.example.SampleUnionUnionType.class));
      }
      sampleUnionUnionType_adapter.write(jsonWriter, object.type());
    }
    jsonWriter.name("option1");
    jsonWriter.value(object.option1());
    jsonWriter.name("option2");
    jsonWriter.value(object.option2());
    jsonWriter.name("option3");
    jsonWriter.value(object.option3());
    jsonWriter.endObject();
  }

  @Nullable
  @Override
  public SampleUnion read(JsonReader jsonReader) throws IOException {
    if (jsonReader.peek() == JsonToken.NULL) {
      jsonReader.nextNull();
      return null;
    }
    jsonReader.beginObject();
    SampleUnion.Builder _builder = SampleUnion.builder();
    while (jsonReader.hasNext()) {
      String _name = jsonReader.nextName();
      if (jsonReader.peek() == JsonToken.NULL) {
        jsonReader.nextNull();
        continue;
      }
      switch (_name) {
        case "type":
          {
            if (sampleUnionUnionType_adapter == null) {
              this.sampleUnionUnionType_adapter =
                  (gson.getAdapter(
                      com.uber.model.core.generated.example.SampleUnionUnionType.class));
            }
            SampleUnionUnionType localType = sampleUnionUnionType_adapter.read(jsonReader);
            // This is an enum with a fallback value, defer to the builder if null
            if (localType != null) {
              _builder.type(localType);
            }
            break;
          }
        case "option1":
          {
            _builder.option1(jsonReader.nextString());
            break;
          }
        case "option2":
          {
            _builder.option2(jsonReader.nextBoolean());
            break;
          }
        case "option3":
          {
            _builder.option3(jsonReader.nextInt());
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
