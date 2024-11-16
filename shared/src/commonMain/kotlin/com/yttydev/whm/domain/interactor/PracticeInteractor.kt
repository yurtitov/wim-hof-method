package com.yttydev.whm.domain.interactor

import com.yttydev.whm.data.exception.NotFoundException
import com.yttydev.whm.domain.api.PracticeRepository
import com.yttydev.whm.domain.exception.PracticeNotFoundException
import com.yttydev.whm.domain.model.Practice

class PracticeInteractor(private val practiceRepository: PracticeRepository) {

    /**
     * Creates a new `Practice` if it is not already present, or updates an existing one.
     *
     * This method checks whether the provided `Practice` object is new or already exists in the repository.
     * - If the practice is new, it is created and saved to the repository.
     * - If the practice is not new, it attempts to retrieve the existing practice by its key.
     * - If the practice is not found, a custom exception (`PracticeNotFoundException`) is thrown.
     *   Otherwise, the existing practice is updated in the repository.
     *
     * @param practice The `Practice` object to be created or updated.
     * @return The created or updated `Practice` object.
     * @throws PracticeNotFoundException If the practice with the given key is not found
     * when attempting to update it.
     */
    fun createOrUpdate(practice: Practice): Practice {
        return if (practice.isNew()) {
            practiceRepository.create(practice)
        } else {
            try {
                practiceRepository.getByKey(practice.practiceKey)
            } catch (e: NotFoundException) {
                throw PracticeNotFoundException(e.message)
            }
            return practiceRepository.update(practice)
        }
    }
}
