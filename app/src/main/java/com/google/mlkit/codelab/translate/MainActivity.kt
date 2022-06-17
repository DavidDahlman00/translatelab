/*
 * Copyright 2019 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.google.mlkit.codelab.translate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.mlkit.codelab.translate.main.MainAdapter
import com.google.mlkit.codelab.translate.main.MainFragment
import com.google.mlkit.codelab.translate.main.MainViewModel
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_activity.view.*
import kotlinx.android.synthetic.main.nav_header.view.*

class MainActivity : AppCompatActivity() {
//https://www.youtube.com/watch?v=do4vb0MdLFY

    /*
    <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity" />
    */
    //private lateinit var recyclerView: RecyclerView
    //private var adapter : RecyclerView.Adapter<MainAdapter.ViewHolder>? = null
    lateinit var toggle: ActionBarDrawerToggle
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        toggle = ActionBarDrawerToggle(this, drawerActivity, R.string.open, R.string.close)
        drawerActivity.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(viewModel))
                .commitNow()
        }
      /*  recyclerView = naveView.inflateHeaderView(R.layout.nav_header).myrecyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(viewModel)
        recyclerView.adapter = adapter
        recyclerView.adapter!!.notifyDataSetChanged()*/
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){

            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
