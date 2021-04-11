package com.example.mytictactoe

import android.widget.Button

fun robotMove(buttonLayout: Array<ArrayList<Button>>, computerSymbol: String) {

    var placed = false;
    for (i in 0..2) {
        var rowsEqual = 0;
        var colsEqual = 0;
        var rowEmpty =  arrayOfNulls<Int>(2)
        var colEmpty =  arrayOfNulls<Int>(2)

        for (j in 0..2) {
            if(!placed) {
                if (buttonLayout[i][j].text.equals(computerSymbol)) {
                    rowsEqual++;
                } else if (buttonLayout[i][j].text.isEmpty()) {
                    rowEmpty[0] = i
                    rowEmpty[1] = j
                }

                if (buttonLayout[j][i].text.equals(computerSymbol)) {
                    colsEqual++;
                } else if (buttonLayout[j][i].text.isEmpty()) {
                    colEmpty[0] = j
                    colEmpty[1] = i
                }

                if (rowsEqual == 2 && rowEmpty[0] != null) {
                    buttonLayout[rowEmpty[0]!!][rowEmpty[1]!!].text = computerSymbol
                    placed = true;
                    break;
                }

                if (colsEqual == 2 && colEmpty[0] != null) {
                    buttonLayout[colEmpty[0]!!][colEmpty[1]!!].text = computerSymbol
                    placed = true;
                    break;
                }
            }
        }
    }
    while(!placed){
        var x = (0..2).random();
        var y = (0..2).random();
        if(buttonLayout[x][y].text.isEmpty()){
            buttonLayout[x][y].text = computerSymbol;
            placed = true;
        }
    }
}