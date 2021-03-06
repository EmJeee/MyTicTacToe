package com.example.mytictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_pvp.setOnClickListener {
            val intent = Intent(this, NameInput::class.java)
            startActivity(intent)
        }

        btn_pvc.setOnClickListener {
            val intent = Intent(this, PlayFieldRobot::class.java)
            startActivity(intent)
        }
    }
}