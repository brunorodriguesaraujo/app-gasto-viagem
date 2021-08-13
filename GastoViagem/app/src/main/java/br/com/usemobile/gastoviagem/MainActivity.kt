package br.com.usemobile.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCalculate: Button
    private lateinit var editDistance: EditText
    private lateinit var editCost: EditText
    private lateinit var editAutonomy: EditText
    private lateinit var textValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initalizeFields()
        buttonCalculate.setOnClickListener {
            calculate()
        }
    }

    private fun initalizeFields() {
        editDistance = findViewById(R.id.editTextDistance)
        editCost = findViewById(R.id.editTextCost)
        editAutonomy = findViewById(R.id.editTextAutonomy)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textValue = findViewById(R.id.textValue)
    }

    private fun calculate() {
        if (editDistance.text.toString() != "" && editCost.text.toString() != "" &&
            editAutonomy.text.toString() != "" && editAutonomy.text.toString() != "0"
        ) {
            try {

                val distance: Double = editDistance.text.toString().toDouble()
                val cost: Double = editCost.text.toString().toDouble()
                val autonomy: Double = editAutonomy.text.toString().toDouble()

                val result = cost * (distance / autonomy)

                textValue.setText(String.format("%.2f", result))

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, "Informe valores válidos", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Preencha os campos", Toast.LENGTH_LONG).show()
        }


    }


}