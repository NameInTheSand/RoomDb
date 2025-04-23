package com.example.roomdb.domain.useCases.work

import com.example.roomdb.data.workers.helper.WorkScheduleHelper

class AddRandomEntityUseCaseImpl(
    private val workScheduleHelper: WorkScheduleHelper
) : AddRandomEntityUseCase {

    override suspend fun addRandomEntity() {
        workScheduleHelper.scheduleRandomEntityAdd()
    }

}