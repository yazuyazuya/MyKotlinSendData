package com.example.yazuyazuya.mykotlinsenddata

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        //const val EXTRA_MESSAGE = "com.example.testactivitydatatrans.MESSAGE"
        const val EXTRA_MESSAGE = "com.example.kotlinactivitydatatrans.MESSAGE"

    }

    private val RESULT_SUBACTIVITY = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText1)

        button.setOnClickListener {
            if (editText.text != null) {
                val intent = Intent(applicationContext, SubActivity::class.java)
                val str = editText.text.toString()
                Log.d("debug",str)

                intent.putExtra(EXTRA_MESSAGE, str)
                startActivityForResult(intent, RESULT_SUBACTIVITY)

                editText.setText("")

            }
        }
    }

    // to get a result form SubActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)

        val textView = findViewById<TextView>(R.id.textView2)

        if (resultCode == Activity.RESULT_OK &&
                requestCode == RESULT_SUBACTIVITY && intent != null) {

            // in case of nothing exist in Intent, just preventing NPE
            val res = intent.extras.getString(EXTRA_MESSAGE)?: "Null"
            textView.text = res
        }
    }

}
