package alantduong.com.lab10

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    lateinit var auth : FirebaseAuth
    lateinit var loginBtn : Button
    lateinit var emailLoginId : TextView
    lateinit var passwordLoginId : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        loginBtn = findViewById(R.id.loginBtn)
        emailLoginId = findViewById(R.id.emailLoginId)
        passwordLoginId = findViewById((R.id.passwordLoginId))

        loginBtn.setOnClickListener() {
            if (emailLoginId.text.trim().toString().isNotEmpty() || passwordLoginId.text.trim().toString().isNotEmpty()) {
                login(emailLoginId.text.trim().toString(), passwordLoginId.text.trim().toString())
            } else {
                Snackbar.make(findViewById(R.id.loginBtn),"Check your username or password, then try again", Snackbar.LENGTH_LONG).show()
            }
        }
    }
    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                startActivity(Intent(this, Service::class.java))
            } else {
                Snackbar.make(findViewById(R.id.loginBtn), "Enter a valid username or password", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}