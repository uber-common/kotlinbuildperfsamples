package com.uber.model.core.generated.example;

import androidx.annotation.Nullable;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.uber.model.core.adapter.gson.GsonSerializable;
import com.uber.model.core.adapter.gson.wrapper.TypeSafeLongTypeAdapter;
import java.io.IOException;
import javax.annotation.Generated;

@Generated(
  value = "GsonTypeProcessor",
  comments = "This code was generated by the Uber GsonTypeProcessor"
)
@GsonSerializable.ConstructorParameterCount(0)
final class TypedefD_GsonTypeAdapter extends TypeSafeLongTypeAdapter<TypedefD> {
  @Nullable
  @Override
  public TypedefD read(JsonReader in) throws IOException {
    if (in.peek() == JsonToken.NULL) {
      in.nextNull();
      return null;
    }
    return TypedefD.wrap(in.nextLong());
  }
}