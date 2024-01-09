package com.example.taskapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db:TaskdatabaseHelper
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= TaskdatabaseHelper(this)
        notesAdapter= NotesAdapter(db.getAllTasks(),this)
        binding.tasksRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.tasksRecyclerView.adapter=notesAdapter

        binding.addButton.setOnClickListener{
            val intent= Intent(this,AddTask::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        notesAdapter.refreshData(db.getAllTasks())
    }



}