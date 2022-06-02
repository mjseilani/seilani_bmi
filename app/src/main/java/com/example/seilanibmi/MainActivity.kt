package com.example.seilanibmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.seilanibmi.R
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edweight: EditText = findViewById(R.id.txt_weight)
        val edheight: EditText = findViewById(R.id.txt_height)
        val btnresult: Button = findViewById(R.id.btn_result)
        val btnreset: Button = findViewById(R.id.btn_reset)
        val tVresult: TextView = findViewById(R.id.tv_result)

        btnresult.setOnClickListener {

            if (edweight.text.isEmpty() or edheight.text.isEmpty()) {

                Toast.makeText(this, "Enter your Weight and Height", Toast.LENGTH_LONG).show()


            } else {

                val Weight: Double = edweight.text.toString().toDouble()
                val height: Double = edheight.text.toString().toDouble() / 100

                val bmi = Weight / (height * height)

                when (bmi) {
                    in 0.0..18.5 -> tVresult.text =
                        "Status: " + "Under Weight \n " + "Bmi = " + bmi.toInt().toShort()
                    in 18.5..25.0 -> tVresult.text =
                        "Status: " + "Normal weight \n " + "Bmi = " + bmi.toInt().toShort()
                    in 25.0..30.0 -> tVresult.text =
                        "Status: " + "Over Weight \n " + "Bmi = " + bmi.toInt().toShort()
                    else -> tVresult.text =
                        "Status: " + "Obese \n " + "Bmi = " + bmi.toInt().toShort()

                }


            }


            btnreset.setOnClickListener {

                edweight.text.clear()
                edheight.text.clear()
                tVresult.text = ""
                edweight.requestFocus()
            }

        }


    } // end of function oncreate

} // end of class main activity