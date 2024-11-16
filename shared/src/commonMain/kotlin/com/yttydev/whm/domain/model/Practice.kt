package com.yttydev.whm.domain.model

data class Practice(
    val practiceKey: PracticeKey = PracticeKey.EMPTY,
    val rounds: List<Round>,
) {
    fun isNew(): Boolean = practiceKey.isEmpty()
}
