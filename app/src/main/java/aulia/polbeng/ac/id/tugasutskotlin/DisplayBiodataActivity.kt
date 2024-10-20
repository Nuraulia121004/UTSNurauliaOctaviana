package aulia.polbeng.ac.id.tugasutskotlin

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import aulia.polbeng.ac.id.tugasutskotlin.databinding.ActivityDisplayBiodataBinding

class DisplayBiodataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayBiodataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayBiodataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the data from the intent
        val name = intent.getStringExtra("name")
        val birthplace = intent.getStringExtra("birthplace")
        val birthdate = intent.getStringExtra("birthdate")
        val age = intent.getStringExtra("age")
        val phone = intent.getStringExtra("phone")

        // Display the biodata
        val biodataDisplay = """
            Name: $name
            Place of Birth: $birthplace
            Birth Date: $birthdate
            Age: $age
            Phone: $phone
        """.trimIndent()

        binding.tvDisplayBiodata.text = biodataDisplay

        // Back button to return to MainActivity
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Optionally finish this activity
        }
    }
}
