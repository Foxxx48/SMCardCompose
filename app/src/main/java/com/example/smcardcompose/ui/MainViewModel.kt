package com.example.smcardcompose.ui

import android.util.Log
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.smcardcompose.domain.FeedPost
import com.example.smcardcompose.domain.StatisticItem

class MainViewModel: ViewModel() {

    private val _feedPost = MutableLiveData(FeedPost())
    val feedPost: LiveData<FeedPost> = _feedPost

    fun updateCount(item: StatisticItem) {
        Log.d("Test", "updateCount ViewModel ")
        val oldStatistics = feedPost.value?.statistics ?: throw IllegalStateException()
        val newStatistics =
            oldStatistics.toMutableStateList().apply {
                replaceAll { oldItem ->
                    if (oldItem.type == item.type) {
                        oldItem.copy(count = oldItem.count + 1)
                    } else {
                        oldItem
                    }
                }
            }
        _feedPost.value = feedPost.value?.copy(statistics = newStatistics)

    }
}