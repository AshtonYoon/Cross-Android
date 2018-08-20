/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.support.android.designlibdemo.Activity;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.support.android.designlibdemo.Adapters.MainPageAdapter;
import com.support.android.designlibdemo.Fragments.ContactFragment;
import com.support.android.designlibdemo.Fragments.TransactionFragment;
import com.support.android.designlibdemo.Fragments.WalletFragment;
import com.support.android.designlibdemo.R;

/**
 * TODO
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        MainPageAdapter mainPageAdapter = new MainPageAdapter(getSupportFragmentManager());
        mainPageAdapter.addFragment(new WalletFragment(), "지갑");
        mainPageAdapter.addFragment(new TransactionFragment(), "트랜잭션");
        mainPageAdapter.addFragment(new ContactFragment(), "주소록");
        viewPager.setAdapter(mainPageAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
