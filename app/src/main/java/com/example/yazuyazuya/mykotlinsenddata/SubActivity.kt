package com.example.yazuyazuya.mykotlinsenddata

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.TextView

class SubActivity : AppCompatActivity() {

    //    var message = "No Message"
    lateinit var message: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val textView = findViewById<TextView>(R.id.textView4)
        val returnButton = findViewById<Button>(R.id.button2)
        val editText = findViewById<EditText>(R.id.editText2)

        // to get message from MainActivity
        val intent = getIntent()

        // in case of nothing exist in Intent, just preventing NPE
        val message = intent.extras.getString(MainActivity.EXTRA_MESSAGE) ?: "Null"

        textView.text = message

        returnButton.setOnClickListener{
            val intentSub = Intent()

            if (editText.text != null) {
                val str = message + editText.text.toString()
                intentSub.putExtra(MainActivity.EXTRA_MESSAGE, str)

                editText.setText("")
            }

            setResult(Activity.RESULT_OK, intentSub)
            finish()
        }

    }

}
