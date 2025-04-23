package com.example.roomdb.data.workers.helper

import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.roomdb.data.workers.AddRandomEntityWorker
import java.util.concurrent.TimeUnit

private const val ADD_RANDOM_ENTITY_NAME  = "AddRandomEntityWorker"
class WorkScheduleHelper(
    private val workManager: WorkManager
) {
    fun scheduleRandomEntityAdd(){
        val request = PeriodicWorkRequest.Builder(
            workerClass = AddRandomEntityWorker::class.java,
            repeatInterval = 15,
            repeatIntervalTimeUnit = TimeUnit.MINUTES
        ).build()
        workManager.enqueueUniquePeriodicWork(
            ADD_RANDOM_ENTITY_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            request
        )
    }
}