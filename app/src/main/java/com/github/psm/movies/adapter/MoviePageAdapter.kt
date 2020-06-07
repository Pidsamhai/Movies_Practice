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

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.psm.movies.ui.fragment.FavoriteFragment
import com.github.psm.movies.ui.fragment.MovieFragment
import java.lang.IndexOutOfBoundsException


const val FAVORITE_TAB_INDEX = 0
const val MOVIE_TAB_INDEX = 1

class MoviePageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    /**
     *
     */
    private val tabFragmentCreator: Map<Int, () -> Fragment> = mapOf(
        FAVORITE_TAB_INDEX to { FavoriteFragment() },
        MOVIE_TAB_INDEX to { MovieFragment() }
    )

    override fun getItemCount(): Int = tabFragmentCreator.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}