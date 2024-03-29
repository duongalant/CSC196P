package alantduong.com.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var slider : SeekBar
        lateinit var value : TextView
        lateinit var dateBtn : Button
        lateinit var dateText: TextView
        lateinit var timeBtn : Button
        lateinit var timeText : TextView
        lateinit var scheduleBtn : Button
        var myPhoneNumber : TextView
        var myFullName : TextView

        slider = findViewById(R.id.mySeekBar)
        value = findViewById(R.id.myPizzaSize)
        dateBtn = findViewById(R.id.dateBtn)
        dateText = findViewById(R.id.dateText)
        timeBtn = findViewById(R.id.timeBtn)
        timeText = findViewById(R.id.timeText)
        scheduleBtn = findViewById(R.id.scheduleBtn)
        myPhoneNumber = findViewById(R.id.myPhoneNumber)
        myFullName = findViewById(R.id.myFullName)
        val pizzaSize = arrayListOf<String>("Please Select","Small","Medium","Large","Extra-Large")

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                value.text=pizzaSize[progress]
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        } )

        dateBtn.setOnClickListener {
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)

            val myDatePicker =
                DatePickerDialog (this, android.R.style.ThemeOverlay,
                    DatePickerDialog.OnDateSetListener { DatePicker, Year, Month, Day ->
                        dateText.text = "$day/${Month+1}/$Year"}, year, month, day)
            myDatePicker.show()
        }

        timeBtn.setOnClickListener {
            val c = Calendar.getInstance()
            val hour =c.get(Calendar.HOUR_OF_DAY)
            val minutes =c.get(Calendar.MINUTE)
            val myTimePicker =
                TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { TimePicker, hourOfDay, minute ->
                    timeText.text = "$hourOfDay : $minute"},hour,minutes,true)
            myTimePicker.show()
        }

        scheduleBtn.setOnClickListener {
            var intent = Intent(this,Thanks::class.java)
            intent.putExtra("name", myFullName.text.toString())
            intent.putExtra("phoneNumber", myPhoneNumber.text.toString())
            intent.putExtra("pizzSize", value.text.toString())
            intent.putExtra("pickupDate", dateText.text.toString())
            intent.putExtra("pickupTime", timeText.text.toString())
            startActivity(intent)
        }

    }
}