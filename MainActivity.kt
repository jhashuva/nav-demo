package com.example.navdemo

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navdemo.databinding.ActivityMainBinding
import java.time.LocalDate
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    companion object {
        const val ADD_BIRTHDAY_REQUEST_CODE = 1
    }

    private val dobs: ArrayList<Birthday> = ArrayList()
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Set up RecyclerView
        val rv = binding.rv
        rv.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(dobs)
        rv.adapter = adapter

        // Add button click listener to start SecondActivity
        binding.add.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, ADD_BIRTHDAY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_BIRTHDAY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                // Get the ArrayList of Birthday objects from the result Intent
                val newBirthdays = data?.getParcelableArrayListExtra<Birthday>("birthdays")

                // If the ArrayList is not null, add it to the existing ArrayList and update the RecyclerView
                if (newBirthdays != null) {
                    dobs.addAll(newBirthdays)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}





