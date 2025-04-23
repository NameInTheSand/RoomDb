package com.example.roomdb.data.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.roomdb.data.dao.UsersDao
import com.example.roomdb.data.entities.User
import org.koin.java.KoinJavaComponent.inject
import kotlin.random.Random

class AddRandomEntityWorker(
    appContext: Context,
    params: WorkerParameters
) : CoroutineWorker(appContext, params) {

    private val usersDao: UsersDao by inject(UsersDao::class.java)
    private val names = listOf(
        "Sam",
        "Markian",
        "Petro",
        "Ihor"
    )

    override suspend fun doWork(): Result {
        Log.d("TESTTAG", "AddRandomEntityWorker starts")
        usersDao.addUser(
            User(
                name = names.random(),
                age = Random.nextInt(1, 100)
            )
        )
        return Result.success()
    }


}