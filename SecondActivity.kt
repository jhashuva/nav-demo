package com.example.navdemo

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.navdemo.databinding.ActivitySecondBinding
import java.time.LocalDate
import java.time.ZoneOffset
import java.util.*
import kotlin.collections.ArrayList

class SecondActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding2: ActivitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        // Get the ArrayList of Birthday objects from the Intent
        var birthdays: ArrayList<Birthday>? = intent.getParcelableArrayListExtra<Birthday>("dobs")

        binding2.dob.maxDate = LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli()

        binding2.btn.setOnClickListener {
            // Create a new Birthday object from the user input
            val newBirthday = Birthday(
                binding2.name.text.toString(),
                LocalDate.of(binding2.dob.year, binding2.dob.month+1, binding2.dob.dayOfMonth),
                binding2.bg.text.toString()
            )

            // If the ArrayList is null, create a new one
            if (birthdays == null) {
                birthdays = ArrayList<Birthday>()
            }

            // Add the new Birthday object to the ArrayList
            birthdays?.add(newBirthday)

            // Create a new Intent with the updated ArrayList as the result
            val resultIntent = Intent()
            resultIntent.putExtra("birthdays", birthdays)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
