package app.math_trivia.di

import app.math_trivia.data.api.MathApi
import app.math_trivia.data.repo_impl.MathRepositoryImpl
import app.math_trivia.domain.repo.MathRepository
import app.math_trivia.domain.usecase.GetMathFactUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMathApi(): MathApi {
        return Retrofit.Builder()
            .baseUrl("http://numbersapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .build()
            .create(MathApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: MathApi): MathRepository =
        MathRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideUseCase(repository: MathRepository): GetMathFactUseCase =
        GetMathFactUseCase(repository)


}