package sheridan.zammichr.prog_practice.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workoutHiking")
data class WorkoutHiking (
        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @ColumnInfo(name = "workoutName")
        val workoutName: String,

        @ColumnInfo(name = "workoutDate")
        val workoutDate: String,

        @ColumnInfo(name = "workoutTime")
        val workoutTime: String,

        @ColumnInfo(name = "workoutDuration")
        val workoutDuration: String,

        @ColumnInfo(name = "workoutDistance")
        val workoutDistance: String
)