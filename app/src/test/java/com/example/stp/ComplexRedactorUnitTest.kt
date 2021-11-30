package com.example.stp

import com.example.stp.redactors.ComplexRedactor
import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ComplexRedactorUnitTest {

	@Test
	fun initTest() {
		val complexRedactor1 = ComplexRedactor()
		val expect = "0 + 0i"
		assertEquals(expect, complexRedactor1.get())
	}

	@Test
	fun setTest() {
		val complexRedactor1 = ComplexRedactor()
		complexRedactor1.set("-3 + 1i")
		val expect = "-3 + 1i"
		assertEquals(expect, complexRedactor1.get())
	}

	@Test
	fun isZeroTest() {
		val complexRedactor1 = ComplexRedactor()
		val expect = true
		assertEquals(expect, complexRedactor1.isZero())
	}

	@Test
	fun clearTest() {
		val complexRedactor1 = ComplexRedactor()
		val expect = "0 + 0i"
		complexRedactor1.set("13.3 + -4i")
		complexRedactor1.clear()
		assertEquals(expect, complexRedactor1.get())
	}

	@Test
	fun realUnaryMinusTest() {
		val complexRedactor1 = ComplexRedactor()
		val expect = "-2 + 0i"
		complexRedactor1.set("2 + 0i")
		complexRedactor1.realUnaryMinus()
		assertEquals(expect, complexRedactor1.get())
	}

	@Test
	fun imagineUnaryMinusTest() {
		val complexRedactor1 = ComplexRedactor()
		val expect = "2 + -4i"
		complexRedactor1.set("2 + 4i")
		complexRedactor1.imagineUnaryMinus()
		assertEquals(expect, complexRedactor1.get())
	}

	@Test
	fun addDotToRealTest() {
		val complexRedactor1 = ComplexRedactor()
		val expect = "2. + 4i"
		complexRedactor1.set("2 + 4i")
		complexRedactor1.addDotToReal()
		assertEquals(expect, complexRedactor1.get())
	}

	@Test
	fun addDotToImagineTest() {
		val complexRedactor1 = ComplexRedactor()
		val expect = "2 + 4.i"
		complexRedactor1.set("2 + 4i")
		complexRedactor1.addDotToImagine()
		assertEquals(expect, complexRedactor1.get())
	}

	@Test
	fun addToRealTest() {
		val complexRedactor1 = ComplexRedactor()
		val expect = "21 + 4i"
		complexRedactor1.set("2 + 4i")
		complexRedactor1.addToReal(1)
		assertEquals(expect, complexRedactor1.get())
	}

	@Test
	fun addToImagineTest() {
		val complexRedactor1 = ComplexRedactor()
		val expect = "2 + 45i"
		complexRedactor1.set("2 + 4i")
		complexRedactor1.addToImagine(5)
		assertEquals(expect, complexRedactor1.get())
	}

	@Test
	fun deleteRightRealTest() {
		val complexRedactor1 = ComplexRedactor()
		val expect = "0 + 4i"
		complexRedactor1.set("4 + 4i")
		complexRedactor1.deleteRightReal()
		assertEquals(expect, complexRedactor1.get())
	}

	@Test
	fun deleteRightImagineTest() {
		val complexRedactor1 = ComplexRedactor()
		val expect = "2 + 0i"
		complexRedactor1.set("2 + 4i")
		complexRedactor1.deleteRightImagine()
		assertEquals(expect, complexRedactor1.get())
	}
}