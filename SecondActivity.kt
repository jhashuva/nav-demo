package com.example.navdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.navdemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_second)
        val binding2:ActivitySecondBinding = DataBindingUtil.setContentView(this,R.layout.activity_second)
        var birthdays:ArrayList<Birthday>?=ArrayList()
        binding2.btn.setOnClickListener(){
           // birthdays!!.add(Birthday(binding2.name.text.toString(),binding2.dob.text.toString().parse()))
            val intent = Intent(this,MainActivity::class.java)

        }


    }
}