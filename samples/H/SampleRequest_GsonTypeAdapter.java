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
final class SampleRequest_GsonTypeAdapter extends TypeAdapter<SampleRequest> {
  private final Gson gson;

  @LazyInit private volatile TypeAdapter<SampleEnum> sampleEnum_adapter;

  @LazyInit private volatile TypeAdapter<TypedefB> typedefB_adapter;

  @LazyInit private volatile TypeAdapter<TypedefD> typedefD_adapter;

  public SampleRequest_GsonTypeAdapter(Gson gson) {
    this.gson = gson;
  }

  @Override
  public void write(JsonWriter jsonWriter, SampleRequest object) throws IOException {
    if (object == null) {
      jsonWriter.nullValue();
      return;
    }
    jsonWriter.beginObject();
    jsonWriter.name("optionalField1");
    jsonWriter.value(object.optionalField1());
    jsonWriter.name("optionalField2");
    jsonWriter.value(object.optionalField2());
    jsonWriter.name("requiredEnumField");
    if (object.requiredEnumField() == null) {
      jsonWriter.nullValue();
    } else {
      if (sampleEnum_adapter == null) {
        this.sampleEnum_adapter =
            (gson.getAdapter(com.uber.model.core.generated.example.SampleEnum.class));
      }
      sampleEnum_adapter.write(jsonWriter, object.requiredEnumField());
    }
    jsonWriter.name("optionalField3");
    if (object.optionalField3() == null) {
      jsonWriter.nullValue();
    } else {
      if (typedefB_adapter == null) {
        this.typedefB_adapter =
            (gson.getAdapter(com.uber.model.core.generated.example.TypedefB.class));
      }
      typedefB_adapter.write(jsonWriter, object.optionalField3());
    }
    jsonWriter.name("optionalField4");
    jsonWriter.value(object.optionalField4());
    jsonWriter.name("optionalField5");
    jsonWriter.value(object.optionalField5());
    jsonWriter.name("optionalField6");
    if (object.optionalField6() == null) {
      jsonWriter.nullValue();
    } else {
      if (typedefD_adapter == null) {
        this.typedefD_adapter =
            (gson.getAdapter(com.uber.model.core.generated.example.TypedefD.class));
      }
      typedefD_adapter.write(jsonWriter, object.optionalField6());
    }
    jsonWriter.endObject();
  }

  @Nullable
  @Override
  public SampleRequest read(JsonReader jsonReader) throws IOException {
    if (jsonReader.peek() == JsonToken.NULL) {
      jsonReader.nextNull();
      return null;
    }
    jsonReader.beginObject();
    SampleRequest.Builder _builder = SampleRequest.builder();
    while (jsonReader.hasNext()) {
      String _name = jsonReader.nextName();
      if (jsonReader.peek() == JsonToken.NULL) {
        jsonReader.nextNull();
        continue;
      }
      switch (_name) {
        case "optionalField1":
          {
            _builder.optionalField1(jsonReader.nextLong());
            break;
          }
        case "optionalField2":
          {
            _builder.optionalField2(jsonReader.nextDouble());
            break;
          }
        case "requiredEnumField":
          {
            if (sampleEnum_adapter == null) {
              this.sampleEnum_adapter =
                  (gson.getAdapter(com.uber.model.core.generated.example.SampleEnum.class));
            }
            _builder.requiredEnumField(sampleEnum_adapter.read(jsonReader));
            break;
          }
        case "optionalField3":
          {
            if (typedefB_adapter == null) {
              this.typedefB_adapter =
                  (gson.getAdapter(com.uber.model.core.generated.example.TypedefB.class));
            }
            _builder.optionalField3(typedefB_adapter.read(jsonReader));
            break;
          }
        case "optionalField4":
          {
            _builder.optionalField4(jsonReader.nextString());
            break;
          }
        case "optionalField5":
          {
            _builder.optionalField5(jsonReader.nextInt());
            break;
          }
        case "optionalField6":
          {
            if (typedefD_adapter == null) {
              this.typedefD_adapter =
                  (gson.getAdapter(com.uber.model.core.generated.example.TypedefD.class));
            }
            _builder.optionalField6(typedefD_adapter.read(jsonReader));
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