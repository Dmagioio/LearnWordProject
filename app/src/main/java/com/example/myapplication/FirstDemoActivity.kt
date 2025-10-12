  package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityFirstDemoBinding
import kotlinx.parcelize.Parcelize
import java.io.Serializable

  class FirstDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val word = ExtraWord(
            "galaxy",
            "галактика",
        )

        binding.btnOpenSecond.setOnClickListener {
            val intent = Intent(this@FirstDemoActivity, SecondDemoActivity::class.java).apply {
                putExtra("EXTRA_KEY_TEXT", "don't panic")
                putExtra("EXTRA_KEY_NUMBER", 42)
                putExtra("EXTRA_KEY_WORD", word)

            }

            val bundle = Bundle()
            bundle.putString("EXTRA_KEY_TEXT", "don't panic")
            bundle.putInt("EXTRA_KEY_NUMBER", 42)
            bundle.putSerializable("EXTRA_KEY_WORD", word)
            intent.putExtras(
                bundleOf(
           "EXTRA_KEY_TEXT" to "don't panic",
                    "EXTRA_KEY_NUMBER" to 42,
                    "EXTRA_KEY_WORD" to word,
                )
            )

            startActivity(intent)
        }
    }

//      @Parcelize
//      data class ExtraWord(
//          val original: String,
//          val translate: String,
//          val learned: Boolean = false,
//      ) : Parcelable

//      data class ExtraWord(
//          val original: String,
//          val translate: String,
//          val learned: Boolean = false,
//      ) : Parcelable {
//          override fun describeContents(): Int {
//              return 0
//          }
//
//          override fun writeToParcel(dest: Parcel, flags: Int) {
//              dest.writeString(original)
//              dest.writeString(translate)
//              dest.writeByte(if (learned) 1 else 0)
//          }
//
//          constructor(parcel: Parcel) : this(
//              original = parcel.readString().toString(),
//              translate = parcel.readString().toString(),
//              learned = parcel.readByte() != 0.toByte()
//          )
//
//          companion object CREATOR : Parcelable.Creator<ExtraWord> {
//              override fun createFromParcel(source: Parcel): ExtraWord? {
//                  return ExtraWord(source)
//              }
//
//              override fun newArray(size: Int): Array<out ExtraWord?>? {
//                  return arrayOfNulls(size)
//              }
//          }
//      }

      data class ExtraWord(
          val original: String,
          val translate: String,
          val learned: Boolean = false,
      ) : Serializable
}