/*
 * Create date 6/7/20 5:16 PM
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

package com.github.psm.movies.utils

import android.content.Context
import androidx.fragment.app.Fragment
import com.github.psm.movies.data.AppDataBase
import com.github.psm.movies.data.Repository
import com.github.psm.movies.ui.viewmodel.MovieDetailViewModelFactory
import com.github.psm.movies.ui.viewmodel.MovieListViewModel
import com.github.psm.movies.ui.viewmodel.MovieListViewModelFactory

object InjectUtils {
    fun getPlantRepository(context: Context) : Repository {
        return Repository.getInstance(AppDataBase.getInstance(context).movieDao())
    }
    fun provideMovieListViewModelFactory(
        fragment: Fragment
    ): MovieListViewModelFactory {
        val repository = getPlantRepository(fragment.requireContext())
        return MovieListViewModelFactory(repository)
    }
    fun provideMovieDetailViewModelFactory(
        movieID:String,
        fragment: Fragment
    ): MovieDetailViewModelFactory {
        val repository = getPlantRepository(fragment.requireContext())
        return MovieDetailViewModelFactory(movieID,repository)
    }
}