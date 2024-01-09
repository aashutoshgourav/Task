package com.example.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.taskapp.databinding.ActivityAddTaskBinding
import com.example.taskapp.databinding.ActivityUpdateTaskBinding

class UpdateTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateTaskBinding
    private lateinit var db: TaskdatabaseHelper
    private var noteId:Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUpdateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db= TaskdatabaseHelper(this)

        noteId=intent.getIntExtra("note_id",-1)
        if(noteId==-1){
            finish()
            return
        }

        val note=db.getNodeById(noteId)
        binding.updatetitleEditText.setText(note.title)
        binding.updatecontentEditText.setText(note.content)

        binding.updateButton.setOnClickListener{
            val newTitle=binding.updatetitleEditText.text.toString()
            val newContent=binding.updatecontentEditText.text.toString()
            val updatedNote = Note(noteId,newTitle,newContent)
            db.updateNote(updatedNote)
            finish()
            Toast.makeText(this, "Changes Saved", Toast.LENGTH_SHORT).show()
        }


    }
}