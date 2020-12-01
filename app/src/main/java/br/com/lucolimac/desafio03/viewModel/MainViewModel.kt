package br.com.lucolimac.desafio03.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucolimac.desafio03.domain.Comic
import br.com.lucolimac.desafio03.domain.ResultSet
import br.com.lucolimac.desafio03.service.Repository
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository) : ViewModel() {
    var listResultSets = MutableLiveData<ResultSet>()
    var listComics = MutableLiveData<ArrayList<Comic>>()
    fun allComicsSpiderMan() {
        viewModelScope.launch {
            listResultSets.postValue(
                repository.getComicsSpider(
                    1,
                    10,
                    "1",
                    "6eb7e8896ec5850c52515a8a23ee97f0",
                    "40a3aa568bb269dfad85ae0c4a297181"
                )
            )
        }
        Log.e("DATAMODEL", listComics.value.toString())
    }

    fun allComics() {
        viewModelScope.launch {
            repository.getComics(
                1,
                10,
                "1",
                "6eb7e8896ec5850c52515a8a23ee97f0",
                "40a3aa568bb269dfad85ae0c4a297181"
            ).also { listComics.value = it.data.comics }
        }
        Log.i("DATAMODEL", listComics.value.toString())
    }

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