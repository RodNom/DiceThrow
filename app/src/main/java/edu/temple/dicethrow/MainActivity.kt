package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newDie100 = DieFragment.newInstance(100)
        supportFragmentManager.beginTransaction().add(R.id.DieContainer, newDie100).commit()

        if (supportFragmentManager.findFragmentById(R.id.DieContainer) !is DieFragment) {
            supportFragmentManager.beginTransaction().add(R.id.DieContainer, newDie100).commit()
        }

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener{
            (supportFragmentManager.findFragmentById(R.id.DieContainer) as DieFragment).throwDie()
        }

    }
}