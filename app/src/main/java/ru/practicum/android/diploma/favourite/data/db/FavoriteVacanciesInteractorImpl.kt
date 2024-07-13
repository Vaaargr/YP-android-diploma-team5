package ru.practicum.android.diploma.favourite.data.db

import kotlinx.coroutines.flow.Flow
import ru.practicum.android.diploma.favourite.domain.models.VacancyDetails

class FavoriteVacanciesInteractorImpl(private val favoriteVacanciesRepository: FavoriteVacanciesRepository) :
    FavoriteVacanciesInteractor {

    override suspend fun insertFavoriteVacancy(vacancy: VacancyDetails) {
        favoriteVacanciesRepository.insertFavoriteVacancy(vacancy)
    }

    override suspend fun deleteFavoriteVacancy(vacancyId: String) {
        favoriteVacanciesRepository.deleteFavoriteVacancy(vacancyId)
    }

    override fun getFavoriteVacancy(vacancyId: String): Flow<FavoriteVacancyState> {
        return favoriteVacanciesRepository.getFavoriteVacancy(vacancyId)
    }

    override fun getFavoriteVacanciesId(): Flow<FavoriteVacanciesIdState> {
        return favoriteVacanciesRepository.getFavoriteVacanciesId()
    }

}
