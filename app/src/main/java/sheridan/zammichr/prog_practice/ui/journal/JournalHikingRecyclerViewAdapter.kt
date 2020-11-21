package sheridan.zammichr.prog_practice.ui.journal

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sheridan.zammichr.prog_practice.database.WorkoutHiking
import sheridan.zammichr.prog_practice.databinding.FragmentJournalItemBinding

class JournalHikingRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<JournalHikingRecyclerViewAdapter.ViewHolder>() {

    var hikingWorkout: List<WorkoutHiking>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(position + 1, hikingWorkout!![position])
    }

    override fun getItemCount(): Int = hikingWorkout?.size?:0

    class ViewHolder(
        private val binding: FragmentJournalItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(count: Int, workoutHiking: WorkoutHiking) {
            binding.count.text = "{count}."
            binding.name.text = workoutHiking.workoutName
            binding.date.text = workoutHiking.workoutDate
            binding.time.text = workoutHiking.workoutTime
            binding.duration.text = workoutHiking.workoutDuration
            binding.distance.text = workoutHiking.workoutDistance
        }
    }

    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = FragmentJournalItemBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(binding)
        }
    }
}