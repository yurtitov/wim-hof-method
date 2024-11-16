package com.yttydev.whm.domain.usecase

import com.yttydev.whm.data.exception.NotFoundException
import com.yttydev.whm.domain.api.PracticeRepository
import com.yttydev.whm.domain.exception.PracticeNotFoundException
import com.yttydev.whm.domain.model.Practice

class CreateOrUpdatePracticeUseCase(private val practiceRepository: PracticeRepository) {

    fun execute(practice: Practice): Practice {
        return if (practice.id == null) {
            practiceRepository.create(practice)
        } else {
            try {
                practiceRepository.getById(practice.id)
            } catch (e: NotFoundException) {
                throw PracticeNotFoundException(e.message)
            }
            return practiceRepository.update(practice)
        }
    }
}