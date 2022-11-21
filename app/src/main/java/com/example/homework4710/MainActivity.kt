package com.example.homework4710

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework4710.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*
    Дз: На первой активити добавить EditText + Button, при вводе если значения
 в editText пустое и вы нажали на button, то отобразить Toast, что EditText
 не может быть пустым, иначе Перейти на вторую активити и отобразить значение
 в EditText, также добавить Button, если EditText не пуст, то вернуться на 1
 активити и отобразить текст из 2 активити.(использовать registerForActivity)
     */

    private lateinit var binding: ActivityMainBinding
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            //  you will get result here in result.data
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var textFromActivity: String? = null
        textFromActivity = intent.extras?.getString("key2")
        if (textFromActivity != null) {
            binding.firstEt.setText(textFromActivity)
        }
        initClicker()
    }

    private fun initClicker() {
        with (binding) {
            firstBtn.setOnClickListener {
                if (firstEt.text.isNotEmpty()) {
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra("key", firstEt.text.toString())
                    startForResult.launch(intent)
                }
            }
        }
    }
}