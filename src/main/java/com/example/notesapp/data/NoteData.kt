package com.example.notesapp.data

import com.example.notesapp.model.Note

class NotesDataSource{
    fun loadNotes() : List<Note>{
        return listOf(
            Note(title = "A Good day", description = "We went on a Vacation by the land"),
            Note(title = "A Good day", description = "We went on a Vacation by the land"),
            Note(title = "A Good day", description = "We went on a Vacation by the land"),
            Note(title = "A Good day", description = "We went on a Vacation by the land"),
            Note(title = "A Good day", description = "We went on a Vacation by the land"),
            Note(title = "A Good day", description = "We went on a Vacation by the land"),
            Note(title = "A Good day", description = "We went on a Vacation by the land"),
            Note(title = "A Good day", description = "We went on a Vacation by the land"),
            Note(title = "A Good day", description = "We went on a Vacation by the land"),
            Note(title = "A Good day", description = "We went on a Vacation by the land")
        )
    }
}