package alantduong.com.lab06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var info : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        info = findViewById(R.id.info)
    }
    fun display(view: View) {
        info.text="Android Application Development, Android Security Essentials" +
                " and Monetize Android Applications"
    }
}