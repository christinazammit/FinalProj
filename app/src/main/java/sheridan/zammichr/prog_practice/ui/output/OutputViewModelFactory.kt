package sheridan.zammichr.prog_practice.ui.output

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import sheridan.zammichr.prog_practice.databinding.OutputFragmentBinding

class OutputViewModelFactory(
    private val hikingId: Long,
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OutputViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OutputViewModel(hikingId, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}