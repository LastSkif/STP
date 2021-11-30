package com.example.stp

import com.example.stp.redactors.PNumberRedactor
import com.example.stp.redactors.TFracRedactor
import org.junit.Assert
import org.junit.Test

class PNumberRedactorUnitTest {

	@Test
	fun initTest() {
		val testPNumber1 = PNumberRedactor()
		val expect = "0"
		Assert.assertEquals(expect, testPNumber1.get())
	}

	@Test
	fun setTest() {
		val testPNumber1 = PNumberRedactor()
		testPNumber1.set("35")
		val expect = "35"
		Assert.assertEquals(expect, testPNumber1.get())
	}

	@Test
	fun isZeroTest() {
		val testPNumber1 = PNumberRedactor()
		val expect = true
		Assert.assertEquals(expect, testPNumber1.isZero())
	}

	@Test
	fun clearTest() {
		val testPNumber1 = PNumberRedactor()
		val expect = "0"
		testPNumber1.set("3")
		testPNumber1.clear()
		Assert.assertEquals(expect, testPNumber1.get())
	}

	@Test
	fun unaryMinusTest1() {
		val testPNumber1 = PNumberRedactor()
		testPNumber1.set("32")
		testPNumber1.unaryMinus()
		val expect = "-32"
		Assert.assertEquals(expect, testPNumber1.get())
	}

	@Test
	fun unaryMinusTest2() {
		val testPNumber1 = PNumberRedactor()
		testPNumber1.set("-32")
		testPNumber1.unaryMinus()
		val expect = "32"
		Assert.assertEquals(expect, testPNumber1.get())
	}

	@Test
	fun addDotTest() {
		val testPNumber1 = PNumberRedactor()
		testPNumber1.addDot()
		val expect = "0."
		Assert.assertEquals(expect, testPNumber1.get())
	}

	@Test
	fun addNumberTest() {
		val testPNumber1 = PNumberRedactor()
		testPNumber1.addNumber("3")
		val expect = "3"
		Assert.assertEquals(expect, testPNumber1.get())
	}

	@Test
	fun deleteRightTest() {
		val testPNumber1 = PNumberRedactor()
		testPNumber1.set("3a")
		testPNumber1.deleteRight()
		val expect = "3"
		Assert.assertEquals(expect, testPNumber1.get())
	}
}