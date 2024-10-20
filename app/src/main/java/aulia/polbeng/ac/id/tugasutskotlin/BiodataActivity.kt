package aulia.polbeng.ac.id.tugasutskotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import aulia.polbeng.ac.id.tugasutskotlin.databinding.ActivityBiodataBinding

class BiodataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBiodataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBiodataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Save biodata
        binding.btnSaveBiodata.setOnClickListener {
            val name = binding.etName.text.toString()
            val birthplace = binding.etPlaceOfBirth.text.toString()
            val birthdate = binding.etBirthDate.text.toString()
            val age = binding.etAge.text.toString()
            val phone = binding.etPhoneNumber.text.toString()

            if (name.isEmpty() || birthplace.isEmpty() || birthdate.isEmpty() || age.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Create an intent to start DisplayBiodataActivity
                val intent = Intent(this, DisplayBiodataActivity::class.java).apply {
                    putExtra("name", name)
                    putExtra("birthplace", birthplace)
                    putExtra("birthdate", birthdate)
                    putExtra("age", age)
                    putExtra("phone", phone)
                }
                startActivity(intent)
            }
        }
    }
}
