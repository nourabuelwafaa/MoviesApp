package com.movies.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.domain.usecase.MoviesUseCase
import com.movies.presentation.mapper.MoviesViewMapper
import com.movies.presentation.model.MoviesView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val useCase: MoviesUseCase,
    private val mapper: MoviesViewMapper
) : ViewModel() {

    private val _moviesLiveData = MutableLiveData<List<MoviesView>>()

    fun getMovies() {
        viewModelScope.launch {
            val result = useCase.invoke()
            result.fold(
                onSuccess = {
                    _moviesLiveData.value = mapper.map(it)
                },
                onFailure = {
                    // TODO: to be handled
                    _moviesLiveData.value = emptyList()
                })
        }
    }
}
