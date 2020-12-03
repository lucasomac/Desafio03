package br.com.lucolimac.desafio03.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.lucolimac.desafio03.adapter.ComicAdapter
import br.com.lucolimac.desafio03.databinding.ActivityMainBinding
import br.com.lucolimac.desafio03.service.repository
import br.com.lucolimac.desafio03.util.LIMIT_RETORNO
import br.com.lucolimac.desafio03.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), ComicAdapter.OnClickComic {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterComic: ComicAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    var offset = 0
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

        viewModel.allComics(offset)
        viewModel.listComics.observe(this) {
            adapterComic.addComic(it)
            binding.pbCardComic.visibility = INVISIBLE
        }
        setScroller()
    }

    fun setScroller() {
        binding.rcComics.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    val viewedItens = gridLayoutManager.childCount
                    val vitem = gridLayoutManager.findFirstCompletelyVisibleItemPosition()
                    val totalItens = adapterComic.itemCount
                    if (viewedItens + vitem >= totalItens) {
                        Log.i("TAG", dy.toString())
                        offset += LIMIT_RETORNO
                        viewModel.allComics(offset)
                    }
                }
            }
        })
    }

    override fun onClickComic(position: Int) {
        val comic = adapterComic.listComic[position]
        val intent = Intent(this, ComicDetailActivity::class.java)
        intent.putExtra("comicId", comic.id)
        startActivity(intent)
    }
}