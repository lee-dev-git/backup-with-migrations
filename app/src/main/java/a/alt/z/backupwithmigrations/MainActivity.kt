package a.alt.z.backupwithmigrations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val database by lazy { AppDatabase.getInstance(applicationContext) }

    /*
    private val testData = listOf(
        Journal(id = 0L, emotion = 0, date = 20201103, imageUri = null, content = "서울", createdAt = 20201103, updatedAt = 20201103),
        Journal(id = 1L, emotion = 4, date = 20201105, imageUri = null, content = "부산", createdAt = 20201105, updatedAt = 20201105),
        Journal(id = 2L, emotion = 2, date = 20201106, imageUri = null, content = "대구", createdAt = 20201106, updatedAt = 20201106),
        Journal(id = 3L, emotion = 6, date = 20201109, imageUri = null, content = "광주", createdAt = 20201109, updatedAt = 20201109),
        Journal(id = 4L, emotion = 1, date = 20201111, imageUri = null, content = "경기", createdAt = 20201111, updatedAt = 20201111)
    )
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch(Dispatchers.IO) {
            // testData.forEach { database.journalDao().add(it) }
            database.journalDao().all().forEach { Log.d("backup-migration", "$it") }
        }
    }

    private fun backup() { val dbFile = getDatabasePath(AppDatabase.databaseName) }

    private fun restore() {}
}