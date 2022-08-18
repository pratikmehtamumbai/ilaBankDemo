package com.bankabc.ilabankdemo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bankabc.ilabankdemo.R

class MainActivityViewModel : ViewModel() {

    var displayList: MutableLiveData<ArrayList<String>> = MutableLiveData()

    var data = ArrayList<ArrayList<String>>()

    var sampleImages = intArrayOf(
        R.drawable.visa_classic,
        R.drawable.visa_gold,
        R.drawable.visa_infinite,
        R.drawable.visa_platinum,
        R.drawable.visa_signature
    )

    var sampleImagesName = arrayOf(
        "Classic",
        "Gold",
        "Infinite",
        "Platinum",
        "Signature"
    )

    var currentPosition = 0
        set(value) {
            displayList.postValue(data[value])
            field = value
        }

    init {
        loadData()
        displayList.postValue(data[currentPosition])
    }

    private fun loadData() {
        try {
            data = ArrayList()
            for (i in 1..sampleImages.size) {
                val list = ArrayList<String>()
                for (j in 1..20) {
                    list.add("Visa " + sampleImagesName[i-1] + " Card : Txn No. $j")
                }
                data.add(list)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun filterData(newText: String) {
        val filterList = ArrayList<String>()
        for (item in data[currentPosition]) {
            if (item.contains(newText,true))
                filterList.add(item)
        }
        displayList.postValue(filterList)
    }
}
