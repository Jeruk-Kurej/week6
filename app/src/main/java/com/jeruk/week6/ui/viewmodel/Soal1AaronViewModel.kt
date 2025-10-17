package com.jeruk.week6.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.jeruk.week6.ui.model.SoalAaron.Food
import com.jeruk.week6.ui.model.SoalAaron.FoodDataResource
import com.jeruk.week6.ui.model.SoalJason.User
import com.jeruk.week6.ui.model.SoalJason.UserDataResource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Soal1ViewModel : ViewModel() {

    private val _foodList = MutableStateFlow<List<Food>>(emptyList())
    val foods: StateFlow<List<Food>> = _foodList

    private val _vegetableList = MutableStateFlow<List<Food>>(emptyList())
    val vegetables: StateFlow<List<Food>> = _vegetableList

    init {
        loadFood()
    }

    fun loadFood() {
        _foodList.value = FoodDataResource.foodList.toList()
        _vegetableList.value = FoodDataResource.vegetable.toList()
    }

}