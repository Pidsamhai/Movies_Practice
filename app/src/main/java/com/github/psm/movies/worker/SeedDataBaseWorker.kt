/*
 * Create date 6/7/20 4:11 PM
 *
 * Copyright 2020 Pidsamhai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.psm.movies.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.github.psm.movies.data.AppDataBase
import com.github.psm.movies.data.Movie
import com.github.psm.movies.utils.MOVIE_DATA_FILE_NAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.coroutineScope
import com.google.gson.stream.JsonReader

class SeedDataBaseWorker(context: Context, parameters: WorkerParameters) :
    CoroutineWorker(context, parameters) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(MOVIE_DATA_FILE_NAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val type = object : TypeToken<List<Movie>>() {}.type
                    val movieList: List<Movie> = Gson().fromJson(jsonReader, type)
                    Log.i("SEED DATA", movieList.toString())
                    val dataBase = AppDataBase.getInstance(applicationContext)
                    dataBase.movieDao().insertMovie(movieList)
                    Result.success()
                }
            }
        }catch (e:Exception) {
            e.printStackTrace()
            Result.failure()
        }
    }

}