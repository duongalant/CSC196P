package alantduong.com.lab07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameId: EditText
    private lateinit var addressId: EditText
    private lateinit var cityId: EditText
    private lateinit var stateId: EditText
    private lateinit var zipId: EditText
    private lateinit var countryId: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameId = findViewById(R.id.nameId)
        addressId = findViewById(R.id.addressId)
        cityId = findViewById(R.id.cityId)
        stateId = findViewById(R.id.stateId)
        zipId = findViewById(R.id.zipId)
        countryId = findViewById(R.id.countryId)
    }

    fun mySchedule(view: View) {
        var intent = Intent(this, Confirm::class.java)
        intent.putExtra("name", nameId.text.toString())
        intent.putExtra("address", addressId.text.toString())
        intent.putExtra("city", cityId.text.toString())
        intent.putExtra("state", stateId.text.toString())
        intent.putExtra("zipCode", zipId.text.toString())
        intent.putExtra("country", countryId.text.toString())
        startActivity(intent)
    }
}