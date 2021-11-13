package com.example.lab_intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ExplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)

        val cancelButton = findViewById<Button>(R.id.cancelButton)
        val okButton = findViewById<Button>(R.id.okButton)


        val textControl1 = findViewById<EditText>(R.id.enterText)


        cancelButton.setOnClickListener(){
            val cancelIntent = Intent(this, MainActivity::class.java)
            startActivity(cancelIntent)
        }

        okButton.setOnClickListener(){
            val okIntent = Intent(this, MainActivity::class.java)
            val editTextValue = textControl1.text.toString()
            okIntent.putExtra("editText", editTextValue)
            startActivity(okIntent)

        }

    }
}