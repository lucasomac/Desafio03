package br.com.lucolimac.desafio03.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.lucolimac.desafio03.ProfileZoomFragment
import br.com.lucolimac.desafio03.R
import br.com.lucolimac.desafio03.databinding.ActivityComicDetailBinding
import br.com.lucolimac.desafio03.domain.Result
import br.com.lucolimac.desafio03.service.repository
import br.com.lucolimac.desafio03.util.replaceHttps
import br.com.lucolimac.desafio03.viewModel.ComicDetailViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val comicId = intent.extras?.get("comicId")
        Log.i("COMIC_ID", "O di da comic é ${comicId.toString()}")
        binding = ActivityComicDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (0 == comicId) {
            Toast.makeText(this, "Comic não encontrada!", Toast.LENGTH_SHORT).show()
            navigateUpTo(parentActivityIntent)
        }
        viewModel.getComic(Integer.parseInt(comicId.toString()))
        viewModel.comic.observe(this) {
            comic = it
            if (!comic.thumbnail.path.isBlank() && !comic.thumbnail.extension.isEmpty())
                Glide.with(this).asBitmap()
                    .load(
                        replaceHttps("${comic.thumbnail.path}.${comic.thumbnail.extension}")
                    )
                    .into(binding.ivPerfilComic)
            if (!comic.images.isNullOrEmpty())
                Glide.with(this).asBitmap()
                    .load(replaceHttps("${comic.images[comic.images.size - 1].path}.${comic.images[comic.images.size - 1].extension}"))
                    .into(binding.ivCapaComic)
            else
                Glide.with(this).asBitmap()
                    .load(
                        replaceHttps("${comic.thumbnail.path}.${comic.thumbnail.extension}")
                    )
                    .into(binding.ivCapaComic)
            binding.tvName.text =
                if (!comic.title.isBlank() && !comic.title.isEmpty()) comic.title else "No data Found!"
            binding.tvOverview.text =
                if (!comic.description.isNullOrBlank() && !comic.description.isNullOrEmpty()) comic.description
                else (if (comic.textObjects.size > 0 && !comic.textObjects[0].text.isNullOrBlank() && !comic.textObjects[0].text.isEmpty()) comic.textObjects[0].text else "No data found!")

            binding.tvPreco.text =
                if (!comic.prices[0].price.isBlank() && !comic.prices[0].price.isEmpty()) "${comic.prices[0].price}" else "No data Found!"

            binding.tvPages.text =
                if (!comic.pageCount.isBlank() && !comic.pageCount.isEmpty()) comic.pageCount else "No data Found!"
            binding.tvPublicacao.text =
                if (!comic.dates[0].date.isBlank() && !comic.dates[0].date.isEmpty())
                    DateTimeFormatter.ofPattern("MMMM dd, yyyy")
                        .format(LocalDateTime.parse(comic.dates[0].date.split("-0500")[0]))
                else "No data Found!"
        }
        binding.ivArrowBackDetail.setOnClickListener { onBackPressed() }
        binding.ivPerfilComic.setOnClickListener {
            showFragmentImage()
        }
    }

    fun showFragmentImage() {
        val fragZoomProfile = ProfileZoomFragment.newInstance(replaceHttps("${comic.thumbnail.path}.${comic.thumbnail.extension}"))
        fragZoomProfile.arguments =
            bundleOf("url" to replaceHttps("${comic.thumbnail.path}.${comic.thumbnail.extension}"))
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, fragZoomProfile).commit()
        }
    }
}