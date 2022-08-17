package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    @SuppressLint("SetTextI18n")
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val luckyNumber = 4

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView2)
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_2)

        //Rolls dices
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        //Content description of rolled dice
        diceImage.contentDescription = diceRoll.toString()

        //Checks if lucky
        when (diceRoll) {
            luckyNumber -> resultTextView.text = "You win!"
            1 -> resultTextView.text = "So sorry! You rolled 1. Try again!"
            2 -> resultTextView.text = "So sorry! You rolled 2. Try again!"
            3 -> resultTextView.text = "So sorry! You rolled 3. Try again!"
            5 -> resultTextView.text = "So sorry! You rolled 5. Try again!"
            else -> resultTextView.text = "So sorry! You rolled 6. Try again!"
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}

