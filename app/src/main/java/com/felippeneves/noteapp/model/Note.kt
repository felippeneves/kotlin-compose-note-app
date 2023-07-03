package com.felippeneves.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date
import java.util.Locale
import java.util.UUID

@Entity(tableName = "TB_NOTES")
data class Note(
    @PrimaryKey
    @ColumnInfo(name = "ID")
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "NOTE_TITLE")
    val title: String,

    @ColumnInfo(name = "NOTE_DESCRIPTION")
    val description: String,

    @ColumnInfo(name = "NOTE_ENTRY_DATE")
//    val entryDate: String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
    val entryDate: Date = Date.from(Instant.now())
)
