package com.example.stp

import com.example.stp.mathclasses.PNumber
import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PNumberUnitTest {

	@Test
	fun initTest() {
		val testPNumber = PNumber("a3.0", 16, 1)
		val numberExpect = 163.0
		val numberResult = testPNumber.getNumberDecimal()
		val delta = 0.1
		assertEquals(numberExpect, numberResult, delta)
		val baseExpect = 16
		val baseResult = testPNumber.getBaseInt()
		assertEquals(baseExpect, baseResult)
		val precisionExpect = 1
		val precisionResult = testPNumber.getPrecisionInt()
		assertEquals(precisionExpect, precisionResult)
	}

	@Test
	fun initBaseExceptionTest() {
		val testPNumber = PNumber("10.0", 40, 1)
		val expect = 10
		val result = testPNumber.getBaseInt()
		assertEquals(expect, result)
	}

	@Test
	fun initWrongBaseExceptionTest() {
		val testPNumber = PNumber("1a.0", 10, 1)
		val expect = 10
		val result = testPNumber.getBaseInt()
		assertEquals(expect, result)
	}

	@Test
	fun initPrecisionExceptionTest() {
		val testPNumber = PNumber("10.0", 10, -3)
		val expect = 1
		val result = testPNumber.getPrecisionInt()
		assertEquals(expect, result)
	}

	@Test
	fun initWrongPrecisionExceptionTest() {
		val testPNumber = PNumber("10.abc", 16, 1)
		val expect = 3
		val result = testPNumber.getPrecisionInt()
		assertEquals(expect, result)
	}

	@Test
	fun plusTest() {
		var testPNumber1 = PNumber("-a2.23", 16, 4)
		var testPNumber2 = PNumber("a1.0", 16, 4)
		val delta = 0.1
		testPNumber1.plus(testPNumber2)
		val expect = -1.23
		assertEquals(expect, testPNumber1.getNumberDecimal(), delta)
	}

	@Test
	fun plusReturnTest() {
		var testPNumber1 = PNumber("-a2.23", 16, 4)
		var testPNumber2 = PNumber("a1.0", 12, 4)
		val delta = 0.1
		testPNumber1.plus(testPNumber2)
		val expect = -162.1367
		assertEquals(expect, testPNumber1.getNumberDecimal(), delta)
	}

	@Test
	fun minusTest() {
		val testPNumber1 = PNumber("10.0", 10, 1)
		val testPNumber2 = PNumber("10.0", 10, 1)
		val expect = 0.0
		val delta = 0.1
		testPNumber1.minus(testPNumber2)
		assertEquals(expect, testPNumber1.getNumberDecimal(), delta)
	}

	@Test
	fun minusReturnTest() {
		var testPNumber1 = PNumber("-a2.23", 16, 4)
		val testPNumber2 = PNumber("a1.0", 12, 4)
		val delta = 0.1
		testPNumber1.minus(testPNumber2)
		val expect = -162.1367
		assertEquals(expect, testPNumber1.getNumberDecimal(), delta)
	}

	@Test
	fun multTest() {
		var testPNumber1 = PNumber("a.0", 16, 4)
		val testPNumber2 = PNumber("c.0", 16, 4)
		val expect = 120.0
		val delta = 0.1
		testPNumber1.mult(testPNumber2)
		assertEquals(expect, testPNumber1.getNumberDecimal(), delta)
	}

	@Test
	fun multReturnTest() {
		var testPNumber1 = PNumber("a.0", 16, 4)
		var testPNumber2 = PNumber("c.0", 16, 2)
		val expect = 10.0
		val delta = 0.1
		testPNumber1.mult(testPNumber2)
		assertEquals(expect, testPNumber1.getNumberDecimal(), delta)
	}

	@Test
	fun divTest() {
		val testPNumber = PNumber("1a.0", 16, 1)
		val testPNumber2 = PNumber("1a.0", 16, 1)
		val expect = 1.0
		val delta = 0.1
		testPNumber.div(testPNumber2)
		assertEquals(expect, testPNumber.getNumberDecimal(), delta)
	}

	@Test
	fun divReturnTest() {
		val testPNumber1 = PNumber("10.0", 10, 1)
		val testPNumber2 = PNumber("0.0", 10, 1)
		val expect = 10.0
		val delta = 0.001
		val result = 10.0
		testPNumber1.div(testPNumber2)
		assertEquals(expect, result, delta)
	}

	@Test
	fun sqrTest() {
		val testPNumber = PNumber("10.0", 10, 1)
		val expect = 100.0
		val delta = 0.1
		testPNumber.sqr()
		assertEquals(expect, testPNumber.getNumberDecimal(), delta)
	}

	@Test
	fun revertTest() {
		val testPNumber = PNumber("7.0", 8, 1)
		val expect = 0.142
		val delta = 0.01
		testPNumber.revert()
		assertEquals(expect, testPNumber.getNumberDecimal(), delta)
	}

	@Test
	fun getNumberStringTest() {
		val testPNumber = PNumber("10.0", 10, 1)
		val expect = "10.0, base: 10, prec: 1"
		val result = testPNumber.toString()
		assertEquals(expect, result)
	}

	@Test
	fun getBaseIntTest() {
		val testPNumber = PNumber("10.0", 10, 1)
		val expect = 10
		val result = testPNumber.getBaseInt()
		assertEquals(expect, result)
	}

	@Test
	fun getBaseStringTest() {
		val testPNumber = PNumber("10.0", 10, 1)
		val expect = "10"
		val result = testPNumber.getBaseString()
		assertEquals(expect, result)
	}

	@Test
	fun getPrecisionIntTest() {
		val testPNumber = PNumber("10.0", 10, 4)
		val expect = 4
		val result = testPNumber.getPrecisionInt()
		assertEquals(expect, result)
	}

	@Test
	fun getPrecisionStringTest() {
		val testPNumber = PNumber("10.0", 10, 4)
		val expect = "4"
		val result = testPNumber.getPrecisionString()
		assertEquals(expect, result)
	}

	@Test
	fun setBaseTest() {
		val testPNumber = PNumber("10.0", 10, 4)
		testPNumber.setBase(4)
		val expect = 4
		val result = testPNumber.getBaseInt()
		assertEquals(expect, result)
	}

	@Test
	fun setPrecisionTest() {
		val testPNumber = PNumber("10.0", 10, 4)
		testPNumber.setPrecision(2)
		val expect = 2
		val result = testPNumber.getPrecisionInt()
		assertEquals(expect, result)
	}
}