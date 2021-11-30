package com.example.stp.redactors

const val DELIMITER = "/"

class TFracRedactor {

	private var numerator: String = "0"
	private var denominator: String = "1"
	private var tFrac: String = "0/1"

	private fun setTFrac() {
		this.tFrac = numerator + DELIMITER + denominator
	}

	fun clear() {
		this.numerator = "0"
		this.denominator = "1"
		setTFrac()
	}

	fun isZero(): Boolean {
		return tFrac == "0/1"
	}

	fun unaryMinus() {
		val numeratorBuf = this.numerator
		if (this.numerator.contains("-")) {
			this.numerator = numeratorBuf.substringAfter("-")
		} else {
			this.numerator = "-$numeratorBuf"
		}
		setTFrac()
	}

	fun addToNumerator(n: Int) {
		if (this.numerator == "0") {
			this.numerator = n.toString()
		} else {
			this.numerator += n.toString()
		}
		setTFrac()
	}

	fun addToDenominator(n: Int) {
		this.denominator += n.toString()
		setTFrac()
	}

	fun deleteRightNumerator() {
		val numeratorBuf = this.numerator
		this.numerator = ""
		if (numeratorBuf.length == 1) {
			this.numerator = "0"
		} else {
			for (i in 0 until numeratorBuf.length - 1) {
				this.numerator += numeratorBuf[i]
			}
		}
		setTFrac()
	}

	fun deleteRightDenominator() {
		val denominatorBuf = this.denominator
		this.denominator = ""
		if (denominatorBuf.length == 1) {
			this.denominator = "1"
		} else {
			for (i in 0 until denominatorBuf.length - 1) {
				this.denominator += denominatorBuf[i]
			}
		}
		setTFrac()
	}

	fun get(): String {
		return this.tFrac
	}

	fun set(tFrac: String) {
		numerator = tFrac.substringBefore("/")
		denominator = tFrac.substringAfter("/")
		setTFrac()
	}
}