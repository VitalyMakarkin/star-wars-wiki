package com.example.starwarswiki.ui.films

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.starwarswiki.databinding.FragmentFilmsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmsFragment : Fragment() {

    private val viewModel: FilmsViewModel by viewModels()
    private lateinit var binding: FragmentFilmsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.films.observe(viewLifecycleOwner) {
            binding.textView.text = viewModel.films.value.toString()
        }
    }
}