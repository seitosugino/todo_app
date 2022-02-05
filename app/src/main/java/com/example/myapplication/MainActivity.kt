package com.example.myapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
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

        btnAdd.setOnClickListener{
            val et = EditText(this)

            AlertDialog.Builder(this)
                .setTitle("項目の追加")
                .setMessage("何をする？")
                .setView(et)
                .setPositiveButton("追加",DialogInterface.OnClickListener { dialogInterface, i ->
                    val myTodo = et.text.toString()
                    adapter.add(myTodo)
                })
                .setNegativeButton("キャンセル",null)
                .show()
        }

        lv.setOnItemClickListener { adapterView, view, i, l ->
            AlertDialog.Builder(this)
                .setTitle("削除しますか？")
                .setPositiveButton("Yes",DialogInterface.OnClickListener { _, _ ->
                    adapter.remove(adapter.getItem(i))
                    adapter.notifyDataSetChanged()
                })
                .setNegativeButton("No",null)
                .show()
        }
    }
}