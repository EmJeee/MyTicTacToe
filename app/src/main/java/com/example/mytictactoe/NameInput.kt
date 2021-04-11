package com.example.mytictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_name_input.*

class NameInput : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_input)
    }

    fun passData(v: View){
        val intent = Intent(this, PlayField::class.java)
        intent.putExtra("firstName", editText_firstName.text.toString())
        intent.putExtra("secondName", editText_secondName.text.toString())
        startActivity(intent)
    }
}