package com.example.mytictactoe

import android.widget.Button

fun checkGameState(buttonLayout: Array<ArrayList<Button>>, moves: Int) : Pair<String, Int> {
    if (moves > 4){
        if( buttonLayout[0][0].text.equals(buttonLayout[1][1].text) &&
            buttonLayout[1][1].text.equals(buttonLayout[2][2].text) &&
            buttonLayout[0][0].text.isNotEmpty()) {
            return Pair("d", 0);
        } else if ( buttonLayout[0][2].text.equals(buttonLayout[1][1].text) &&
            buttonLayout[1][1].text.equals(buttonLayout[2][0].text) &&
            buttonLayout[0][2].text.isNotEmpty() ) {
            return Pair("d", 1) ;
        }

        for (i in 0..2) {
            if( buttonLayout[i][0].text.equals(buttonLayout[i][1].text) &&
                buttonLayout[i][1].text.equals(buttonLayout[i][2].text) &&
                buttonLayout[i][0].text.isNotEmpty()) {
                return Pair("r", i);
            }

            if( buttonLayout[0][i].text.equals(buttonLayout[1][i].text) &&
                buttonLayout[1][i].text.equals(buttonLayout[2][i].text) &&
                buttonLayout[0][i].text.isNotEmpty()) {
                return Pair("c", i);
            }
        }
    }
    if (moves == 9){
        return Pair("t", 0);
    }
    return Pair("n", 0);
}