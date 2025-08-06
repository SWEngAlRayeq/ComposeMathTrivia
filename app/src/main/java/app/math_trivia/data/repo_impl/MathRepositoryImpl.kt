package app.math_trivia.data.repo_impl

import app.math_trivia.data.api.MathApi
import app.math_trivia.data.model.MathFactResponse
import app.math_trivia.domain.repo.MathRepository
import javax.inject.Inject

class MathRepositoryImpl @Inject constructor(
    private val mathApi: MathApi
) : MathRepository {
    override suspend fun getMathFact(): MathFactResponse {
        return mathApi.getMathFact()
    }
}