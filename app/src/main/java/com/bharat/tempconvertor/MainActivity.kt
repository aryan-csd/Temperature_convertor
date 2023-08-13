package com.bharat.tempconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Qunits: Spinner = findViewById(R.id.Qunits)
        val Qunits_items = arrayOf("Celsius", "Fahrenheit", "Kelvin") // Add your desired options here
        val Qunits_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Qunits_items)
        Qunits_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        Qunits.adapter = Qunits_adapter

        val Aunits: Spinner = findViewById(R.id.Aunits)
        val Aunits_items = arrayOf("Fahrenheit","Celsius","Kelvin") // Add your desired options here
        val Aunits_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Aunits_items)
        Aunits_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        Aunits.adapter = Aunits_adapter

        findViewById<Button>(R.id.ConvertBtn).setOnClickListener {
            val Unit1 = Qunits.selectedItem.toString()
            val Unit2 = Aunits.selectedItem.toString()
            val result = findViewById<TextView>(R.id.result)
            val temp = findViewById<EditText>(R.id.T1).text.toString().toBigDecimal()

            if(Unit1.equals("Celsius") && Unit2.equals("Celsius")) {
                result.setText(temp.toString())
            }
            else if(Unit1.equals("Celsius") && Unit2.equals("Kelvin")) {
                result.setText((temp.add(273.toBigDecimal())).toString())
            }
            else if(Unit1.equals("Celsius") && Unit2.equals("Fahrenheit")) {
                result.setText(((temp.multiply((9.0/5).toBigDecimal()).add(32.toBigDecimal())).toString()))
            }
            else if(Unit1.equals("Kelvin") && Unit2.equals("Celsius")) {
                result.setText(temp.subtract(273.toBigDecimal()).toString())
            }
            else if(Unit1.equals("Kelvin") && Unit2.equals("Kelvin")) {
                result.setText(temp.toString())
            }
            else if(Unit1.equals("Kelvin") && Unit2.equals("Fahrenheit")) {
                result.setText((((temp.subtract(273.toBigDecimal())).multiply((9.0/5).toBigDecimal()).add(32.toBigDecimal())).toString()))
            }
            else if(Unit1.equals("Fahrenheit") && Unit2.equals("Celsius")) {
                result.setText((temp.subtract(32.toBigDecimal()).multiply((5.0/9).toBigDecimal()).toString()))
            }
            else if(Unit1.equals("Fahrenheit") && Unit2.equals("kelvin")) {
                result.setText((((temp.subtract(32.toBigDecimal()).multiply((5.0/9).toBigDecimal()).add(273.toBigDecimal())).toString())))
            }
            else if(Unit1.equals("Fahrenheit") && Unit2.equals("Fahrenheit")) {
                result.setText(temp.toString())
            }
        }
    }



    }

