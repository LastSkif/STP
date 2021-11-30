package com.example.stp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stp.mathclasses.PNumber
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		var try1 = PNumber("-a2.23", 16, 4)
		var try2 = PNumber("a1.0", 16, 4)
		val test = 15
		val str1 = '3'
		val str1Int = 2.0
		fractField.text = try1.getNumberDecimal().toString()
		fractField1.text = try2.toString()
		try1.plus(try2)
		val try3 = try2
		fractField2.text = try1.toString()
	}
}