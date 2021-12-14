package com.example.stp

import com.example.stp.computing.Operation
import com.example.stp.computing.TProc
import com.example.stp.mathclasses.Complex
import com.example.stp.mathclasses.PNumber
import com.example.stp.mathclasses.TFrac
import org.junit.Assert
import org.junit.Test

class TProcUnitTest {

	@Test
	fun readLeftTest1(){
		val t = TProc(TFrac("0/1"), TFrac("0/1"))
		t.writeLeft(TFrac("3/2"))
		val expect = "3/2"
		Assert.assertEquals(expect, t.readLeft().toString())
	}

	@Test
	fun readLeftTest2(){
		val t = TProc(PNumber("0", 10, 1), PNumber("0", 10, 1))
		t.writeLeft(PNumber("2", 3, 1))
		val expect = "2, base: 3, prec: 1"
		Assert.assertEquals(expect, t.readLeft().toString())
	}

	@Test
	fun readLeftTest3(){
		val t = TProc(Complex("0 + 0i"), Complex("0 + 0i"))
		t.writeLeft(Complex("2 + 3i"))
		val expect = "2.0 + 3.0i"
		Assert.assertEquals(expect, t.readLeft().toString())
	}


	@Test
	fun readRightTest1(){
		val t = TProc(TFrac("0/1"), TFrac("0/1"))
		t.writeRight(TFrac("3/2"))
		val expect = "3/2"
		Assert.assertEquals(expect, t.readRight().toString())
	}

	@Test
	fun readRightTest2(){
		val t = TProc(PNumber("0", 10, 1), PNumber("0", 10, 1))
		t.writeRight(PNumber("2", 3, 1))
		val expect = "2, base: 3, prec: 1"
		Assert.assertEquals(expect, t.readRight().toString())
	}

	@Test
	fun readRightTest3(){
		val t = TProc(Complex("0 + 0i"), Complex("0 + 0i"))
		t.writeRight(Complex("2 + 3i"))
		val expect = "2.0 + 3.0i"
		Assert.assertEquals(expect, t.readRight().toString())
	}

	@Test
	fun readOperationTest(){
		val t = TProc(TFrac("0/1"), TFrac("0/1"))
		t.writeOperation(Operation.SQR)
		val expect = Operation.SQR
		Assert.assertEquals(expect, t.readOperation())
	}

	@Test
	fun clearOperationTest(){
		val t = TProc(TFrac("0/1"), TFrac("0/1"))
		t.clearOperation()
		val expect = Operation.NULL
		Assert.assertEquals(expect, t.readOperation())
	}

	@Test
	fun startOperationTest1(){
		val t = TProc(TFrac("2/1"), TFrac("3/1"))
		t.writeOperation(Operation.PLUS)
		t.startOperation()
		val expect = "5/1"
		Assert.assertEquals(expect, t.readLeft().toString())
	}

	@Test
	fun startOperationTest2(){
		val t = TProc(Complex("4 + 3i"), Complex("1 + 2i"))
		t.writeOperation(Operation.MINUS)
		t.startOperation()
		val expect = "3.0 + 1.0i"
		Assert.assertEquals(expect, t.readLeft().toString())
	}

	@Test
	fun startOperationTest3(){
		val t = TProc(PNumber("-a2.23", 16, 4), PNumber("a1.0", 16, 4))
		t.writeOperation(Operation.PLUS)
		t.startOperation()
		val expect = "-1.2300, base: 16, prec: 4"
		Assert.assertEquals(expect, t.readLeft().toString())
	}

	@Test
	fun startOperationTest4(){
		val t = TProc(TFrac("2/1"), TFrac("3/1"))
		t.writeOperation(Operation.DIV)
		t.startOperation()
		val expect = "2/3"
		Assert.assertEquals(expect, t.readLeft().toString())
	}

	@Test
	fun startFunTest1(){
		val t = TProc(TFrac("2/3"), TFrac("3/1"))
		t.writeOperation(Operation.SQR)
		t.startFun()
		val expect = "4/9"
		Assert.assertEquals(expect, t.readLeft().toString())
	}

	@Test
	fun startFunTest2(){
		val t = TProc(Complex("1 + 2i"), Complex("1 + 2i"))
		t.writeOperation(Operation.REV)
		t.startFun()
		val expect = "0.2 - 0.4i"
		Assert.assertEquals(expect, t.readLeft().toString())
	}

	@Test
	fun clearProcTest1(){
		val t = TProc(TFrac("2/3"), TFrac("3/1"))
		t.writeOperation(Operation.SQR)
		t.clearProc()
		val expect = "0/1"
		Assert.assertEquals(expect, t.readLeft().toString())
	}

	@Test
	fun clearProcTest2(){
		val t = TProc(TFrac("2/3"), TFrac("3/1"))
		t.writeOperation(Operation.SQR)
		t.clearProc()
		val expect = "0/1"
		Assert.assertEquals(expect, t.readRight().toString())
	}

	@Test
	fun clearProcTest3(){
		val t = TProc(TFrac("2/3"), TFrac("3/1"))
		t.writeOperation(Operation.SQR)
		t.clearProc()
		val expect = Operation.NULL
		Assert.assertEquals(expect, t.readOperation())
	}
}