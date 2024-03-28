package alantduong.com.lab01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val n1 = findViewById<EditText>(R.id.Number1).text
        val n2 = findViewById<EditText>(R.id.Number2).text
        val button_plus = findViewById<Button>(R.id.button_plus)
        val button_minus = findViewById<Button>(R.id.button_minus)
        val button_multiply = findViewById<Button>(R.id.button_multiply)
        val button_divide = findViewById<Button>(R.id.button_divide)
        val result_view = findViewById<TextView>(R.id.result_view)

        button_plus.setOnClickListener {
            val sumResult = n1.toString().toDouble() + n2.toString().toDouble()
                result_view.text = sumResult.toString()
        }

        button_minus.setOnClickListener {
            val subResult = n1.toString().toDouble() - n2.toString().toDouble()
            result_view.text = subResult.toString()
        }

        button_multiply.setOnClickListener {
            val multResult = n1.toString().toDouble() * n2.toString().toDouble()
            result_view.text = multResult.toString()
        }

        button_divide.setOnClickListener {
            val divResult = n1.toString().toDouble() / n2.toString().toDouble()
            result_view.text = divResult.toString()
        }
    }
}