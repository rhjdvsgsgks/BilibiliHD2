package com.duzhaokun123.bilibilihd2.ui.widget

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.res.use
import com.duzhaokun123.bilibilihd2.R

class GlideLoadRationHeightImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : GlideLoadImageView(context, attrs, defStyleAttr) {
    init {
        context.obtainStyledAttributes(attrs, R.styleable.GlideLoadRationHeightImageView, defStyleAttr, 0).use {
            ration = it.getFloat(R.styleable.GlideLoadRationHeightImageView_ration, 0F)
        }
    }

    var ration: Float = 0F
        set(value) {
            if (field != value) {
                field = value
                requestLayout()
            }
        }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (ration > 0) {
            val width = MeasureSpec.getSize(widthMeasureSpec)
            val height = (width * ration).toInt()
            setMeasuredDimension(width, height)
        } else
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}