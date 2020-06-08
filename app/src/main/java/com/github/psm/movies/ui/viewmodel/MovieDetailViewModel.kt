/*
 * Create date 6/8/20 5:18 PM
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

import androidx.lifecycle.ViewModel
import com.github.psm.movies.data.Repository

class MovieDetailViewModel internal constructor(movieId:String,repository: Repository): ViewModel() {
    val movie = repository.getMovie(movieId)
}