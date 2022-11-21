package com.example.homework4710

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework4710.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            //  you will get result here in result.data
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var textFromActivity: String? = intent.extras?.getString("key")
        binding.secondEt.setText(textFromActivity)
        initClicker()
    }

    private fun initClicker() {
        with (binding) {
            secondBtn.setOnClickListener {
                if (secondEt.text.isNotEmpty()) {
                    val intent = Intent(this@SecondActivity, MainActivity::class.java)
                    intent.putExtra("key2", secondEt.text.toString())
                    startForResult.launch(intent)
                }
            }
        }
    }
}