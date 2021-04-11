package com.example.mytictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.playfield.*


class PlayField : AppCompatActivity(), View.OnClickListener {
    var buttonLayout = arrayOf<ArrayList<Button>>(arrayListOf(), arrayListOf(), arrayListOf())
    var step = (0..1).random() == 1;
    var moves = 0;
    val firstPlayerSymbol = "x";
    val secondPlayerSymbol = "o";

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.playfield)

        val button = findViewById<Button>(R.id.btn_00)
        button.setOnClickListener(this);

        for (i in 0..2) {
            for (j in 0..2){
                val buttonString = "btn_" + i + j;
                val buttonID = resources.getIdentifier(buttonString, "id", packageName)
                buttonLayout[i].add(findViewById<Button>(buttonID));
                buttonLayout[i][j].setOnClickListener(this)
            }
        }

        textView_player1.text = intent.getStringExtra("firstName")
        textView_player2.text = intent.getStringExtra("secondName")
        textView_turnFor.text = "It's your move, " + currentPlayerName(step) + "!";
    }

    override fun onClick(v: View?) {

        if (v != null) {
            if( (v as Button).text.isEmpty()) {
                moves++
                if (step) {
                    (v as Button).text = firstPlayerSymbol.toString();
                } else {
                    (v as Button).text = secondPlayerSymbol.toString();
                }
                val (state, pos) = checkGameState(buttonLayout, moves);
                if (state != "n"){
                    disableAllButtons(buttonLayout);
                    textView_turnFor.text = "";
                    if(state == "t"){
                        textView_test.text = "It's a tie!";
                    }else{
                        textView_test.text = "Winner is: " + currentPlayerName(step);
                        stylizeWinnerButtons(buttonLayout, checkGameState(buttonLayout, moves));
                    }
                    showActionButtons();
                }else {
                    step = !step
                    textView_turnFor.text = "It's your move, " + currentPlayerName(step) + "!";
                }
            }
        };
    }

    fun onReset(v: View?) {
        finish()
        startActivity(intent)
    }

    fun onHome(v: View?) {
        finish()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun currentPlayerName(step: Boolean) : String{
        if(step){
            return textView_player1.text.toString();
        }else{
            return textView_player2.text.toString();
        }
    }

    fun showActionButtons(){

    }
}