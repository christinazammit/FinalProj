package sheridan.zammichr.prog_practice.ui.add_workouts

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import sheridan.zammichr.prog_practice.database.WorkoutDaoHiking
import sheridan.zammichr.prog_practice.database.WorkoutDatabase
import sheridan.zammichr.prog_practice.database.WorkoutHiking

class AddHikingViewModel(application: Application) : AndroidViewModel(application) {

    enum class Status { NEW_DATA, SAVED_DATA }

    data class State(val status: Status, val workoutId: Long?)

    companion object {
        val NEW_DATA_STATE: State = State(Status.NEW_DATA, null)
    }

    private val _state = MutableLiveData(NEW_DATA_STATE)
    val state: LiveData<State> = _state

    private val workoutDaoHiking: WorkoutDaoHiking =
        WorkoutDatabase.getDatabase(application).workoutDaoHiking

    fun saveHiking(workoutHiking: WorkoutHiking) {
        viewModelScope.launch {
            val workoutId: Long = workoutDaoHiking.insert(workoutHiking)
            _state.value = State(Status.SAVED_DATA, workoutId)
        }
    }

    fun reset() {
        _state.value = NEW_DATA_STATE
    }
}