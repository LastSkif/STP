package com.example.stp.mathclasses

class TFrac(fract: String) : MathInterface {

	private var numerator: Int = 0
	private var denominator: Int = 1

	init {
		numerator = fract.substringBefore("/", "0").toInt()
		denominator = fract.substringAfter("/", "1").toInt()
		try {
			if (denominator == 0) {
				throw ExceptionInInitializerError("Знаменатель не должен быть равен 0!")
			}
		} catch (e: ExceptionInInitializerError) {
			denominator = 1
		}
		reduce()
		normalize()
	}

	private fun reduce() {
		val nod: Int = NOD(this.numerator, this.denominator)
		this.numerator /= nod
		this.denominator /= nod
	}

	private fun normalize() {
		if (this.numerator < 0 && this.denominator < 0) {
			this.numerator = -this.numerator;
			this.denominator = -this.denominator;
		} else if (this.denominator < 0) {
			this.numerator = -this.numerator;
			this.denominator = -this.denominator;
		}
	}

	private fun NOD(x: Int, y: Int): Int {
		var temp: Int
		var x1: Int = x
		var y1: Int = y
		while (y1 != 0) {
			x1 %= y1
			temp = x1
			x1 = y1
			y1 = temp
		}
		return x1
	}

	private fun NOK(x: Int, y: Int): Int {
		return x / NOD(x, y) * y
	}

	override fun toString(): String {
		return this.numerator.toString() + "/" + this.denominator.toString()
	}

	fun plus(d: TFrac) {
		if (this.denominator == d.denominator) {
			this.numerator += d.numerator
		} else {
			val nok = NOK(this.denominator, d.denominator)
			this.numerator = this.numerator * (nok / this.denominator) + d.numerator * (nok / d.denominator)
			this.denominator = nok
		}
		this.reduce()
		this.normalize()
	}

	fun minus(d: TFrac) {
		if (this.denominator == d.denominator) {
			this.numerator -= d.numerator
		} else {
			val nok = NOK(this.denominator, d.denominator)
			this.numerator = this.numerator * (nok / this.denominator) - d.numerator * (nok / d.denominator)
			this.denominator = nok
		}
		this.reduce()
		this.normalize()
	}

	fun mult(d: TFrac) {
		this.numerator *= d.numerator
		this.denominator *= d.denominator
		this.reduce()
		this.normalize()
	}

	fun div(d: TFrac) {
		try {
			if (d.numerator == 0) {
				throw ArithmeticException("Числитель дроби-делителя не должен быть равен 0!")
			}
		} catch (e: ArithmeticException) {
			return
		}
		this.numerator *= d.denominator
		this.denominator *= d.numerator
		this.reduce()
		this.normalize()
	}

	fun sqr() {
		this.numerator *= this.numerator
		this.denominator *= this.denominator
		this.reduce()
	}

	fun reverse() {
		val temp: Int = this.denominator
		this.denominator = this.numerator
		this.numerator = temp
	}

	fun biggerThan(d: TFrac): Boolean {
		d.normalize()
		this.normalize()
		return this.numerator * d.denominator > d.numerator * this.denominator
	}

	fun equal(d: TFrac): Boolean {
		return this.numerator == d.numerator && this.denominator == d.denominator
	}

	fun smallerThan(d: TFrac): Boolean {
		d.normalize()
		this.normalize()
		return this.numerator * d.denominator < d.numerator * this.denominator
	}

	fun getNumeratorInt(): Int {
		return this.numerator
	}

	fun getDenominatorInt(): Int {
		return this.denominator
	}

	fun getNumeratorString(): String {
		return this.numerator.toString()
	}

	fun getDenominatorString(): String {
		return this.denominator.toString()
	}
}