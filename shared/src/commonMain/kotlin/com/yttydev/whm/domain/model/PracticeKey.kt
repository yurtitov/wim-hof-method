package com.yttydev.whm.domain.model

data class PracticeKey(val id: Long) {

    fun isEmpty(): Boolean = this == EMPTY

    companion object {
        val EMPTY = PracticeKey(0)
    }
}
