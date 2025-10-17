package com.jeruk.week6.ui.view.SoalJason

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.jeruk.week6.ui.model.SoalJason.User
import com.jeruk.week6.ui.model.SoalJason.UserDataResource
import com.jeruk.week6.ui.model.SoalJason.Workout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Soal2ViewModel : ViewModel() {

    private val _friends = MutableStateFlow<List<User>>(emptyList())
    val friends: StateFlow<List<User>> = _friends

    private val _addedFriends = MutableStateFlow<List<User>>(emptyList())
    val addedFriends: StateFlow<List<User>> = _addedFriends

    private val _user = MutableStateFlow(UserDataResource.user)
    val user: StateFlow<User> = _user

    private val _workout = MutableStateFlow<List<Workout>>(emptyList())
    val workout: StateFlow<List<Workout>> = _workout

    private val _addedWorkouts = MutableStateFlow<List<Workout>>(emptyList())
    val addedWorkouts: StateFlow<List<Workout>> = _addedWorkouts

    init {
        loadFriend()
        loadUser()
    }

    fun loadFriend() {
        _friends.value = UserDataResource.friends.toList()
    }

    fun loadUser() {
        _user.value = UserDataResource.user
    }

    fun toggleIsAdded(user: User) {
        val index = UserDataResource.friends.indexOfFirst {
            it.name == user.name
        }
        if (index == -1) return
        val updated = UserDataResource.friends[index].copy(
            isFriend = !UserDataResource.friends[index].isFriend,
        )
        UserDataResource.friends[index] = updated

        if (updated.isFriend) {
            if (!_addedFriends.value.any { it.name == user.name }) {
                _addedFriends.value = _addedFriends.value + updated
                val updatedUser = _user.value.copy(friendCount = _user.value.friendCount + 1)
                _user.value = updatedUser
            }
        } else {
            _addedFriends.value = _addedFriends.value.filter { it.name != user.name }
            val updatedUser = _user.value.copy(friendCount = _user.value.friendCount - 1)
            _user.value = updatedUser
        }

        loadFriend()
    }

    fun toggleIsAddedWO(wo: Workout) {
        val index = _workout.value.indexOfFirst { it.name == wo.name }
        if (index == -1) return
        val updated = _workout.value[index].copy(isAdded = !_workout.value[index].isAdded)
        val newList = _workout.value.toMutableList()
        newList[index] = updated
        _workout.value = newList

        if (updated.isAdded && !_addedWorkouts.value.any { it.name == wo.name }) {
            _addedWorkouts.value = _addedWorkouts.value + updated
            val updatedUser = _user.value.copy(workoutCount = _user.value.workoutCount + 1)
            _user.value = updatedUser
        } else if (!updated.isAdded) {
            _addedWorkouts.value = _addedWorkouts.value.filter { it.name != wo.name }
            val updatedUser = _user.value.copy(workoutCount = _user.value.workoutCount - 1)
            _user.value = updatedUser
        }
    }

    fun saveWorkout(title: String, type: String, calories: String, icon: ImageVector) {
        val newWorkout = Workout(
            name = title,
            description = type,
            caloriesBurned = calories.toInt(),
            iconResId = icon,
            isAdded = false
        )
        _workout.value = _workout.value + newWorkout
    }

}