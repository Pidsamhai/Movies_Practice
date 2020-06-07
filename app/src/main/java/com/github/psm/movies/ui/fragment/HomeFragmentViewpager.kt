/*
 * Create date 6/7/20 5:00 PM
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

package com.github.psm.movies.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.psm.movies.adapter.FAVORITE_TAB_INDEX
import com.github.psm.movies.adapter.MOVIE_TAB_INDEX
import com.github.psm.movies.adapter.MoviePageAdapter
import com.github.psm.movies.R
import com.github.psm.movies.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_view_pager.*

class HomeFragmentViewpager : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewPagerBinding.inflate(inflater,container,false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager
        val adapter = MoviePageAdapter(this)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout,viewPager){tab,position->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        return binding.root
    }



    private fun getTabIcon(position: Int): Int {
        return when (position) {
            MOVIE_TAB_INDEX -> R.drawable.movie_tab_selector
            FAVORITE_TAB_INDEX -> R.drawable.favorite_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            MOVIE_TAB_INDEX -> getString(R.string.movie_title)
            FAVORITE_TAB_INDEX -> getString(
                R.string.favorite_title
            )
            else -> null
        }
    }
}