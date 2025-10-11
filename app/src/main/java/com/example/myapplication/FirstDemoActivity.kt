  package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityFirstDemoBinding

  class FirstDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenSecond.setOnClickListener {
            val intent = Intent(this@FirstDemoActivity, SecondDemoActivity::class.java)
            intent.putExtra("EXTRA_KEY_TEXT", "don't panic")
            intent.putExtra("EXTRA_KEY_NUMBER", 42)
            startActivity(intent)
        }
    }
}