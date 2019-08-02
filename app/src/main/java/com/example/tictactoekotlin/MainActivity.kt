package com.example.tictactoekotlin

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
        var cellID = 0;

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

        Toast.makeText(this, "Cell Id: " + cellID, Toast.LENGTH_LONG).show()
        playGame(cellID,btnSelected)

    }

    var board: CharArray = charArrayOf(' ',' ',' ',' ',' ',' ',' ',' ',' ')
    var winningSequences = ArrayList<IntArray>()

    var turnIndex = 1

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
        Toast.makeText(this, ""+ winningSequences.size, Toast.LENGTH_LONG).show()

    }

}
