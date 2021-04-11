package com.example.mytictactoe

import android.graphics.Color
import android.widget.Button

fun disableAllButtons(buttonLayout: Array<ArrayList<Button>>){
    for (i in 0..2) {
        for (j in 0..2){
            buttonLayout[i][j].isClickable = false;
        }
    }
}

fun stylizeWinnerButtons(buttonLayout: Array<ArrayList<Button>>, status: Pair<String,Int>) {
    when (status.first) {
        "d" -> {
            if (status.second == 0) {
                buttonLayout[0][0].setBackgroundColor(Color.RED);
                buttonLayout[1][1].setBackgroundColor(Color.RED);
                buttonLayout[2][2].setBackgroundColor(Color.RED);
            } else if (status.second == 1) {
                buttonLayout[0][2].setBackgroundColor(Color.RED);
                buttonLayout[1][1].setBackgroundColor(Color.RED);
                buttonLayout[2][0].setBackgroundColor(Color.RED);
            }
        }
        "c" -> {
            buttonLayout[0][status.second].setBackgroundColor(Color.RED);
            buttonLayout[1][status.second].setBackgroundColor(Color.RED);
            buttonLayout[2][status.second].setBackgroundColor(Color.RED);
        }
        "r" -> {
            buttonLayout[status.second][2].setBackgroundColor(Color.RED);
            buttonLayout[status.second][1].setBackgroundColor(Color.RED);
            buttonLayout[status.second][0].setBackgroundColor(Color.RED);
        }
    }
}