package com.example.stp

import com.example.stp.mathclasses.polynom.Member
import org.junit.Assert
import org.junit.Test

class MemberUnitTest {

	@Test
	fun getDegreeTest() {
		val member = Member(2,3)

		val expect = 3
		Assert.assertEquals(expect, member.getDegree())
	}

	@Test
	fun setDegreeTest() {
		val member = Member(2,3)
		member.setDegree(4)

		val expect = 4
		Assert.assertEquals(expect, member.getDegree())
	}

	@Test
	fun setNumberTest() {
		val member = Member(2,3)
		member.setNumber(5)

		val expect = 5
		Assert.assertEquals(expect, member.getNumber())
	}

	@Test
	fun equalTest1() {
		val member = Member(2,3)
		val member2 = Member(2,3)

		val expect = true
		Assert.assertEquals(expect, member.equal(member2))
	}

	@Test
	fun equalTest2() {
		val member = Member(2,3)
		val member2 = Member(2,4)

		val expect = false
		Assert.assertEquals(expect, member.equal(member2))
	}

	@Test
	fun equalTest3() {
		val member = Member(2,3)
		val member2 = Member(3,3)

		val expect = false
		Assert.assertEquals(expect, member.equal(member2))
	}

	@Test
	fun differentiateTest() {
		val member = Member(4,5)
		member.differentiate()

		val expect = "20x^4"
		Assert.assertEquals(expect, member.setMember())
	}

	@Test
	fun valueTest() {
		val member = Member(4,5)

		val expect = 128.0
		val delta = 0.1
		Assert.assertEquals(expect, member.value(2.0), delta)
	}

	@Test
	fun setMemberTest() {
		val member = Member(4,5)

		val expect = "4x^5"
		Assert.assertEquals(expect, member.setMember())
	}
}