package com.example.rxjavalecture.observerpattern.oberserverpattern.customui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatSeekBar
import com.example.rxjavalecture.observerpattern.oberserverpattern.ObserverPatternActivity
import com.example.rxkotlin.oberserverpattern.RxKotlinObserver

class PercentSeekBar : AppCompatSeekBar, RxKotlinObserver<Int> {

    val TAG_OBSERVER_PATTERN : String = "OBSERVER_PATTER"

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var disableEditTextChangeListener = false

    init {
        ObserverPatternActivity.progressSubject.subscribe(this)
        setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (!disableEditTextChangeListener) {
                    Log.d(TAG_OBSERVER_PATTERN, "progress = $progress in SeekBar")
                    ObserverPatternActivity.progressSubject.value = progress
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    override fun notifyDataIsArrived(value: Int?) {
        value?.let {
            Log.d(TAG_OBSERVER_PATTERN, "value = $value in SeekBar")
            disableEditTextChangeListener = true
            progress = it
            disableEditTextChangeListener = false
        }
    }
}