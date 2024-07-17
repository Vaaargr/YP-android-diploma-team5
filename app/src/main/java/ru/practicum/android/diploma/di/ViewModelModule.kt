package ru.practicum.android.diploma.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.practicum.android.diploma.favourite.presentation.FavoritesViewModel
import ru.practicum.android.diploma.search.presentation.SearchViewModel

val viewModelModule = module {

    viewModel {
        SearchViewModel(get())
    }
    
    viewModel<FavoritesViewModel> {
        FavoritesViewModel(get())
    }

}
