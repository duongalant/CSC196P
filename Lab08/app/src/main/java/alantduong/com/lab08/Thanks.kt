package alantduong.com.lab08

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Thanks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thanks)

        var nameId : TextView = findViewById(R.id.nameId)
        var phoneId : TextView = findViewById(R.id.phoneId)
        var sizeId : TextView = findViewById(R.id.sizeId)
        var dateId : TextView = findViewById(R.id.dateId)
        var timeId : TextView = findViewById(R.id.timeId)
        var sendBtn : Button = findViewById(R.id.sendBtn)
        var rateText : TextView = findViewById(R.id.rateText)
        var myRatingBar : RatingBar = findViewById(R.id.myRatingBar)

        nameId.text=intent.getStringExtra("name")
        phoneId.text=intent.getStringExtra("phoneNumber")
        sizeId.text=intent.getStringExtra("pizzSize")
        dateId.text=intent.getStringExtra("pickupDate")
        timeId.text=intent.getStringExtra("pickupTime")

        sendBtn.setOnClickListener {
            rateText.text = myRatingBar.rating.toString()
        }
    }
}