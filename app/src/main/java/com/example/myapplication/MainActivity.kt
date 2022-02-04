package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import java.lang.reflect.Array

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd:Button = findViewById(R.id.btnAdd)
        val lv:ListView = findViewById(R.id.lv)

        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            mutableListOf()
        )
        lv.adapter = adapter
    }
}