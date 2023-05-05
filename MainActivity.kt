package com.example.navdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.navdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        //databinding
      val binding:ActivityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.add.setOnClickListener(){
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }
}