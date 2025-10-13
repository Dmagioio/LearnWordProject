package com.example.myapplication

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityFirstDemoBinding
import com.example.myapplication.databinding.ActivitySecondDemoBinding

class SecondDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondDemoBinding

    private val locationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Log.d("SecondDemoActivity", "Дозвіл на локацію включено")
            } else {
                Log.d("SecondDemoActivity", "Дозвіл на локацію вимкнено")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivitySecondDemoBinding.inflate(layoutInflater)
            setContentView(binding.root)

            Log.i("!!!", "${this.componentName.shortClassName} Виконується: onCreate() ")

            val btnLocation = binding.btnRequestPermission
            btnLocation.setOnClickListener{
                locationPermissionLauncher.launch(ACCESS_FINE_LOCATION)
            }






            with(binding) {

                btnOpenFirst.setOnClickListener {
                    val intent = Intent(this@SecondDemoActivity, FirstDemoActivity::class.java)
                    startActivity(intent)
                }

//                val text = intent.getStringExtra("EXTRA_KEY_TEXT")
//                val number = intent.getIntExtra("EXTRA_KEY_NUMBER", 0)

//                val word: FirstDemoActivity.ExtraWord = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                    intent.getSerializableExtra("EXTRA_KEY_WORD", FirstDemoActivity.ExtraWord::class.java) as FirstDemoActivity.ExtraWord
//                } else {
//                    intent.getSerializableExtra("EXTRA_KEY_WORD") as FirstDemoActivity.ExtraWord
//                }

//                val word = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                    intent.getParcelableExtra("EXTRA_KEY_WORD", FirstDemoActivity.ExtraWord::class.java)
//                } else {
//                    intent.getParcelableExtra("EXTRA_KEY_WORD")
//                }

                val bundle = intent.extras
                val text = bundle?.getString("EXTRA_KEY_TEXT")
                val number = bundle?.getInt("EXTRA_KEY_NUMBER")
                val word = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    bundle?.getParcelable("EXTRA_KEY_WORD", FirstDemoActivity.ExtraWord::class.java)
                } else {
                    TODO("VERSION.SDK_INT < TIRAMISU")
                }

                tvText.text = text
                tvNumber.text = number.toString()
                tvWord.text = word?.original
            }
        }

    override fun onStart() {
        super.onStart()
        Log.i("!!!", "${this.componentName.shortClassName} Виконується: onStart() ")
    }

    override fun onResume() {
        super.onResume()
        Log.i("!!!", "${this.componentName.shortClassName} Виконується: onResume() ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("!!!", "${this.componentName.shortClassName} Виконується: onPause() ")
    }

    override fun onStop() {
        super.onStop()
        Log.i("!!!", "${this.componentName.shortClassName} Виконується: onStop() ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("!!!", "${this.componentName.shortClassName} Виконується: onDestroy() ")
    }
}