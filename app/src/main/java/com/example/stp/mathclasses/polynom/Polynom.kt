package com.example.stp.mathclasses.polynom

class Polynom {

	private var members = listOf<Member>()
	private var polynomString: String = ""

	private fun setPolynom() {
		members.forEach {
			polynomString += it.toString()
		}
	}

	fun clear() {
		polynomString = ""
		members = emptyList()
	}

	fun getMember(i: Int) = members.elementAt(i)

}