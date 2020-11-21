package sheridan.zammichr.prog_practice.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WorkoutDaoHiking {

    @Insert
    suspend fun insert(hiking: WorkoutHiking): Long

    @Query("SELECT * FROM workoutHiking WHERE id=:key")
    fun get(key: Long): LiveData<WorkoutHiking>

    @Query("SELECT * FROM workoutHiking")
    fun getAll(): LiveData<List<WorkoutHiking>>

    @Delete
    suspend fun delete(hiking: WorkoutHiking)

    @Update
    suspend fun update(hiking: WorkoutHiking)

    @Query("DELETE FROM workoutHiking WHERE id=:key")
    suspend fun delete(key: Long)

    @Query("DELETE FROM workoutHiking")
    suspend fun deleteAll()
}
