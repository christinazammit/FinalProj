package sheridan.zammichr.prog_practice.ui.output

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sheridan.zammichr.prog_practice.database.WorkoutDaoHiking
import sheridan.zammichr.prog_practice.database.WorkoutDatabase
import sheridan.zammichr.prog_practice.database.WorkoutHiking

class OutputViewModel(
    hikingId: Long, application: Application
) : AndroidViewModel(application) {

    enum class Status { SAVED_DATA, DELETED_DATA }
    data class State(val status: Status, val hikingId: Long?)

    companion object{
        val DELETED_DATA_SATE: State = State(Status.DELETED_DATA, null)
    }

    private val _state = MutableLiveData(State(Status.SAVED_DATA, hikingId))
    val state: LiveData<State> = _state

    private val workoutDaoHiking: WorkoutDaoHiking =
        WorkoutDatabase.getDatabase(application).workoutDaoHiking

    val hikingData: LiveData<WorkoutHiking> = workoutDaoHiking.get(hikingId)

    fun delete(){
        hikingData.value?.let{
            viewModelScope.launch {
                workoutDaoHiking.delete(it)
                _state.value = DELETED_DATA_SATE
            }
        }
    }

}