package ru.practicum.android.diploma.search.domain.models

class VacancyPagination(
    val vacancyList: List<Vacancy>,
    val foundVacancies: Int,
    val page: Int,
    val pages: Int
)
