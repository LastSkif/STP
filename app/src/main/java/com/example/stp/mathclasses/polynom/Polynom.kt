package com.example.stp.mathclasses.polynom

class Polynom {

	private var members = mutableListOf<Member>()
	private var polynomString: String = ""

	fun addMember(member: Member) {
		members.add(member)
	}

	fun maxDegree(): Int {
		var maxDegree = Int.MIN_VALUE
		members.forEach {
			if (it.getDegree() > maxDegree) {
				maxDegree = it.getDegree()
			}
		}
		return maxDegree
	}

	fun getNumber(coeff: Int): Int {
		var numberCount = 0
		members.forEach {
			if(it.getNumber() == coeff) numberCount ++
		}
		return numberCount
	}

	fun clear() {
		polynomString = ""
		members.removeAll(members)
	}

	fun getMember(i: Int) = members.elementAt(i)

	fun setPolynom(): String {
		members.forEach {
			if (it.getNumber() > 0) polynomString += "+$it"
			else polynomString += "$it"

		}
		return polynomString
	}

	private fun correctPolynom() {
		members.forEach { first ->
			members.forEach { second ->
				if (first.getDegree() == second.getDegree()) first.setNumber(1)
			}
		}
	}

	fun getElement(i: Int): String {
		var index = i
		var result = "No such element"
		if (i <= members.size && i > 0) {
			members.forEach { first ->
				index--
				if (index == 0) result = first.toString()
			}
		}
		return result
	}

	fun differentiate(): Polynom {
		val membersSum = mutableListOf<Member>()
		members.forEach { first ->
			if (first.getDegree() - 1 >= 0) membersSum.add(Member(first.getNumber() * first.getDegree(), first.getDegree() - 1))
		}
		val polynomSum = Polynom()
		polynomSum.members = membersSum
		return polynomSum
	}

	fun equal(polynom: Polynom): Boolean {
		val membersSum = mutableListOf<Member>()
		var testForEq: Boolean
		var equalResult = true
		members.forEach { first ->
			testForEq = false
			polynom.members.forEach { second ->
				if (first.getDegree() == second.getDegree()) {
					if (first.getNumber() == second.getNumber()) {
						testForEq = true
					}
				}
			}
			if (!testForEq) {
				equalResult = false
			}
		}
		return equalResult
	}

	fun unaryMinus(): Polynom {
		val membersSum = mutableListOf<Member>()
		members.forEach { first ->
			membersSum.add(Member(first.getNumber() * -1, first.getDegree()))
		}
		val polynomSum = Polynom()
		polynomSum.members = membersSum
		return polynomSum
	}

	fun mulPolynom(polynom: Polynom): Polynom {
		val membersSum = mutableListOf<Member>()
		members.forEach { first ->
			polynom.members.forEach { second ->
				membersSum.add(Member(first.getNumber() * second.getNumber(), first.getDegree() + second.getDegree()))
			}
		}
		val polynomSum = Polynom()
		polynomSum.members = membersSum
		return polynomSum
	}

	fun plusPolynom(polynom: Polynom): Polynom {
		val membersSum = mutableListOf<Member>()
		var testForNum: Boolean
		members.forEach { first ->
			testForNum = true

			polynom.members.forEach { second ->
				if (first.getDegree() == second.getDegree()) {
					membersSum.add(Member(first.getNumber() + second.getNumber(), first.getDegree()))
					testForNum = false
				}
			}

			if (testForNum) {
				membersSum.add(Member(first.getNumber(), first.getDegree()))
			}
		}

		polynom.members.forEach { second ->
			testForNum = true
			members.forEach { first ->
				if (first.getDegree() == second.getDegree()) {
					testForNum = false
				}
			}
			if (testForNum) {
				membersSum.add(Member(second.getNumber(), second.getDegree()))
			}
		}
		val polynomSum = Polynom()
		polynomSum.members = membersSum
		return polynomSum
	}

	fun minusPolynom(polynom: Polynom): Polynom {
		val membersSum = mutableListOf<Member>()
		var testForNum: Boolean
		members.forEach { first ->
			testForNum = true

			polynom.members.forEach { second ->
				if (first.getDegree() == second.getDegree()) {
					membersSum.add(Member(first.getNumber() - second.getNumber(), first.getDegree()))
					testForNum = false
				}
			}

			if (testForNum) {
				membersSum.add(Member(first.getNumber(), first.getDegree()))
			}
		}

		polynom.members.forEach { second ->
			testForNum = true
			members.forEach { first ->
				if (first.getDegree() == second.getDegree()) {
					testForNum = false
				}
			}
			if (testForNum) {
				membersSum.add(Member(second.getNumber(), second.getDegree()))
			}
		}
		val polynomSum = Polynom()
		polynomSum.members = membersSum
		return polynomSum
	}
}