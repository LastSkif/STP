package com.example.stp.computing

import com.example.stp.mathclasses.Complex
import com.example.stp.mathclasses.MathInterface
import com.example.stp.mathclasses.PNumber
import com.example.stp.mathclasses.TFrac

class TProc<T : MathInterface>(lopResIn: T, ropIn: T) {

	private var lopRes = lopResIn
	private var rop = ropIn
	private var operation: Operation = Operation.REV

	fun readOperation(): Operation = operation
	fun writeOperation(operationIn: Operation){
		operation = operationIn
	}
	fun clearOperation() {
		operation = Operation.NULL
	}

	fun readLeft(): T = lopRes
	fun writeLeft(lopResIn: T){
		var a = lopResIn
		lopRes = a
	}

	fun readRight(): T = rop
	fun writeRight(ropIn: T){
		rop = ropIn
	}

	fun startFun() {
		when (operation) {
			Operation.PLUS  -> startOperation()
			Operation.MINUS -> startOperation()
			Operation.DIV   -> startOperation()
			Operation.MUL   -> startOperation()

			Operation.SQR   -> {
				when (lopRes) {
					is TFrac   -> (lopRes as TFrac).sqr()
					is Complex -> (lopRes as Complex).sqr()
					is PNumber -> (lopRes as PNumber).sqr()
				}
			}

			Operation.REV   -> {
				when (lopRes) {
					is TFrac   -> (lopRes as TFrac).reverse()
					is Complex -> (lopRes as Complex).reverse()
				}
			}

			Operation.NULL  -> {}
		}
	}

	fun startOperation() {
		when (operation) {
			Operation.PLUS  -> {
				when (lopRes) {
					is TFrac   -> (lopRes as TFrac).plus(rop as TFrac)
					is Complex -> (lopRes as Complex).plus(rop as Complex)
					is PNumber -> (lopRes as PNumber).plus(rop as PNumber)
				}
			}

			Operation.MINUS -> {
				when (lopRes) {
					is TFrac   -> (lopRes as TFrac).minus(rop as TFrac)
					is Complex -> (lopRes as Complex).minus(rop as Complex)
					is PNumber -> (lopRes as PNumber).minus(rop as PNumber)
				}
			}

			Operation.DIV   -> {
				when (lopRes) {
					is TFrac   -> (lopRes as TFrac).div(rop as TFrac)
					is Complex -> (lopRes as Complex).div(rop as Complex)
					is PNumber -> (lopRes as PNumber).div(rop as PNumber)
				}
			}

			Operation.MUL   -> {
				when (lopRes) {
					is TFrac   -> (lopRes as TFrac).mult(rop as TFrac)
					is Complex -> (lopRes as Complex).mult(rop as Complex)
					is PNumber -> (lopRes as PNumber).mult(rop as PNumber)
				}
			}

			Operation.SQR   -> startFun()
			Operation.REV   -> startFun()
			Operation.NULL  -> {}
		}
	}

	fun clearProc() {
		when (lopRes) {
			is TFrac   -> {
				lopRes = TFrac("0/1") as T
				rop = TFrac("0/1") as T
			}

			is Complex -> {
				lopRes = Complex("0 + 0i") as T
				rop = Complex("0 + 0i") as T
			}

			is PNumber -> {
				lopRes = PNumber("0", 10, 1) as T
				rop = PNumber("0", 10, 1) as T
			}
		}
		operation = Operation.NULL
	}
}

enum class Operation {
	PLUS,
	MINUS,
	MUL,
	DIV,
	SQR,
	REV,
	NULL
}