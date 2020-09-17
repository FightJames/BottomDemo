package com.example.bottomact

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_DRAGGING
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import kotlinx.android.synthetic.main.activity_bill.*

class BillActivity : AppCompatActivity() {

    val adapterD = DemoAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)
        val lM = LinearLayoutManager(this@BillActivity)

        (reLi as RecyclerView).apply {
            adapter = adapterD
            layoutManager = lM
        }
        ((bottomViewN.layoutParams as? CoordinatorLayout.LayoutParams)?.behavior as? BottomSheetBehavior)
            ?.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                var state: Int = STATE_COLLAPSED
                var lastYValue: Float = 0f
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    Log.d("James ", "bottomSheet y = ${bottomSheet.y} lastYValue = $lastYValue")
                    if (state == STATE_COLLAPSED) {
                        if (lastYValue == 0f) {
                            lastYValue = bottomSheet.y
                        } else {
                            reLi.scrollBy(0, (lastYValue - bottomSheet.y).toInt())
                            lastYValue = bottomSheet.y
                        }
                    }
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    Log.d("James ", "newState = $newState")
                    if (newState == STATE_COLLAPSED) {
                        state = STATE_COLLAPSED
                        lastYValue = 0f
                    } else if (newState == STATE_EXPANDED) {
                        state = STATE_EXPANDED
                    }

                }
            })
    }

}