package com.example.gdgfinder.add

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.gdgfinder.R
import com.example.gdgfinder.databinding.AddGdgFragmentBinding
import com.google.android.material.snackbar.Snackbar

class AddGdgFragment : Fragment() {


    private val viewModel: AddGdgViewModel by lazy {
        ViewModelProvider(this).get(AddGdgViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = AddGdgFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel


        viewModel.showSnackBarEvent.observe(viewLifecycleOwner, {
            if (it == true) { // Observed state is true.
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    getString(R.string.application_submitted),
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()
                viewModel.doneShowingSnackbar()
            }
        })

        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.add_gdg_fragment, container, false)
    }


}