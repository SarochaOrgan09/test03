package com.example.myfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login01.setOnClickListener {
            val intent = Intent(this, LOGIN::class.java)
            startActivity(intent)
        }

        register01.setOnClickListener {
            val intent = Intent(this, SIGNIN::class.java)
            startActivity(intent)
        }
    }
}