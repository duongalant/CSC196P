package alantduong.com.lab10

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

class Signup : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var createBtn : Button
    private lateinit var emailSignupId : TextView
    private lateinit var passwordSignupId : TextView
    private lateinit var nameId : TextView
    private lateinit var cityId : TextView
    private lateinit var countryId : TextView
    private lateinit var phoneId : TextView

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()
        createBtn = findViewById(R.id.createBtn)
        emailSignupId = findViewById(R.id.emailSignupId)
        passwordSignupId = findViewById(R.id.passwordSignupId)
        nameId = findViewById(R.id.nameId)
        cityId = findViewById(R.id.cityId)
        countryId = findViewById(R.id.countryId)
        phoneId = findViewById(R.id.phoneId)

        createBtn.setOnClickListener() {
            if(emailSignupId.text.trim().toString().isNotEmpty() || passwordSignupId.text.trim().toString().isNotEmpty()) {
                createUser(emailSignupId.text.trim().toString(),passwordSignupId.text.trim().toString())
                newCustomer()
            } else {
                Snackbar.make(findViewById(R.id.createBtn), "Check your username and password, then try again.", Snackbar.LENGTH_LONG).show()
            }
        }
    }
    fun createUser (email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                startActivity(Intent(this, Thankyou::class.java))
            } else {
                Snackbar.make(findViewById(R.id.createBtn),"Enter a valid username and password (6 characters)", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun newCustomer() {
        // Create a new customer
        val customer = hashMapOf(
            "Name" to nameId.text.toString().trim(),
            "City" to cityId.text.toString().trim(),
            "Country" to countryId.text.toString().trim(),
            "Phone Number" to phoneId.text.toString().trim()
        )
        // Add a new document with a generated ID.
        db.collection("Customer")
            .add(customer)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}") }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

}