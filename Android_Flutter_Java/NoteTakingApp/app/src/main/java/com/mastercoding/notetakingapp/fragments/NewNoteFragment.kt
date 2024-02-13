package com.mastercoding.notetakingapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import com.mastercoding.notetakingapp.MainActivity
import com.mastercoding.notetakingapp.R
import com.mastercoding.notetakingapp.adapter.NoteAdapter
import com.mastercoding.notetakingapp.databinding.FragmentHomeBinding
import com.mastercoding.notetakingapp.databinding.FragmentNewNoteBinding
import com.mastercoding.notetakingapp.viewmodel.NoteViewModel
import com.mastercoding.notetakingapp.model.Note


class NewNoteFragment : Fragment(R.layout.fragment_new_note) {

    private var _binding : FragmentNewNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var notesViewModel : NoteViewModel
    private lateinit var noteAdapter: NoteAdapter

    private lateinit var mView: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel = (activity as MainActivity).noteViewModel
        mView = view

    }


    private fun savenote(view: View){
        val noteTitle = binding.etNoteTitle.text.toString().trim()
        val noteBody = binding.etNoteBody.text.toString().trim()

        if (noteTitle.isNotEmpty()){
            val note = Note(0,noteTitle, noteBody)

            notesViewModel.addNote(note)

            Toast.makeText(mView.context,
            "Note Saved Successfully",
            Toast.LENGTH_LONG).show()

            view.findNavController().navigate(R.id.action_newNoteFragment_to_homeFragment)



        }
        else{
            Toast.makeText(
                mView.context,
                "Please enter note Title",
                Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_new_note, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_save -> {
                savenote(mView)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}