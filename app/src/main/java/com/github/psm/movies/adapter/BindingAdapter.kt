/*
 * Create date 6/7/20 6:18 PM
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

package com.github.psm.movies.adapter

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.Coil
import coil.api.load

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Log.i("bindImageFromUrl: ",imageUrl)
        view.load(imageUrl)
    }
}