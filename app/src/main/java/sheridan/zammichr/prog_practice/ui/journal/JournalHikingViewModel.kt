package sheridan.zammichr.prog_practice.ui.journal

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import sheridan.zammichr.prog_practice.database.WorkoutDaoHiking
import sheridan.zammichr.prog_practice.database.WorkoutDatabase
import sheridan.zammichr.prog_practice.database.WorkoutHiking

class JournalHikingViewModel(application: Application) : AndroidViewModel(application) {

    private val workoutDaoHiking: WorkoutDaoHiking =
        WorkoutDatabase.getDatabase(application).workoutDaoHiking

    val hiking: LiveData<List<WorkoutHiking>> = workoutDaoHiking.getAll()

    fun clear() {
        viewModelScope.launch {
            workoutDaoHiking.deleteAll()
        }
    }
}