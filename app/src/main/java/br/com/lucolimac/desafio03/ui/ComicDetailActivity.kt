package br.com.lucolimac.desafio03.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.lucolimac.desafio03.databinding.ActivityComicDetailBinding
import br.com.lucolimac.desafio03.domain.Result
import br.com.lucolimac.desafio03.service.repository
import br.com.lucolimac.desafio03.viewModel.ComicDetailViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule

@GlideModule
class ComicDetailActivity : AppCompatActivity() {
    private lateinit var comic: Result
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
        val comicId = intent.extras?.get("comicId")
        Log.i("COMIC_ID", "O di da comic é ${comicId.toString()}")
        binding = ActivityComicDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_comic_detail)
//        if (comicId == 0) {
//            Toast.makeText(this, "Comic não encontrada", Toast.LENGTH_SHORT).show()
//            onBackPressed()
//        }
        viewModel.getComic(Integer.parseInt(comicId.toString()))
        viewModel.comic.observe(this) {
            comic = it
            Glide.with(this).asBitmap()
                .load("${comic.thumbnail.path}.${comic.thumbnail.extension}")
                .into(binding.ivPerfilComic)
            Glide.with(this).asBitmap()
                .load("${comic.images[0].path}.${comic.images[0].extension}")
                .into(binding.ivCapaComic)
            binding.tvName.text = comic.title
            binding.tvOverview.text = comic.description
//            binding.tvPublicacao.text =
//                SimpleDateFormat("MMMM dd, yyyy", Locale.US).format(comic.dates[0].date)
            binding.tvPages.text = comic.pageCount
            binding.tvPreco.text = "${comic.prices[0].price}"

        }
        binding.ivArrowBackDetail.setOnClickListener { onBackPressed() }

    }
}