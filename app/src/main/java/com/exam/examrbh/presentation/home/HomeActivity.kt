package com.exam.examrbh.presentation.home

import android.app.Activity
import android.content.Intent
import com.exam.examrbh.R
import com.exam.examrbh.data.base.BaseActivity
import com.exam.examrbh.databinding.ActivityHomeBinding
import com.exam.examrbh.presentation.doing.DoingFragment
import com.exam.examrbh.presentation.todo.TodoFragment
import com.exam.examrbh.presentation.home.adapter.PagerHistoryAdapter
import com.exam.examrbh.data.enumclass.EnumRouteType
import com.exam.examrbh.presentation.done.DoneFragment
import com.google.android.material.tabs.TabLayout

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(){
    override val layId: Int = R.layout.activity_home
    override val classTypeVM: Class<HomeViewModel> = HomeViewModel::class.java

    override fun init() {
        val adapter = PagerHistoryAdapter(supportFragmentManager)
        adapter.addFrag(TodoFragment(), EnumRouteType.TODO.name)
        adapter.addFrag(DoingFragment(), EnumRouteType.DOING.name)
        adapter.addFrag(DoneFragment(), EnumRouteType.DONE.name)
        binding.viewPagerHomeFragment.offscreenPageLimit = 3
        binding.viewPagerHomeFragment.setPagingEnabled(false)
        binding.viewPagerHomeFragment.adapter = adapter
        binding.tabLayoutHomeFragment.setupWithViewPager(binding.viewPagerHomeFragment)
        binding.viewPagerHomeFragment.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayoutHomeFragment))
    }

    companion object {
        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, HomeActivity::class.java))
        }
    }
}