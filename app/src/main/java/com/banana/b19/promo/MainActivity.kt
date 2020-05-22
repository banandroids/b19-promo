package com.banana.b19.promo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager.adapter = Adapter() // присоединяем к ViewPager адаптер
        viewPager.setPageTransformer(true, ZoomTransformer())
        tabLayout.setupWithViewPager(viewPager) // подключаем ViewPager к TabLayout
        circleIndicator.setViewPager(viewPager) // подключаем ViewPager к CircleIndicator
    }

    class ZoomTransformer : ViewPager.PageTransformer {

        override fun transformPage(page: View, position: Float) {
            var scale = 1 - position.absoluteValue
            if (scale < .8f) scale = .8f
            page.scaleX = scale
            page.scaleY = scale
            page.alpha = scale
            page.rotation = 180 * position
        }

    }

    /* адаптер на основе входных данных (число страниц и так далее) создаёт фрагменты */
    inner class Adapter : FragmentPagerAdapter(
        supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

        /* этот метод по номеру страницы возвращает нужный фрагмент */
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> newFragment("Чайный пакетик")
                1 -> newFragment("Хлебушек")
                else -> newFragment("Цифровой банан")
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "A"
                else -> position.toString()
            }
        }

        /* а этот метод возвращает число страниц */
        override fun getCount(): Int = 10

    }

}
