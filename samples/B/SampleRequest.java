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
@GsonSerializable(SampleRequest_GsonTypeAdapter.class)
public class SampleRequest {
  @Nullable private final Long optionalField1;

  @Nullable private final Double optionalField2;

  private final SampleEnum requiredEnumField;

  @Nullable private final TypedefB optionalField3;

  @Nullable private final String optionalField4;

  @Nullable private final Integer optionalField5;

  @Nullable private final TypedefD optionalField6;

  @LazyInit private transient volatile String $toString;

  @LazyInit private transient volatile int $hashCode;

  @LazyInit private transient volatile boolean $hashCodeMemoized;

  private SampleRequest(
      @Nullable Long optionalField1,
      @Nullable Double optionalField2,
      SampleEnum requiredEnumField,
      @Nullable TypedefB optionalField3,
      @Nullable String optionalField4,
      @Nullable Integer optionalField5,
      @Nullable TypedefD optionalField6) {
    this.optionalField1 = optionalField1;
    this.optionalField2 = optionalField2;
    this.requiredEnumField = requiredEnumField;
    this.optionalField3 = optionalField3;
    this.optionalField4 = optionalField4;
    this.optionalField5 = optionalField5;
    this.optionalField6 = optionalField6;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Property
  @Nullable
  public Long optionalField1() {
    return optionalField1;
  }

  @Property
  @Nullable
  public Double optionalField2() {
    return optionalField2;
  }

  @Property
  public SampleEnum requiredEnumField() {
    return requiredEnumField;
  }

  @Property
  @Nullable
  public TypedefB optionalField3() {
    return optionalField3;
  }

  @Property
  @Nullable
  public String optionalField4() {
    return optionalField4;
  }

  @Property
  @Nullable
  public Integer optionalField5() {
    return optionalField5;
  }

  @Property
  @Nullable
  public TypedefD optionalField6() {
    return optionalField6;
  }

  /** Initializes a builder to the same property values as as this existing instance's values. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @VisibleForTesting(otherwise = VisibleForTesting.NONE)
  public static Builder builderWithDefaults() {
    return builder().requiredEnumField(SampleEnum.values()[0]);
  }

  @VisibleForTesting(otherwise = VisibleForTesting.NONE)
  public static SampleRequest stub() {
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
    if (o instanceof SampleRequest) {
      SampleRequest that = (SampleRequest) o;
      return ((this.optionalField1 == null)
              ? (that.optionalField1 == null)
              : this.optionalField1.equals(that.optionalField1))
          && ((this.optionalField2 == null)
              ? (that.optionalField2 == null)
              : this.optionalField2.equals(that.optionalField2))
          && this.requiredEnumField.equals(that.requiredEnumField)
          && ((this.optionalField3 == null)
              ? (that.optionalField3 == null)
              : this.optionalField3.equals(that.optionalField3))
          && ((this.optionalField4 == null)
              ? (that.optionalField4 == null)
              : this.optionalField4.equals(that.optionalField4))
          && ((this.optionalField5 == null)
              ? (that.optionalField5 == null)
              : this.optionalField5.equals(that.optionalField5))
          && ((this.optionalField6 == null)
              ? (that.optionalField6 == null)
              : this.optionalField6.equals(that.optionalField6));
    }
    return false;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString =
          "SampleRequest("
              + "optionalField1="
              + optionalField1
              + ", "
              + "optionalField2="
              + optionalField2
              + ", "
              + "requiredEnumField="
              + requiredEnumField
              + ", "
              + "optionalField3="
              + optionalField3
              + ", "
              + "optionalField4="
              + optionalField4
              + ", "
              + "optionalField5="
              + optionalField5
              + ", "
              + "optionalField6="
              + optionalField6
              + ")";
    }
    return $toString;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int h = 1;
      h *= 1000003;
      h ^= (optionalField1 == null) ? 0 : optionalField1.hashCode();
      h *= 1000003;
      h ^= (optionalField2 == null) ? 0 : optionalField2.hashCode();
      h *= 1000003;
      h ^= requiredEnumField.hashCode();
      h *= 1000003;
      h ^= (optionalField3 == null) ? 0 : optionalField3.hashCode();
      h *= 1000003;
      h ^= (optionalField4 == null) ? 0 : optionalField4.hashCode();
      h *= 1000003;
      h ^= (optionalField5 == null) ? 0 : optionalField5.hashCode();
      h *= 1000003;
      h ^= (optionalField6 == null) ? 0 : optionalField6.hashCode();
      $hashCode = h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @DoNotMock
  @ThriftElement.Builder
  public static final class Builder {
    @Nullable private Long optionalField1 = null;

    @Nullable private Double optionalField2 = null;

    @LazyInit private SampleEnum requiredEnumField;

    @Nullable private TypedefB optionalField3 = null;

    @Nullable private String optionalField4 = null;

    @Nullable private Integer optionalField5 = null;

    @Nullable private TypedefD optionalField6 = null;

    private Builder() {}

    private Builder(SampleRequest source) {
      this.optionalField1 = source.optionalField1();
      this.optionalField2 = source.optionalField2();
      this.requiredEnumField = source.requiredEnumField();
      this.optionalField3 = source.optionalField3();
      this.optionalField4 = source.optionalField4();
      this.optionalField5 = source.optionalField5();
      this.optionalField6 = source.optionalField6();
    }

    public Builder optionalField1(@Nullable Long optionalField1) {
      this.optionalField1 = optionalField1;
      return this;
    }

    public Builder optionalField2(@Nullable Double optionalField2) {
      this.optionalField2 = optionalField2;
      return this;
    }

    @SuppressWarnings("BannedClassNewInstance")
    public Builder requiredEnumField(SampleEnum requiredEnumField) {
      if (requiredEnumField == null) {
        throw new NullPointerException("Null requiredEnumField");
      }
      this.requiredEnumField = requiredEnumField;
      return this;
    }

    public Builder optionalField3(@Nullable TypedefB optionalField3) {
      this.optionalField3 = optionalField3;
      return this;
    }

    public Builder optionalField4(@Nullable String optionalField4) {
      this.optionalField4 = optionalField4;
      return this;
    }

    public Builder optionalField5(@Nullable Integer optionalField5) {
      this.optionalField5 = optionalField5;
      return this;
    }

    public Builder optionalField6(@Nullable TypedefD optionalField6) {
      this.optionalField6 = optionalField6;
      return this;
    }

    /**
     * Builds an instance.
     *
     * <p><em>NOTE:</em> The following required properties must be set in order to be valid.
     *
     * <ul>
     *   <li>{@link #requiredEnumField}
     * </ul>
     */
    @RequiredMethods({"requiredEnumField"})
    public SampleRequest build() {
      String missingPropertySpecs = "";
      if (requiredEnumField == null) {
        missingPropertySpecs += " requiredEnumField";
      }
      if (!missingPropertySpecs.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missingPropertySpecs);
      }
      return new SampleRequest(
          optionalField1,
          optionalField2,
          requiredEnumField,
          optionalField3,
          optionalField4,
          optionalField5,
          optionalField6);
    }
  }
}