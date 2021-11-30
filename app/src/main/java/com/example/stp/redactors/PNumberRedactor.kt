package com.example.stp.redactors

class PNumberRedactor {

	private var pNumber = "0"

	fun isZero(): Boolean {
		return this.pNumber == "0"
	}

	fun clear() {
		this.pNumber = "0"
	}

	fun addDot() {
		if (!this.pNumber.contains('.'))
			this.pNumber += "."
	}

	fun unaryMinus() {
		if (!this.pNumber.contains('-')) {
			this.pNumber = "-" + this.pNumber
		} else {
			this.pNumber = this.pNumber.substringAfter("-")
		}
	}

	fun addNumber(number: String) {
		if (this.pNumber == "0") {
			this.pNumber = number
		} else {
			this.pNumber += number
		}
	}

	fun deleteRight() {
		val pNumberBuf = this.pNumber
		this.pNumber = ""
		if (this.pNumber.length == 1) {
			this.pNumber = "0"
		} else {
			for (i in 0 until pNumberBuf.length - 1) {
				this.pNumber += pNumberBuf[i]
			}
		}
	}

	fun get(): String {
		return this.pNumber
	}

	fun set(number: String) {
		this.pNumber = number
	}
}