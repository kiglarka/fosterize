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
import kotlin.properties.Delegates

class AutoFitGridRecycler : GridLayoutManager {

    private var columnWidth = -1
    private var columnWidthChanged : Boolean = true

    constructor(context: Context) : super(context, 2){
        setColumnWidth(columnWidth)
    }

    private fun setColumnWidth(width : Int){
        if ( width > 0 && width != columnWidth){
            columnWidth = width
            columnWidthChanged = true
        }
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        if ( columnWidthChanged && columnWidth > 0){
            var totalSpace = 0
            if ( orientation == VERTICAL){
                totalSpace = width - paddingRight - paddingLeft
            } else {
                totalSpace = height - paddingTop - paddingBottom
            }

            val spanCount = Math.max(1, totalSpace/columnWidth)
            setSpanCount(spanCount)
            columnWidthChanged = false
        }

        super.onLayoutChildren(recycler, state)
    }

}