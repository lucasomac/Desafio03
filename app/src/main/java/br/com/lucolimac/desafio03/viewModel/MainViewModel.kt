package br.com.lucolimac.desafio03.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucolimac.desafio03.domain.ResultSet
import br.com.lucolimac.desafio03.service.Repository
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository) : ViewModel() {
    var listComics = MutableLiveData<ResultSet>()
    fun allComicsSpiderMan() {
        viewModelScope.launch {
            repository.getComicsSpider(
                1,
                10,
                "1",
                "6eb7e8896ec5850c52515a8a23ee97f0",
                "40a3aa568bb269dfad85ae0c4a297181"
            ).also { listComics.value = it }
        }
    }

//    fun allComics() {
//        viewModelScope.launch {
//            repository.getComics(
//                1,
//                10,
//                "1",
//                "6eb7e8896ec5850c52515a8a23ee97f0",
//                "40a3aa568bb269dfad85ae0c4a297181"
//            ).also { listComics.value = it }
//        }
//    }
//
//    fun getComic(comicId: Int) {
//        viewModelScope.launch {
//            repository.getComic(
//                1,
//                10,
//                "1",
//                "6eb7e8896ec5850c52515a8a23ee97f0",
//                "40a3aa568bb269dfad85ae0c4a297181",
//                comicId
//            ).also { listComics.value = it }
//        }
//    }
}