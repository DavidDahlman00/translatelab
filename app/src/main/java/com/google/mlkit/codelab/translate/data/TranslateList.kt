package com.google.mlkit.codelab.translate.data

import com.google.mlkit.codelab.translate.classes.TranslateItem

object TranslateList {
    var list : MutableList<TranslateItem> = mutableListOf()

    fun add(item: TranslateItem) {
        list.add(item)
    }

    fun removeAt(position: Int) {
        list.removeAt(position)
    }
}