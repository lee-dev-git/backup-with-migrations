package a.alt.z.backupwithmigrations

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface JournalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(journal: Journal)

    @Query("SELECT * FROM journal ORDER BY date DESC")
    suspend fun all(): List<Journal>
}