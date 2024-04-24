package com.example.notesapp.di

import android.content.Context
import androidx.room.Room
import com.example.notesapp.data.NoteDatabase
import com.example.notesapp.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module//-:When you mark a class with the @Module annotation, it becomes a Dagger module.
// A module is responsible for providing dependencies to the components
// (such as activities, fragments, or services) in your application.
// It defines methods that create and configure instances of these dependencies.

//@InstallIn(SingleComponent::class) is indicating that the module should be installed in the SingleComponent component.
// The SingleComponent refers to a Dagger component that typically represents a single instance that is shared throughout the application.
// This may only be used with classes annotated with @Module or
// @EntryPoint.
object AppModule {
    //@Singleton-:Identifies a type that the injector only instantiates once.
    // Not inherited.
    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDatabase):NoteDatabaseDao=
        noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):NoteDatabase
    = Room
        //databaseBuilder()-:
        //Creates a RoomDatabase.Builder for a persistent database.
        //Once a database is built, you should keep a reference to it and re-use it.
        .databaseBuilder(
        context = context,
        klass = NoteDatabase::class.java,
        //The abstract class which is annotated with Database
        // and extends RoomDatabase.
        name = "notes_db"
    ).fallbackToDestructiveMigration().build()
}