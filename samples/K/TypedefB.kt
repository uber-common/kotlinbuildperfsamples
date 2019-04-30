package com.uber.model.core.generated.example

import com.google.errorprone.annotations.Immutable
import com.uber.errorprone.annotations.DoNotMock
import com.uber.errorprone.annotations.KotlinOnly
import com.uber.model.core.annotation.ThriftElement
import com.uber.model.core.annotation.TypeSafeWrapper
import com.uber.model.core.wrapper.TypeSafeInt
import javax.annotation.Generated
import kotlin.Int
import kotlin.jvm.JvmStatic

@Generated(
    "com.uber.codegen.compiler.KotlinThriftCodeGenCodeGenerator",
    comments = "This code was generated by the Uber ThriftCodeGen Compiler from: example.thrift"
)
@ThriftElement
@Immutable
@DoNotMock("Create a real instance via wrap().")
@TypeSafeWrapper
data class TypedefB @KotlinOnly constructor(private val value: Int) : TypeSafeInt {
  override fun get() = value

  override fun toString() = value.toString()

  companion object {
    /**
     * Creates a new instance from another wrapper's value. Useful for quick conversions.
     */
    @JvmStatic
    fun wrapFrom(other: TypeSafeInt) = wrap(other.get())

    @JvmStatic
    fun wrap(value: Int) = TypedefB(value)
  }
}