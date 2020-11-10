package a.alt.z.backupwithmigrations

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Journal::class], version = 2)
abstract class AppDatabase: RoomDatabase() {

    abstract fun journalDao(): JournalDao

    companion object {
        private val MIGRATION_1_2 = object: Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                /*
                database.apply {
                    execSQL("CREATE TABLE journal_ (id INTEGER, emotion INTEGER, date INTEGER, uris TEXT, content TEXT, createdAt INTEGER, updatedAt INTEGER)")
                    execSQL("INSERT INTO journal_ (id, emotion, date, uris, content, createdAt, updatedAt) SELECT id, emotion, date, uris, content, createdAt, updatedAt from journal")
                    execSQL("DROP TABLE journal")
                    execSQL("ALTER TABLE journal_ RENAME TO journal")
                }
                */
                database.execSQL("ALTER TABLE journal ADD COLUMN sticker TEXT NOT NULL DEFAULT ''")
            }
        }

        const val databaseName = ".db"

        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = instance ?: synchronized(this) {
            Room.databaseBuilder(context, AppDatabase::class.java, databaseName)
                .addMigrations(MIGRATION_1_2)
                .build()
        }
    }
}