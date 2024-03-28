package alantduong.com.lab05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var smallPizza : RadioButton
    private lateinit var mediumPizza : RadioButton
    private lateinit var largePizza : RadioButton
    private lateinit var onionsCheckBox : CheckBox
    private lateinit var olivesCheckBox : CheckBox
    private lateinit var tomatoesCheckBox : CheckBox
    private lateinit var totalPrice : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smallPizza = findViewById(R.id.smallpizza)
        mediumPizza = findViewById(R.id.mediumpizza)
        largePizza = findViewById(R.id.largepizza)
        onionsCheckBox = findViewById(R.id.OnionsCheckBox)
        olivesCheckBox = findViewById(R.id.OlivesCheckBox)
        tomatoesCheckBox = findViewById(R.id.TomatoesCheckBox)
        totalPrice = findViewById(R.id.Totalprice)

    }

    fun onPlaceOrderButtonClicked(view: View) {
        var pizzaSizePrice = 0.0
        var toppingsTotal = 0.0

        when {
            smallPizza.isChecked -> pizzaSizePrice = 5.0
            mediumPizza.isChecked -> pizzaSizePrice = 7.0
            largePizza.isChecked -> pizzaSizePrice = 9.0
        }

        if (onionsCheckBox.isChecked) {
            toppingsTotal += 1
        }
        if (olivesCheckBox.isChecked) {
            toppingsTotal += 2
        }
        if (tomatoesCheckBox.isChecked) {
            toppingsTotal += 3
        }

        totalPrice.text = "Total Order Price= $" + (pizzaSizePrice + toppingsTotal)
    }
}