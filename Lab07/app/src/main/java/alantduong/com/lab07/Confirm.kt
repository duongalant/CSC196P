package alantduong.com.lab07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Confirm : AppCompatActivity() {

    private lateinit var SnameId : TextView
    private lateinit var SaddressId : TextView
    private lateinit var ScityId : TextView
    private lateinit var SstateId : TextView
    private lateinit var SzipId : TextView
    private lateinit var ScountryId : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        SnameId = findViewById(R.id.SnameId)
        SaddressId = findViewById(R.id.SaddressId)
        ScityId = findViewById(R.id.ScityId)
        SstateId = findViewById(R.id.SstateId)
        SzipId = findViewById(R.id.SzipId)
        ScountryId = findViewById(R.id.ScountryId)


        SnameId.text = intent.getStringExtra("name")
        SaddressId.text = intent.getStringExtra("address")
        ScityId.text = intent.getStringExtra("city")
        SstateId.text = intent.getStringExtra("state")
        SzipId.text = intent.getStringExtra("zipCode")
        ScountryId.text = intent.getStringExtra("country")
    }
}