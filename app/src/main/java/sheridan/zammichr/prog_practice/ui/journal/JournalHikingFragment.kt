package sheridan.zammichr.prog_practice.ui.journal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import sheridan.zammichr.prog_practice.database.WorkoutHiking
import sheridan.zammichr.prog_practice.databinding.FragmentJournalHikingBinding
import sheridan.zammichr.prog_practice.ui.journal1.JournalHikingRecyclerViewAdapter
import sheridan.zammichr.prog_practice.ui.journal1.JournalHikingViewModel

class JournalHikingFragment : Fragment() {

    companion object{
        const val CONFIRM_CLEAR: Int = 2
    }

    private lateinit var binding: FragmentJournalHikingBinding

    private lateinit var adapter: JournalHikingRecyclerViewAdapter

    private val viewModel: JournalHikingViewModel by viewModels()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJournalHikingBinding.inflate(inflater, container, false)

        adapter = JournalHikingRecyclerViewAdapter(requireContext())

        with(binding) {
            val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            recyclerView.addItemDecoration(divider)
            recyclerView.adapter = adapter
        }
        viewModel.hiking.observe(viewLifecycleOwner) {refreshHistory(it)}

        navController = findNavController()

        return binding.root
    }

    private fun refreshHistory(list: List<WorkoutHiking>?) {
        adapter.hikingWorkout = list
        val count = list?.size ?: 0
    }
}