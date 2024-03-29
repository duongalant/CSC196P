package alantduong.com.lab10

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class Service : AppCompatActivity() {

    private lateinit var readCountryId : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        readFireStoreData()
        readCountryId = findViewById(R.id.readCountryId)

    }

    fun readFireStoreData() {
        val db = FirebaseFirestore.getInstance()
// Customer: is your database collection name. It is case sensitive.
        db.collection("Customer")
            .get()
            .addOnCompleteListener {
                val result : StringBuffer = StringBuffer()
                if (it.isSuccessful) {
                    for (document in it.result!!) {
// For "Country" use the same spelling which you have used before in the Signup file
// Append("     "): to make a space between country values' results.
                        result.append(document.data.getValue("Country")).append("      ")
                    }
                    readCountryId.setText(result)
                }
            }
    }
}