package sheridan.zammichr.prog_practice.ui.output

import android.app.Activity
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import sheridan.zammichr.prog_practice.R
import sheridan.zammichr.prog_practice.databinding.OutputFragmentBinding
import sheridan.zammichr.prog_practice.ui.dialogs.ConfirmationDialog

class OutputFragment : Fragment() {

    companion object{
        const val CONFIRM_DELETE: Int = 1
    }

    private val safeArgs: OutputFragmentArgs by navArgs()

    private val viewModel: OutputViewModel by viewModels {
        OutputViewModelFactory(safeArgs.hikingId, requireActivity().application)
    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =
            OutputFragmentBinding.inflate(inflater, container, false)

        // data-bind the viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.okayBtn.setOnClickListener { showInput() }

        navController = findNavController()

        // show input page when the data is deleted from the database
        viewModel.state.observe(viewLifecycleOwner){
            if(it.status == OutputViewModel.Status.DELETED_DATA){
                showInput()
            }
        }

        // make the delete confirmation dialog work
        ConfirmationDialog.setResultListener(this, R.id.outputFragment) {
            if (it?.requestCode == CONFIRM_DELETE && it.resultCode == Activity.RESULT_OK) {
                viewModel.delete()
            }
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_output, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_delete -> {
                val settings = KittySettings(requireContext())
                if(settings.confirmDelete){
                    val action = OutputFragmentDirections.actionOutputToConfirmation(
                        getString(R.string.confirm_delete_message), CONFIRM_DELETE)
                    navController.navigate(action)
                } else {
                    viewModel.delete()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showInput(){
        val action = OutputFragmentDirections.actionGlobalToInput()
        navController.navigate(action)
    }

}