package com.example.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.taskapp.databinding.ActivityAddTaskBinding

class AddTask : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding
    private lateinit var db:TaskdatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= TaskdatabaseHelper(this)
        binding.saveButton.setOnClickListener {
            val title=binding.titleEditText.text.toString()
            val content=binding.contentEditText.text.toString()
            val note=Note(0,title,content)
            db.insertnote(note)
            finish()
            Toast.makeText(this,"Task Saved",Toast.LENGTH_SHORT).show()
        }
    }
}