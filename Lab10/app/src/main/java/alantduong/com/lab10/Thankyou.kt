package alantduong.com.lab10

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Thankyou : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thankyou)

        var portalBtn : Button = findViewById(R.id.portalBtn)

        portalBtn.setOnClickListener() {
            startActivity(Intent(this, Login::class.java))
        }
    }
}