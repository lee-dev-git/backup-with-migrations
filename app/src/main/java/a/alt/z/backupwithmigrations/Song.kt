package a.alt.z.backupwithmigrations

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song")
data class Song(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String
)