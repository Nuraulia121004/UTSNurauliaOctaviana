package aulia.polbeng.ac.id.tugasutskotlin

import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import aulia.polbeng.ac.id.tugasutskotlin.databinding.ActivityCalendarBinding

class CalendarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Button to go back to main screen
        binding.btnBack.setOnClickListener {
            finish() // Close current activity and return to the main screen
        }
    }
}