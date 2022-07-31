package com.example.starwarswiki.ui.films

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarswiki.databinding.FragmentFilmsBinding
import com.example.starwarswiki.databinding.ItemFilmBinding
import com.example.starwarswiki.model.Film
import dagger.hilt.android.AndroidEntryPoint

class FilmAdapter : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    private var items: List<Film> = emptyList()

    fun addFilms(films: List<Film>) {
        items = films
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(film: Film) {
            binding.filmName.text = film.title
            binding.filmEpisode.text = "Episode ${film.episodeId}"
            binding.filmReleaseDate.text = film.releaseDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

@AndroidEntryPoint
class FilmsFragment : Fragment() {

    private val viewModel: FilmsViewModel by viewModels()
    private lateinit var binding: FragmentFilmsBinding
    private val filmAdapter: FilmAdapter by lazy { FilmAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmsBinding.inflate(inflater, container, false)
        binding.filmList
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.filmList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = filmAdapter
            setHasFixedSize(true)
        }

        viewModel.films.observe(viewLifecycleOwner) { films ->
            filmAdapter.addFilms(films.results)
        }
    }
}