package com.example.lab4_test

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs
import kotlin.math.max

private const val MIN_SCALE = 0.85f
private const val MIN_ALPHA = 0.5f

//Изменение фрагментов
class ZoomOutPageTransformer: ViewPager.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        val pageWidth: Int = view.width
        val pageHeight: Int = view.height

        when {
            position < -1 -> { // [-Infinity,-1)
                // Открытие слева
                view.alpha = 0f
            }
            position <= 1 -> { // [-1,1]
                // Изменения дефолтных слайдов
                val scaleFactor: Float = max(MIN_SCALE, 1 - abs(position))
                val vertMargin: Float = pageHeight * (1 - scaleFactor) / 2
                val horzMargin: Float = pageWidth * (1 - scaleFactor) / 2
                if (position < 0) {
                    view.translationX = horzMargin - vertMargin / 2
                } else {
                    view.translationX = -horzMargin + vertMargin / 2
                }

                // Использование шкалы
                view.scaleX = scaleFactor
                view.scaleY = scaleFactor

                view.alpha = MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA)
            }
            else -> { // (1,+Infinity]
                // Открытие справа
                view.alpha = 0f
            }
        }
    }
}