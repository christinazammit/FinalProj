package sheridan.zammichr.prog_practice.database

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