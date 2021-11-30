package com.example.stp.redactors

const val PLUS = " + "
const val SIGN_MINUS = "-"
const val SIGN_PLUS = ""
const val IMAGINE_SYMBOL = "i"

class ComplexRedactor {

	private var real: String = "0"
	private var imagine: String = "0"
	private var complex: String = "0 + 0i"
	private var imgSign = true        //true = +
	private var realSign = true

	private fun setComplex() {
		val imagineSign: String = if (this.imgSign) {
			SIGN_PLUS
		} else {
			SIGN_MINUS
		}
		val realSign: String = if (this.realSign) {
			SIGN_PLUS
		} else {
			SIGN_MINUS
		}
		this.complex = realSign + real + PLUS + imagineSign + imagine + IMAGINE_SYMBOL
	}

	fun clear() {
		this.real = "0"
		this.imagine = "0"
		this.imgSign = true
		this.realSign = true
		setComplex()
	}

	fun isZero(): Boolean {
		return complex == "0 + 0i"
	}

	fun realUnaryMinus() {
		this.realSign = !this.realSign
		setComplex()
	}

	fun imagineUnaryMinus() {
		this.imgSign = !this.imgSign
		setComplex()
	}

	fun addDotToReal() {
		if (!this.real.contains('.')) {
			this.real += "."
			setComplex()
		} else {
			return
		}
	}

	fun addDotToImagine() {
		if (!this.imagine.contains('.')) {
			this.imagine += "."
			setComplex()
		} else {
			return
		}
	}

	fun addToReal(n: Int) {
		if (this.real == "0") {
			this.real = n.toString()
		} else {
			this.real += n.toString()
		}
		setComplex()
	}

	fun addToImagine(n: Int) {
		if (this.imagine == "0") {
			this.imagine = n.toString()
		} else {
			this.imagine += n.toString()
		}
		setComplex()
	}

	fun deleteRightReal() {
		val realBuf = this.real
		this.real = ""
		if (realBuf.length == 1) {
			this.real = "0"
		} else {
			for (i in 0 until realBuf.length - 1) {
				this.real += realBuf[i]
			}
		}
		setComplex()
	}

	fun deleteRightImagine() {
		val imagineBuf = this.imagine
		this.imagine = ""
		if (imagineBuf.length == 1) {
			this.imagine = "0"
		} else {
			for (i in 0 until imagineBuf.length - 1) {
				this.imagine += imagineBuf[i]
			}
		}
		setComplex()
	}

	fun get(): String {
		return this.complex
	}

	fun set(complex: String) {
		val realBuf = complex.substringBefore(" + ")
		if (realBuf.contains('-') && this.realSign) {
			realUnaryMinus()
			this.real = realBuf.substringAfter("-")
		} else if (realBuf.contains('-') && !this.realSign) {
			this.real = realBuf.substringAfter("-")
		} else if (!realBuf.contains('-') && !this.realSign) {
			realUnaryMinus()
			this.real = realBuf
		} else {
			this.real = realBuf
		}

		var imagineBuf = complex.substringAfter(" + ")
		if (imagineBuf.contains('-') && this.imgSign) {
			imagineUnaryMinus()
			imagineBuf = imagineBuf.substringBefore(IMAGINE_SYMBOL)
			this.imagine = imagineBuf.substringAfter("-")
		} else if (imagineBuf.contains('-') && !this.imgSign) {
			imagineBuf = imagineBuf.substringBefore(IMAGINE_SYMBOL)
			this.imagine = imagineBuf.substringAfter("-")
		} else if (!imagineBuf.contains('-') && !this.imgSign) {
			imagineUnaryMinus()
			imagineBuf = imagineBuf.substringBefore(IMAGINE_SYMBOL)
			this.imagine = imagineBuf
		} else {
			this.imagine = imagineBuf.substringBefore(IMAGINE_SYMBOL)
		}
		setComplex()
	}
}