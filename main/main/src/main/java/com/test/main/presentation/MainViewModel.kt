package com.test.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.common.navigation.NavigateTo
import com.test.common.network.NetworkStatus
import com.test.core.navigation.NavigationRouter
import com.test.main.domain.usecase.LastDestinationUseCase
import com.test.main.domain.usecase.OffersUseCase
import com.test.main.domain.usecase.SaveDestinationUseCase
import com.test.main.domain.usecase.SaveFinalDestinationUseCase
import com.test.main.presentation.uimodel.Offer
import com.test.main.presentation.uimodel.toUI
import kotlinx.coroutines.launch

class MainViewModel(
    private val router: NavigationRouter<NavigateTo>,
    private val offersUseCase: OffersUseCase,
    private val saveDestinationUseCase: SaveDestinationUseCase,
    private val lastDestinationUseCase: LastDestinationUseCase,
    private val finalDestinationUseCase: SaveFinalDestinationUseCase

): ViewModel() {

    private val _offersResponse: MutableLiveData<NetworkStatus<List<Offer>>> = MutableLiveData()

    val offersResponse: LiveData<NetworkStatus<List<Offer>>> get() = _offersResponse

    fun nextScreen(){
        router.navigateTo(NavigateTo.OffersFragment)
    }

    fun saveDestination(destination: String) = saveDestinationUseCase.saveDestination(destination)

    fun saveFinalDestination(destination: String) = finalDestinationUseCase.saveFinalDestination(destination)

    fun getLastDestination() = lastDestinationUseCase.getLastDestination()

    fun getOffers(){
        viewModelScope.launch {
            try {
                _offersResponse.postValue(NetworkStatus.Loading())
                val response = offersUseCase.getOffers()
                _offersResponse.postValue(NetworkStatus.Success(response.map { it.toUI() }))
            }catch (e: Throwable){
                _offersResponse.postValue(NetworkStatus.Error(e.message ?: "Network Error"))
            }

        }
    }


}