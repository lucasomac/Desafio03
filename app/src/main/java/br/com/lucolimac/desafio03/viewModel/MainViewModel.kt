package br.com.lucolimac.desafio03.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucolimac.desafio03.domain.Result
import br.com.lucolimac.desafio03.service.Repository
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository) : ViewModel() {
    var listComics = MutableLiveData<ArrayList<Result>>()
    fun allComics(offSet: Int) {
        viewModelScope.launch {
            repository.getComics(
                offSet,
                12,
                "1",
                "f9cb9b2e474b53391d7ef0b68943eb1f",
                "05841f118ae7797fcb7179bc8a6924bf"
            ).also { listComics.postValue(it.data.results) }
        }
    }
}