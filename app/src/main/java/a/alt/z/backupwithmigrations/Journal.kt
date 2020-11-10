package a.alt.z.backupwithmigrations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journal")
data class Journal(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val emotion: Int,
    val date: Long,
    @ColumnInfo(name = "image_uri") val imageUri: String?,
    val content: String,
    @ColumnInfo(name = "created_at") val createdAt: Long,
    @ColumnInfo(name = "updated_at") val updatedAt: Long,
    val sticker: String
)