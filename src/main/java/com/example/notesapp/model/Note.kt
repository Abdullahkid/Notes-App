package com.example.notesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

//Entity-:Marks a class as an entity.
// This class will have a mapping SQLite table in the database.
@Entity(tableName = "notes_tbl")
data class Note(
    @PrimaryKey
    val  id : UUID= UUID.randomUUID(),
    //UUID -: A class that represents an immutable universally unique identifier (UUID). A UUID represents a 128-bit value.
    //UUID.randomUUID() -: Static factory to retrieve a type 4 (pseudo randomly generated) UUID.
    // The UUID is generated using a cryptographically strong pseudo random number generator.
    @ColumnInfo(name = "note_title")
    val title : String,
    @ColumnInfo(name = "note_description")
    val description :String,
    @ColumnInfo(name = "note_entry_date")
    val entryDate : Date = Date.from(Instant.now())
)









