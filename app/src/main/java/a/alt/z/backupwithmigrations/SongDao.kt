package a.alt.z.backupwithmigrations

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(song: Song)

    @Query("SELECT * FROM song")
    suspend fun all(): List<Song>
}