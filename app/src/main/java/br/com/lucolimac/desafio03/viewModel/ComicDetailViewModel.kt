package br.com.lucolimac.desafio03.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucolimac.desafio03.domain.Entities
import br.com.lucolimac.desafio03.service.Repository
import br.com.lucolimac.desafio03.service.repository
import br.com.lucolimac.desafio03.util.HASH_API
import br.com.lucolimac.desafio03.util.PUBLIC_API_KEY
import br.com.lucolimac.desafio03.util.TIME_STAMP_API
import kotlinx.coroutines.launch

class ComicDetailViewModel(repository: Repository) : ViewModel() {
    var comic = MutableLiveData<Entities>()
    fun getComic(comicId: Int) {
        viewModelScope.launch {
            repository.getComic(
                comicId,
                TIME_STAMP_API,
                PUBLIC_API_KEY,
                HASH_API
            ).also { comic.postValue(it) }
        }
    }
}