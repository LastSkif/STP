package com.example.stp.mathclasses.polynom

import kotlin.math.pow

class Member(private var number: Int, private var degree: Int) {

	private var member = setMember()

	private fun setMember(): String = when (degree) {
		0    -> "$number"
		else -> "$number" + "x^$degree"
	}

	fun getDegree(): Int = this.degree

	override fun toString(): String = this.member

	fun setDegree(n: Int) {
		this.degree = n
		setMember()
	}

	fun setNumber(n: Int) {
		this.number
		setMember()
	}

	fun equal(q: Member): Boolean {
		return q.degree == this.degree && q.number == this.number
	}

	fun differentiate() {
		this.number *= this.degree
		this.degree--
		setMember()
	}

	fun value(n: Double): Double = n.pow(degree) * number.toDouble()

}