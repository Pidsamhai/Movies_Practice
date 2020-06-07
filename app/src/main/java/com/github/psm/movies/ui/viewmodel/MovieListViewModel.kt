/*
 * Create date 6/7/20 5:01 PM
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

package com.github.psm.movies.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.github.psm.movies.data.Movie
import com.github.psm.movies.data.MovieDao
import com.github.psm.movies.data.Repository

class MovieListViewModel internal constructor(private val repository: Repository) : ViewModel() {
    val movies:LiveData<List<Movie>> = repository.getMovie()
}