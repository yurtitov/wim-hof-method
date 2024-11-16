package com.yttydev.whm.domain.api

import com.yttydev.whm.domain.model.Practice
import com.yttydev.whm.domain.model.PracticeKey

interface PracticeRepository {

    fun create(practice: Practice): Practice

    fun getByKey(practiceKey: PracticeKey): Practice

    fun update(practice: Practice): Practice

    fun deleteByKey(practiceKey: PracticeKey): Boolean
}
