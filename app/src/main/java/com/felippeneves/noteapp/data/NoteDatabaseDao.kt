package com.felippeneves.noteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.felippeneves.noteapp.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {
    @Query("" +
            "   SELECT *        " +
            "   FROM TB_NOTES   " +
    "")
    fun getNotes(): Flow<List<Note>>

    @Query("" +
            "   SELECT *        " +
            "   FROM TB_NOTES   " +
            "   WHERE ID = :id  " +
    "")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("" +
            "   DELETE          " +
            "   FROM TB_NOTES   " +
            "")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)
}