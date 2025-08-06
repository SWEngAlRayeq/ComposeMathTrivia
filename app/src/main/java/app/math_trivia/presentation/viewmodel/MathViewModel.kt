package app.math_trivia.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.math_trivia.domain.usecase.GetMathFactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MathViewModel @Inject constructor(
    private val getMathFactUseCase: GetMathFactUseCase
) : ViewModel() {

    var fact by mutableStateOf<String?>(null)
        private set

    var isLoading by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)

    init {
        getFact()
    }

    fun getFact() {
        viewModelScope.launch {
            isLoading = true
            error = null
            try {
                val result = getMathFactUseCase()
                fact = result.text
            } catch (e: Exception) {
                error = e.message ?: "Unknown error"
            }
            isLoading = false
        }
    }


}