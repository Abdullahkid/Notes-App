package com.example.notesapp.repository

import com.example.notesapp.data.NoteDatabaseDao
import com.example.notesapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note : Note)= noteDatabaseDao.insert(note)
    suspend fun updateNote(note: Note)= noteDatabaseDao.update(note)
    suspend fun deleteNote(note: Note)= noteDatabaseDao.deleteNote(note)
    suspend fun deleteAllNotes()= noteDatabaseDao.deleteAll()
    fun getAllNotes(): Flow<List<Note>> = noteDatabaseDao.getNotes().flowOn(Dispatchers.IO)
        .conflate()
    //flowOn -: Changes the context where this flow is executed to the given context.
//.conflate() -: is another function call on the Flow object. It conflates emissions,
//which means that if multiple emissions occur before the collector consumes them, only the latest emitted value is kept.
//This can be useful when you don't need to process every intermediate result and only care about the latest value.
}