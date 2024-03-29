package alantduong.com.lab09

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var myToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout : DrawerLayout = findViewById(R.id.myDrawerLayout)
        val navView : NavigationView = findViewById(R.id.myDrawerView)

        myToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)

        drawerLayout.addDrawerListener(myToggle)

        myToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.sentId -> {
                    Snackbar.make(findViewById(R.id.sentId), "Your Email has been sent successfully", Snackbar.LENGTH_LONG).show()
                }

                R.id.outboxId -> {
                    Snackbar.make(findViewById(R.id.outboxId), "This is your OutBox folder", Snackbar.LENGTH_LONG).show()
                }

                R.id.spamId -> {
                    Snackbar.make(findViewById(R.id.spamId), "This is your Spam folder", Snackbar.LENGTH_LONG).show()
                }

                R.id.calendarId -> {
                    Snackbar.make(findViewById(R.id.calendarId), "This is your Calendar", Snackbar.LENGTH_LONG).show()
                }

                R.id.contactsId -> {
                    startActivity(Intent(this, Contacts::class.java)) }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item : MenuItem) : Boolean {
        if (myToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}