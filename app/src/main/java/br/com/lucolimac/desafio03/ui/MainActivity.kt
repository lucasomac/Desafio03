package br.com.lucolimac.desafio03.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.lucolimac.desafio03.adapter.ComicAdapter
import br.com.lucolimac.desafio03.databinding.ActivityMainBinding
import br.com.lucolimac.desafio03.service.repository
import br.com.lucolimac.desafio03.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), ComicAdapter.OnClickComic {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterComic: ComicAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.tbMain)
        adapterComic = ComicAdapter(this)
        gridLayoutManager = GridLayoutManager(this, 3)
        binding.rcComics.adapter = adapterComic
        binding.rcComics.layoutManager = gridLayoutManager
        binding.rcComics.hasFixedSize()
//        viewModel.allComics()
//        viewModel.listComics.observe(this) {
//            adapterComic.addComic(it)
//        }

        viewModel.listResultSets.observe(this) {
            adapterComic.addComic(it.data.comics)
            Log.i("DADO", it.toString())
        }
        viewModel.allComicsSpiderMan()
    }

    override fun onClickComic(position: Int) {
        TODO("Not yet implemented")
    }
}