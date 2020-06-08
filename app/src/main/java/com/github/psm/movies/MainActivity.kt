/*
 * Create date 6/7/20 2:31 PM
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

package com.github.psm.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil.setContentView
import com.github.psm.movies.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        floatingActionButton.setOnClickListener {
            when (delegate.localNightMode) {
                AppCompatDelegate.MODE_NIGHT_NO -> {
                    delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
                }
                AppCompatDelegate.MODE_NIGHT_UNSPECIFIED  -> {
                    delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
                }
                AppCompatDelegate.MODE_NIGHT_YES -> {
                    delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
                }
            }
            setIcon()
        }
        setIcon()
    }

    private fun setIcon() {
        when(delegate.localNightMode){
            AppCompatDelegate.MODE_NIGHT_YES -> {
                floatingActionButton.setImageResource(R.drawable.ic_day)
            }
            AppCompatDelegate.MODE_NIGHT_NO -> {
                floatingActionButton.setImageResource(R.drawable.ic_night)
            }
            AppCompatDelegate.MODE_NIGHT_UNSPECIFIED -> {
                floatingActionButton.setImageResource(R.drawable.ic_night)
            }
        }
    }
}