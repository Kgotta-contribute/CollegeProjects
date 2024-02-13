package com.mastercoding.notetakingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mastercoding.notetakingapp.database.NoteDatabase
import com.mastercoding.notetakingapp.databinding.ActivityMainBinding
import com.mastercoding.notetakingapp.repository.NoteRepository
import com.mastercoding.notetakingapp.viewmodel.NoteViewModel
import com.mastercoding.notetakingapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var  noteViewModel : NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()



    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))

        val viewModelProviderFactory = NoteViewModelFactory(application,
            noteRepository)

         noteViewModel = ViewModelProvider(
             this,
             viewModelProviderFactory)
             .get(NoteViewModel::class.java)
    }
}
