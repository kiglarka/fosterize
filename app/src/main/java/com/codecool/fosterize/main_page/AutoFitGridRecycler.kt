package com.codecool.fosterize.main_page

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_grid_view_screen.view.*
import org.w3c.dom.Attr
import java.lang.Exception

class AutoFitGridRecycler : RecyclerView {
    private lateinit var girdlayoutManager : GridLayoutManager
    private var columnWidth = -1f

    constructor(context: Context) : super(context){
        init(context,null)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context,attributeSet){
        init(context,attributeSet)
    }
    constructor(context: Context,attributeSet: AttributeSet,defStyle : Int) : super(context,attributeSet,defStyle){
        init(context,attributeSet)
    }

    fun init(context: Context,attributeSet: AttributeSet?){
        try {
            if ( attributeSet != null){
                val attributeArray = intArrayOf(android.R.attr.columnWidth)
                val typedArray = context.obtainStyledAttributes(attributeSet,attributeArray)
                columnWidth = typedArray.getDimension(0, -1f)
                typedArray.recycle()
            }

            girdlayoutManager = GridLayoutManager(context,1)
            layoutManager = girdlayoutManager
        } catch ( e : Exception) {
            e.printStackTrace()
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        super.onMeasure(widthSpec, heightSpec)
        girdlayoutManager.spanCount = 2
    }
}