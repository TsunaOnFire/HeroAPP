package com.aph.diusframi.ui.viewmodel

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aph.diusframi.domain.GetCharacters
import com.aph.diusframi.domain.SetFavCharacter
import com.aph.diusframi.domain.model.Character

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacters: GetCharacters,
    private val updateCharacter: SetFavCharacter
    ): ViewModel() {

    val characterListFiltered = MutableLiveData<MutableList<Character>>()//Filtered List
    val isLoading = MutableLiveData<Boolean>()

    private var completeCharacterList= listOf<Character>()

    fun onCreate() {

        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCharacters()

            if(!result.isNullOrEmpty()){
                completeCharacterList=result
                characterListFiltered.postValue(result.toMutableList())

            }
            isLoading.postValue(false)
        }
    }


    fun filterCharacters(toSearch:String){
        viewModelScope.launch {
            isLoading.postValue(true)
            if (toSearch.isNotBlank()) {
                val result=mutableListOf<Character>()
                completeCharacterList.forEach { if(it.name?.toLowerCase(Locale.getDefault())?.contains(toSearch) == true){result.add(it)} }
                characterListFiltered.postValue(result)
            } else {
                characterListFiltered.postValue(completeCharacterList.toMutableList())
            }
            isLoading.postValue(false)
        }
    }

    fun updateCharacterList(isFavourite:Boolean, id:Int){
        viewModelScope.launch {
            var result=updateCharacter.invoke(isFavourite, id)
            var item=characterListFiltered.value?.firstOrNull { it.id!=null && it.id==id }
            if(item!=null){item.fav=isFavourite}

            var item2=completeCharacterList.firstOrNull { it.id!=null && it.id==id }
            if(item2!=null){item2.fav=isFavourite}

        }
    }




}