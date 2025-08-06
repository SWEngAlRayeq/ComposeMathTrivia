package app.math_trivia.domain.repo

import app.math_trivia.data.model.MathFactResponse

interface MathRepository {

    suspend fun getMathFact(): MathFactResponse

}