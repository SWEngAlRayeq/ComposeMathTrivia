package app.math_trivia.data.api

import app.math_trivia.data.model.MathFactResponse
import retrofit2.http.GET

interface MathApi {

    @GET("random/math?json")
    suspend fun getMathFact(): MathFactResponse


}