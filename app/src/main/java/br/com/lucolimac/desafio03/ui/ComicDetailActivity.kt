package br.com.lucolimac.desafio03.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.lucolimac.desafio03.databinding.ActivityComicDetailBinding
import br.com.lucolimac.desafio03.domain.Entities
import br.com.lucolimac.desafio03.service.repository
import br.com.lucolimac.desafio03.viewModel.ComicDetailViewModel
import com.bumptech.glide.annotation.GlideModule

@GlideModule
class ComicDetailActivity : AppCompatActivity() {
    private lateinit var comic: Entities
    private lateinit var binding: ActivityComicDetailBinding

    val viewModel by viewModels<ComicDetailViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ComicDetailViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val comicId = intent.getIntExtra("comicId", 0)
        binding = ActivityComicDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_comic_detail)
//        if (comicId == 0) {
//            Toast.makeText(this, "Comic não encontrada", Toast.LENGTH_SHORT).show()
//            onBackPressed()
//        }
        viewModel.getComic(comicId)
        viewModel.comic.observe(this) {
            comic = it
            binding.tvName.text = comic.data.results[0].title
            binding.tvOverview.text = comic.data.results[0].description
        }
        binding.ivArrowBackDetail.setOnClickListener { onBackPressed() }

    }
}