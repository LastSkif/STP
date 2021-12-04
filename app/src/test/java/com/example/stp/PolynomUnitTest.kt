package com.example.stp

import com.example.stp.mathclasses.polynom.Polynom
import com.example.stp.mathclasses.polynom.Member
import org.junit.Assert
import org.junit.Test

class PolynomUnitTest {

	@Test
	fun maxDegreeTest() {
		val pol = Polynom()
		pol.addMember(Member(2, 3))
		pol.addMember(Member(4, 1))
		pol.addMember(Member(2, 0))

		val expect = 3
		Assert.assertEquals(expect, pol.maxDegree())
	}

	@Test
	fun getNumberTest() {
		val pol = Polynom()
		pol.addMember(Member(3, 2))
		pol.addMember(Member(4, 1))
		pol.addMember(Member(3, 0))

		val expect = 2
		Assert.assertEquals(expect, pol.getNumber(3))
	}

	@Test
	fun cleanTest1() {
		val pol = Polynom()
		pol.addMember(Member(2, 2))
		pol.addMember(Member(-4, 1))
		pol.clear()

		val expect = Polynom()
		Assert.assertEquals(expect.setPolynom(), pol.setPolynom())
	}

	@Test
	fun plusPolynomTest1() {
		val pol = Polynom()
		pol.addMember(Member(2, 2))
		pol.addMember(Member(-4, 1))

		val pol2 = Polynom()
		pol2.addMember(Member(3, 2))
		pol2.addMember(Member(1, 1))

		val pol3 = pol.plusPolynom(pol2)
		val expect = "+5x^2-3x^1"
		Assert.assertEquals(expect, pol3.setPolynom())
	}

	@Test
	fun plusPolynomTest2() {
		val pol = Polynom()
		pol.addMember(Member(2, 2))

		val pol2 = Polynom()
		pol2.addMember(Member(3, 2))
		pol2.addMember(Member(-3, 0))

		val pol3 = pol.plusPolynom(pol2)
		val expect = "+5x^2-3"
		Assert.assertEquals(expect, pol3.setPolynom())
	}

	@Test
	fun plusPolynomTest3() {
		val pol = Polynom()
		pol.addMember(Member(2, 2))
		pol.addMember(Member(-3, 0))

		val pol2 = Polynom()
		pol2.addMember(Member(3, 2))

		val pol3 = pol.plusPolynom(pol2)
		val expect = "+5x^2-3"
		Assert.assertEquals(expect, pol3.setPolynom())
	}

	@Test
	fun minusPolynomTest1() {
		val pol = Polynom()
		pol.addMember(Member(2, 2))
		pol.addMember(Member(1, 1))

		val pol2 = Polynom()
		pol2.addMember(Member(3, 2))
		pol2.addMember(Member(-1, 1))

		val pol3 = pol.minusPolynom(pol2)
		val expect = "-1x^2+2x^1"
		Assert.assertEquals(expect, pol3.setPolynom())
	}

	@Test
	fun minusPolynomTest2() {
		val pol = Polynom()
		pol.addMember(Member(2, 2))

		val pol2 = Polynom()
		pol2.addMember(Member(3, 2))
		pol2.addMember(Member(-3, 0))

		val pol3 = pol.minusPolynom(pol2)
		val expect = "-1x^2-3"
		Assert.assertEquals(expect, pol3.setPolynom())
	}

	@Test
	fun minusPolynomTest3() {
		val pol = Polynom()
		pol.addMember(Member(2, 2))
		pol.addMember(Member(-3, 0))

		val pol2 = Polynom()
		pol2.addMember(Member(3, 2))

		val pol3 = pol.minusPolynom(pol2)
		val expect = "-1x^2-3"
		Assert.assertEquals(expect, pol3.setPolynom())
	}

	@Test
	fun mulPolynomTest1() {
		val pol = Polynom()
		val pol2 = Polynom()

		pol.addMember(Member(2, 4))
		pol.addMember(Member(5, 3))

		pol2.addMember(Member(3, 2))
		pol2.addMember(Member(4, 1))

		val pol3 = pol.mulPolynom(pol2)
		val expect = "+6x^6+8x^5+15x^5+20x^4"
		Assert.assertEquals(expect, pol3.setPolynom())
	}

	@Test
	fun unaryMinusTest1() {
		val pol = Polynom()
		pol.addMember(Member(2, 4))
		pol.addMember(Member(5, 3))

		val pol3 = pol.unaryMinus()
		val expect = "-2x^4-5x^3"
		Assert.assertEquals(expect, pol3.setPolynom())
	}

	@Test
	fun equalTest1() {
		val pol = Polynom()
		pol.addMember(Member(2, 4))
		pol.addMember(Member(5, 3))

		val pol2 = Polynom()
		pol2.addMember(Member(5, 3))
		pol2.addMember(Member(2, 4))

		Assert.assertEquals(true, pol.equal(pol2))
	}

	@Test
	fun equalTest2() {
		val pol = Polynom()
		pol.addMember(Member(1, 4))
		pol.addMember(Member(5, 3))

		val pol2 = Polynom()
		pol2.addMember(Member(5, 3))
		pol2.addMember(Member(2, 4))

		Assert.assertEquals(false, pol.equal(pol2))
	}

	@Test
	fun equalTest3() {
		val pol = Polynom()
		pol.addMember(Member(2, 5))
		pol.addMember(Member(5, 3))

		val pol2 = Polynom()
		pol2.addMember(Member(5, 3))
		pol2.addMember(Member(2, 4))

		Assert.assertEquals(false, pol.equal(pol2))
	}

	@Test
	fun diffTest3() {
		val pol = Polynom()
		pol.addMember(Member(2, 5))
		pol.addMember(Member(5, 3))
		pol.addMember(Member(6, 0))

		val expect = "+10x^4+15x^2"
		Assert.assertEquals(expect, pol.differentiate().setPolynom())
	}

	@Test
	fun getElementTest1() {
		val pol = Polynom()
		pol.addMember(Member(2, 5))
		pol.addMember(Member(5, 3))
		pol.addMember(Member(6, 0))

		val expect = "5x^3"
		Assert.assertEquals(expect, pol.getElement(2))
	}

	@Test
	fun getElementTest2() {
		val pol = Polynom()
		pol.addMember(Member(2, 5))
		pol.addMember(Member(5, 3))
		pol.addMember(Member(6, 0))

		val expect = "No such element"
		Assert.assertEquals(expect, pol.getElement(0))
	}

	@Test
	fun getElementTest3() {
		val pol = Polynom()
		pol.addMember(Member(2, 5))
		pol.addMember(Member(5, 3))
		pol.addMember(Member(6, 0))

		val expect = "No such element"
		Assert.assertEquals(expect, pol.getElement(4))
	}
}