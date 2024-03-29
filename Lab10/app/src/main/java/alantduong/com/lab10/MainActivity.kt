package alantduong.com.lab10

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signupBtn : Button = findViewById(R.id.signupBtn)
        val loginBtn : Button = findViewById(R.id.loginBtn)

        signupBtn.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
        }
        loginBtn.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }
}