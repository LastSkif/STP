package com.example.stp

import com.example.stp.computing.Memory
import com.example.stp.mathclasses.Complex
import com.example.stp.mathclasses.PNumber
import com.example.stp.mathclasses.TFrac
import org.junit.Assert
import org.junit.Test

class MemoryUnitTest {

	@Test
	fun initTest() {
		val testMemory = Memory<Complex>(Complex("4 + 8i"))
		val testComplex2 = Complex("4 + 8i")
		val expect = "true"
		Assert.assertEquals(expect, testMemory.getState())
	}

	@Test
	fun clearTest1() {
		val testMemory = Memory<TFrac>(TFrac("1/5"))
		val expect = "0/1"
		Assert.assertEquals(expect, testMemory.clear())
	}

	@Test
	fun clearTest2() {
		val testMemory = Memory<Complex>(Complex("1 + 0i"))
		val expect = "0.0 + 0.0i"
		Assert.assertEquals(expect, testMemory.clear())
	}

	@Test
	fun clearTest3() {
		val testMemory = Memory<PNumber>(PNumber("10", 8, 1))
		val expect = "0, base: 10, prec: 1"
		Assert.assertEquals(expect, testMemory.clear())
	}

	@Test
	fun getTest1() {
		val testMemory = Memory<TFrac>(TFrac("1/5"))
		val expect = TFrac("1/5")
		Assert.assertEquals(true, expect.equal(testMemory.getNumber()))
	}

	@Test
	fun getTest2() {
		val testMemory = Memory<Complex>(Complex("1 + 0i"))
		val expect = Complex("1 + 0i")
		Assert.assertEquals(true, expect.equal(testMemory.getNumber()))
	}

	@Test
	fun getTest3() {
		val testMemory = Memory<PNumber>(PNumber("10", 8, 1))
		val expect = PNumber("10", 8, 1)
		Assert.assertEquals(true, expect.equal(testMemory.getNumber()))
	}

	@Test
	fun plusTest1() {
		val testMemory = Memory<TFrac>(TFrac("1/5"))
		val expect = TFrac("1/5")
		testMemory.plus(expect)
		Assert.assertEquals("2/5", testMemory.getNumber().toString())
	}

	@Test
	fun plusTest2() {
		val testMemory1 = Memory<PNumber>(PNumber("-a2.23", 16, 4))
		val expect = PNumber("a1.0", 16, 4)
		testMemory1.plus(expect)
		Assert.assertEquals("-1.2300, base: 16, prec: 4", testMemory1.getNumber().toString())
	}

	@Test
	fun plusTest3() {
		val testMemory = Memory<Complex>(Complex("1 + 1i"))
		val expect = Complex("1 + 1i")
		testMemory.plus(expect)
		Assert.assertEquals("2.0 + 2.0i", testMemory.getNumber().toString())
	}
}