package br.com.lucolimac.desafio03.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucolimac.desafio03.domain.Result
import br.com.lucolimac.desafio03.service.Repository
import br.com.lucolimac.desafio03.util.HASH_API
import br.com.lucolimac.desafio03.util.LIMIT_RETORNO
import br.com.lucolimac.desafio03.util.PUBLIC_API_KEY
import br.com.lucolimac.desafio03.util.TIME_STAMP_API
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository) : ViewModel() {
    var listComics = MutableLiveData<ArrayList<Result>>()
    fun allComics(offSet: Int) {
        viewModelScope.launch {
            repository.getComics(
                offSet,
                LIMIT_RETORNO,
                TIME_STAMP_API,
                PUBLIC_API_KEY,
                HASH_API
            ).also { listComics.postValue(it.data.results) }
        }
    }
}