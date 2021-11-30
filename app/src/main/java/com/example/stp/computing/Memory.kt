package com.example.stp.computing

import com.example.stp.mathclasses.Complex
import com.example.stp.mathclasses.MathInterface
import com.example.stp.mathclasses.PNumber
import com.example.stp.mathclasses.TFrac

class Memory<T : MathInterface>(number: T) {

	private var number: T = number
	private var state: Boolean = true

	fun plus(e: T) {
		when (this.number) {
			is TFrac   -> {
				if (e is TFrac) {
					(this.number as TFrac).plus(e as TFrac)
				}
			}

			is Complex -> {
				if (e is Complex) {
					(this.number as Complex).plus(e as Complex)
				}
			}

			is PNumber -> {
				if (e is PNumber) {
					(this.number as PNumber).plus(e as PNumber)
				}
			}
		}
	}

	fun clear(): String {
		state = false
		return when (this.number) {
			is TFrac   -> {
				this.number = TFrac("0/1") as T
				(this.number as TFrac).toString()
			}

			is Complex -> {
				this.number = Complex("0 + 0i") as T
				(this.number as Complex).toString()
			}

			is PNumber -> {
				this.number = PNumber("0", 10, 1) as T
				(this.number as PNumber).toString()
			}

			else       -> {
				""
			}
		}
	}

	fun getState(): String {
		return if (state) "true"
		else "false"
	}

	fun getNumber(): T {
		return this.number
	}
}