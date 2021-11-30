package com.example.stp

import com.example.stp.mathclasses.TFrac
import com.example.stp.redactors.TFracRedactor
import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TFracRedactorUnitTest {

	@Test
	fun initTest() {
		val testFrac1 = TFracRedactor()
		val expect = "0/1"
		assertEquals(expect, testFrac1.get())
	}

	@Test
	fun setTest() {
		val testFrac1 = TFracRedactor()
		testFrac1.set("3/5")
		val expect = "3/5"
		assertEquals(expect, testFrac1.get())
	}

	@Test
	fun isZeroTest() {
		val testFrac1 = TFracRedactor()
		val expect = true
		assertEquals(expect, testFrac1.isZero())
	}

	@Test
	fun clearTest() {
		val testFrac1 = TFracRedactor()
		val expect = "0/1"
		testFrac1.set("3/2")
		testFrac1.clear()
		assertEquals(expect, testFrac1.get())
	}

	@Test
	fun unaryMinusTest() {
		val testFrac1 = TFracRedactor()
		testFrac1.set("3/2")
		testFrac1.unaryMinus()
		val expect = "-3/2"
		assertEquals(expect, testFrac1.get())
	}

	@Test
	fun addToNumeratorTest() {
		val testFrac1 = TFracRedactor()
		testFrac1.addToNumerator(3)
		val expect = "3/1"
		assertEquals(expect, testFrac1.get())
	}

	@Test
	fun addToDenominatorTest() {
		val testFrac1 = TFracRedactor()
		testFrac1.addToDenominator(3)
		val expect = "0/13"
		assertEquals(expect, testFrac1.get())
	}

	@Test
	fun deleteRightNumeratorTest() {
		val testFrac1 = TFracRedactor()
		testFrac1.set("3/5")
		testFrac1.deleteRightNumerator()
		val expect = "0/5"
		assertEquals(expect, testFrac1.get())
	}

	@Test
	fun deleteRightDenominatorTest() {
		val testFrac1 = TFracRedactor()
		testFrac1.set("3/23")
		testFrac1.deleteRightDenominator()
		val expect = "3/2"
		assertEquals(expect, testFrac1.get())
	}
}