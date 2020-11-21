package sheridan.zammichr.prog_practice.ui.add_workouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import sheridan.zammichr.prog_practice.R
import sheridan.zammichr.prog_practice.database.WorkoutHiking
import sheridan.zammichr.prog_practice.databinding.AddHikingFragmentBinding

class AddHikingFragment : Fragment() {

    private lateinit var binding: AddHikingFragmentBinding

    private val viewModel: AddHikingViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AddHikingFragmentBinding.inflate(inflater, container, false)

        binding.submitBtn.setOnClickListener {submit()}

        viewModel.state.observe(viewLifecycleOwner) {
            if(it.status == AddHikingViewModel.Status.SAVED_DATA) showOutput(it.workoutId!!)
        }

        return binding.root
    }

    private fun submit() {
        val name: String = binding.workoutTitleInput.toString()
        val date: String = binding.workoutDateInput.toString()
        val time: String = binding.workoutTimeInput.toString()
        val duration: String = binding.workoutDurationInput.toString()
        val distance: String = binding.workoutDistance.toString()

        viewModel.saveHiking(WorkoutHiking(0, name, date, time, duration, distance))
    }

    private fun showOutput(hikingId: Long) {
        val action = AddHikingFragmentDirections.actionHikingToJournal(hikingId)
        findNavController().navigate(action)
    }

}