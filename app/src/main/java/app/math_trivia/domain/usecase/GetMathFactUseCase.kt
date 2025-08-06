package app.math_trivia.domain.usecase

import app.math_trivia.data.model.MathFactResponse
import app.math_trivia.domain.repo.MathRepository
import javax.inject.Inject

class GetMathFactUseCase @Inject constructor(
    private val mathRepository: MathRepository
) {
    suspend operator fun invoke(): MathFactResponse {
        return mathRepository.getMathFact()
    }
}