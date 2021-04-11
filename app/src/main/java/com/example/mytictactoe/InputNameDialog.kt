package com.example.mytictactoe

import android.app.Dialog
import android.app.PendingIntent.getActivity
import android.content.Context
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.playfield.*

fun setNameFor(target: String, context: Context, textview: TextView){
    val dialog = Dialog(context);
    dialog.setContentView(R.layout.name_input_dialog)
    dialog.setCanceledOnTouchOutside(false);
    val label = dialog.findViewById<TextView>(R.id.textView_name)
    val buttn = dialog.findViewById<Button>(R.id.btn_setName)
    val input = dialog.findViewById<EditText>(R.id.editText_name)

    label.text = "Enter " + target + " name!"
    dialog.show();
    buttn.setOnClickListener {
        val name = input.getText().toString();
        textview.setText(name);
        dialog.dismiss();
    }
}