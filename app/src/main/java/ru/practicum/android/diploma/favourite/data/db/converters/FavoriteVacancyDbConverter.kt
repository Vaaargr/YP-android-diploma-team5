package ru.practicum.android.diploma.favourite.data.db.converters

import ru.practicum.android.diploma.favourite.data.db.entity.VacancyEntity
import ru.practicum.android.diploma.favourite.domain.models.VacancyDetails

class FavoriteVacancyDbConverter {
    fun map(vacancy: VacancyDetails): VacancyEntity {
        return VacancyEntity(
            vacancyIdInDatabase = vacancy.vacancyIdInDatabase,
            vacancyId = vacancy.vacancyId,
            vacancyName = vacancy.vacancyName,
            employer = vacancy.employer,
            industry = vacancy.industry,
            country = vacancy.country,
            areaId = vacancy.areaId,
            areaRegion = vacancy.areaRegion,
            contactsEmail = vacancy.contactsEmail,
            contactsName = vacancy.contactsName,
            contactsPhones = vacancy.contactsPhones,
            description = vacancy.description,
            employmentType = vacancy.employmentType,
            experienceName = vacancy.experienceName,
            salary = vacancy.salary,
            keySkills = vacancy.keySkills,
            artworkUrl = vacancy.artworkUrl,
            isFavorite = vacancy.isFavorite
        )
    }

    fun map(vacancy: VacancyEntity): VacancyDetails {
        return VacancyDetails(
            vacancyIdInDatabase = vacancy.vacancyIdInDatabase,
            vacancyId = vacancy.vacancyId,
            vacancyName = vacancy.vacancyName,
            employer = vacancy.employer,
            industry = vacancy.industry,
            country = vacancy.country,
            areaId = vacancy.areaId,
            areaRegion = vacancy.areaRegion,
            contactsEmail = vacancy.contactsEmail,
            contactsName = vacancy.contactsName,
            contactsPhones = vacancy.contactsPhones,
            description = vacancy.description,
            employmentType = vacancy.employmentType,
            experienceName = vacancy.experienceName,
            salary = vacancy.salary,
            keySkills = vacancy.keySkills,
            artworkUrl = vacancy.artworkUrl,
            isFavorite = vacancy.isFavorite,
        )
    }
}
