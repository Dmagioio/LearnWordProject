package com.example.myapplication

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.myapplication.databinding.ActivityLearnWordBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityLearnWordBinding? = null
    private val binding
        get() = _binding
            ?: throw IllegalStateException("Binding Error")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLearnWordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.learn)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.layoutAnswer3.setOnClickListener {
            markAnswerCorrect(
                binding.layoutAnswer3,
                binding.tvVariantNumber3,
                binding.tvVariantValue3,
            )
        }

        binding.layoutAnswer1.setOnClickListener {
            markAnswerWrong(
                binding.layoutAnswer1,
                binding.tvVariantNumber1,
                binding.tvVariantValue1,
                )
        }

        binding.btnContinue.setOnClickListener {
            markAnswerNeutral(
                binding.layoutAnswer1,
                binding.tvVariantNumber1,
                binding.tvVariantValue1,
                )
            markAnswerNeutral(
                binding.layoutAnswer3,
                binding.tvVariantNumber3,
                binding.tvVariantValue3,
                )
        }
    }

    private fun markAnswerNeutral(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView,
    ) {

            layoutAnswer.background = ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.shape_rounded_containers
            )


            tvVariantNumber.setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.textVariantsColor
                    )
            )


            tvVariantValue.apply {
                    background = ContextCompat.getDrawable(
                        this@MainActivity,
                        R.drawable.shape_rounded_variants,
                    )
                    setTextColor(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.textVariantsColor
                        )
                    )
            }
    }

//            layoutResult.isVisible = false
//            btnSkip.isVisible = true


    private fun markAnswerWrong(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView,
    ) {
        layoutAnswer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_wrong
        )

        tvVariantNumber.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_wrong
        )

        tvVariantNumber.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )

        tvVariantValue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColorWrong
            )
        )

//        binding.btnSkip.isVisible = false
//
//        binding.layoutResult.setBackgroundColor(
//            ContextCompat.getColor(
//                this@MainActivity,
//                R.color.correctAnswerColorWrong
//            )
//        )
//
//        binding.ivResultIcon.setImageDrawable(
//            ContextCompat.getDrawable(
//                this@MainActivity,
//                R.drawable.ic_wrong
//            )
//        )
//
//        binding.tvResultMessage.text = resources.getString(R.string.title_wrong)
//
//        binding.btnContinue.setTextColor(
//            ContextCompat.getColor(
//                this@MainActivity,
//                R.color.correctAnswerColorWrong
//            )
//        )
//
//        binding.layoutResult.isVisible = true
    }
    private fun markAnswerCorrect(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView,
    ) {
        layoutAnswer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_correct
        )

        tvVariantNumber.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_correct
        )

        tvVariantNumber.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )

        tvVariantValue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor
            )
        )

            

//        binding.btnSkip.isVisible = false
//
//        binding.layoutResult.setBackgroundColor(
//            ContextCompat.getColor(
//                this@MainActivity,
//                R.color.correctAnswerColor
//            )
//        )
//
//        binding.ivResultIcon.setImageDrawable(
//            ContextCompat.getDrawable(
//                this@MainActivity,
//                R.drawable.ic_correct
//            )
//        )
//
//        binding.tvResultMessage.text = resources.getString(R.string.title_correct)
//
//        binding.btnContinue.setTextColor(
//            ContextCompat.getColor(
//                this@MainActivity,
//                R.color.correctAnswerColor
//            )
//        )
//
//        binding.layoutResult.isVisible = true
    }
}
