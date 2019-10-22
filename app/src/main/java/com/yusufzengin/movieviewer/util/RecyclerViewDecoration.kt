package com.yusufzengin.movieviewer.util

import android.graphics.Rect
import android.view.View
import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewDecoration
/**
 * constructor
 *
 * @param margin  desirable margin size in px between the views in the recyclerView
 */
    (@param:IntRange(from = 0) private val margin: Int) :
    RecyclerView.ItemDecoration() {

    /**
     * Set different margins for the items inside the recyclerView: no top margin for the first row
     */
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        val position = parent.getChildLayoutPosition(view)
        outRect.left = margin
        outRect.right = margin
        outRect.top = margin
        val k = parent.adapter?.itemCount ?: 0
        if (position == k - 1) {
            outRect.bottom = margin
        }
        //
    }
}