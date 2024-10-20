package aulia.polbeng.ac.id.tugasutskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.CalendarView
import android.widget.Toast
import aulia.polbeng.ac.id.tugasutskotlin.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set placeholder for result
        binding.tvResult.text = getString(R.string.placeholder_result)

        // Operation listeners
        binding.btnAdd.setOnClickListener { performOperation("+") }
        binding.btnSubtract.setOnClickListener { performOperation("-") }
        binding.btnMultiply.setOnClickListener { performOperation("*") }
        binding.btnDivide.setOnClickListener { performOperation("/") }

        // Reset fields and result
        binding.btnResetCalculator.setOnClickListener {
            binding.etNumber1.text.clear()
            binding.etNumber2.text.clear()
            binding.tvResult.text = getString(R.string.placeholder_result)
        }

        // Button to go back to main screen
        binding.btnBack.setOnClickListener {
            finish() // Close current activity and return to the main screen
        }
    }

    private fun performOperation(operator: String) {
        val number1 = binding.etNumber1.text.toString().toDoubleOrNull()
        val number2 = binding.etNumber2.text.toString().toDoubleOrNull()

        if (number1 == null || number2 == null) {
            Toast.makeText(this, getString(R.string.invalid_input), Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operator) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> if (number2 != 0.0) number1 / number2 else getString(R.string.division_by_zero)
            else -> "Invalid operation"
        }

        binding.tvResult.text = result.toString()
    }
}