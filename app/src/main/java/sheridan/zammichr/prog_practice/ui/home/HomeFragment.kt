package sheridan.zammichr.prog_practice.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import sheridan.zammichr.prog_practice.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.hikingBtn.setOnClickListener{ showHikingInfo() }
        binding.bikingBtn.setOnClickListener{ showBikingInfo() }
        binding.ropeBtn.setOnClickListener{ showJumpRopeInfo() }
        binding.stairsBtn.setOnClickListener{ showStairsInfo() }
        binding.swimmingBtn.setOnClickListener{ showSwimmingInfo() }
        binding.weightBtn.setOnClickListener{ showWeightInfo() }

        return binding.root
    }

    private fun showHikingInfo() {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage("Hiking has a positive impact on your mental health! Going " +
                "for long hikes stimulates neuron growth and boosts creativity.")
        dialogBuilder.setPositiveButton("Ok",
            DialogInterface.OnClickListener { dialog, whichButton -> })
        val hikingDialog = dialogBuilder.create()
        hikingDialog.show()
    }

    private fun showBikingInfo() {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage("Cycling helps to prevent stroke, heart attack, depression, " +
                "and diabetes!")
        dialogBuilder.setPositiveButton("Ok",
            DialogInterface.OnClickListener { dialog, whichButton -> })
        val bikingDialog = dialogBuilder.create()
        bikingDialog.show()
    }

    private fun showJumpRopeInfo() {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage("Jumping rope regularly can help to improve coordination " +
                "and strengthen bone density!")
        dialogBuilder.setPositiveButton("Ok",
            DialogInterface.OnClickListener { dialog, whichButton -> })
        val jumpRopeDialog = dialogBuilder.create()
        jumpRopeDialog.show()
    }

    private fun showStairsInfo() {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage("Making the conscious effort to take the stairs instead " +
                "of the elevator can be an easy way to combat a sedentary lifestyle and become " +
                "more active!")
        dialogBuilder.setPositiveButton("Ok",
            DialogInterface.OnClickListener { dialog, whichButton -> })
        val stairsDialog = dialogBuilder.create()
        stairsDialog.show()
    }

    private fun showSwimmingInfo() {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage("Swimming can be a great way to get active at any age! " +
                "Exercising in water can help to take pressure off of joints.")
        dialogBuilder.setPositiveButton("Ok",
            DialogInterface.OnClickListener { dialog, whichButton -> })
        val swimmingDialog = dialogBuilder.create()
        swimmingDialog.show()
    }

    private fun showWeightInfo() {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage("Lifting weights can help to regulate your insulin levels " +
                "and can lower inflammation associated with diabetes!")
        dialogBuilder.setPositiveButton("Ok",
            DialogInterface.OnClickListener { dialog, whichButton -> })
        val weightDialog = dialogBuilder.create()
        weightDialog.show()
    }
}