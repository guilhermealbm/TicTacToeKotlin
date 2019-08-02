package com.example.tictactoekotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view:View){
        if(winningSequences.size == 0)
            initWinningSequences()

        val btnSelected = view as Button
        var cellID = 0

        when(btnSelected.id){
            R.id.btn -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9

        }

        playGame(cellID,btnSelected)

    }

    var board: CharArray = charArrayOf(' ',' ',' ',' ',' ',' ',' ',' ',' ')
    var winningSequences = ArrayList<IntArray>()

    var turnIndex = 0

    private fun initWinningSequences(){
        winningSequences.add(intArrayOf(1, 2, 3))
        winningSequences.add(intArrayOf(4, 5, 6))
        winningSequences.add(intArrayOf(7, 8, 9))

        winningSequences.add(intArrayOf(1, 4, 7))
        winningSequences.add(intArrayOf(2, 5, 8))
        winningSequences.add(intArrayOf(3, 6, 9))

        winningSequences.add(intArrayOf(1, 5, 9))
        winningSequences.add(intArrayOf(3, 5, 7))
    }

    private fun playGame(cellID: Int, btnSelected: Button){
        if(turnIndex == 0){
            btnSelected.text = "X"
            btnSelected.setTextColor(Color.parseColor("#003366"))
            board.set((cellID-1), 'X')
            checkWinningSequences('X')
        }else{
            btnSelected.text = "O"
            btnSelected.setTextColor(Color.parseColor("#993333"))
            board.set((cellID-1), 'O')
            checkWinningSequences('O')
        }

        btnSelected.isEnabled = false
        turnIndex = if(turnIndex == 0) 1 else 0

    }

    private fun checkWinningSequences(symbol: Char){
        for (i in 0..(winningSequences.size)-1){
            if(board[(winningSequences[i][0]-1)] == symbol &&
                board[(winningSequences[i][1]-1)] == symbol &&
                board[(winningSequences[i][2]-1)] == symbol){
                Toast.makeText(this," Player " +(turnIndex+1)+ " win the game", Toast.LENGTH_LONG).show()
            }
        }
    }

}
