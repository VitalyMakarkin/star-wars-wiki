package com.example.starwarswiki.ui.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.starwarswiki.databinding.FragmentFilmBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmFragment : Fragment() {

    private val viewModel: FilmViewModel by viewModels()
    private lateinit var binding: FragmentFilmBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.film.observe(viewLifecycleOwner) {
            //
        }
    }

    companion object {
        private const val PARAM_ID = "param_id"

        @JvmStatic
        fun newInstance(id: Int) =
            FilmFragment().apply {
                arguments = Bundle().apply {
                    putInt(PARAM_ID, id)
                }
            }
    }
}