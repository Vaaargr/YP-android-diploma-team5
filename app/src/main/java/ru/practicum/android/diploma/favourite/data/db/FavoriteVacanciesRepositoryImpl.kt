package ru.practicum.android.diploma.favourite.data.db

import android.database.SQLException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.practicum.android.diploma.favourite.data.db.converters.FavoriteVacancyDbConverter
import ru.practicum.android.diploma.favourite.domain.models.VacancyDetails

class FavoriteVacanciesRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val favoriteVacancyDbConverter: FavoriteVacancyDbConverter
) : FavoriteVacanciesRepository {
    override suspend fun insertFavoriteVacancy(vacancy: VacancyDetails) {
        val insertingVacancy = favoriteVacancyDbConverter.map(vacancy)
        appDatabase.favoriteVacanciesDao().insertFavoriteVacancy(insertingVacancy)
    }

    override suspend fun deleteFavoriteVacancy(vacancyId: String) {
        appDatabase.favoriteVacanciesDao().deleteFavoriteVacancy(vacancyId)
    }

    override fun getFavoriteVacancy(vacancyId: String): Flow<FavoriteVacancyState> = flow {
        try {
            val favoriteVacancyFromDataBase = appDatabase.favoriteVacanciesDao().getFavoriteVacancy(vacancyId)
            if (favoriteVacancyFromDataBase == null) {
                emit(FavoriteVacancyState.FailedRequest(error = "В БД отсутствует вакансия"))
            } else {
                val convertedFavoriteVacancy =
                    favoriteVacancyDbConverter.map(favoriteVacancyFromDataBase)
                emit(FavoriteVacancyState.SuccessfulRequest(vacancy = convertedFavoriteVacancy))
            }
        } catch (error: SQLException) {
            emit(FavoriteVacancyState.FailedRequest(error = "$error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun getFavoriteVacanciesId(): Flow<FavoriteVacanciesIdState> = flow {
        try {
            val favoriteVacanciesIdList = appDatabase.favoriteVacanciesDao().getFavoriteVacanciesId()
            val favoriteVacanciesIdArrayList = ArrayList<String>()
            favoriteVacanciesIdArrayList.addAll(favoriteVacanciesIdList)
            emit(FavoriteVacanciesIdState.SuccessfulRequest(vacanciesIdArrayList = favoriteVacanciesIdArrayList))
        } catch (error: SQLException) {
            emit(FavoriteVacanciesIdState.FailedRequest(error = "$error"))
        }
    }.flowOn(Dispatchers.IO)
}
