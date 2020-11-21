package sheridan.zammichr.prog_practice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WorkoutHiking::class], version = 1)

abstract class WorkoutDatabase: RoomDatabase(){

    abstract val workoutDaoHiking: WorkoutDaoHiking

    companion object{

        @Volatile
        private var INSTANCE: WorkoutDatabase? = null

        fun getDatabase(context: Context): WorkoutDatabase {
            //fun getDatabase(context: Context): EnvelopeDatabase {
            /*synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            WorkoutDatabase::class.java,
                            "envelope_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }*/

            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context,
                        WorkoutDatabase::class.java,
                        "workout_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}