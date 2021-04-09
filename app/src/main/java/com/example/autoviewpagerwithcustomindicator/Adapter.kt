package com.example.autoviewpagerwithcustomindicator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class Adapter(private val items: ArrayList<String>) : PagerAdapter() {


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // position 값을 받아 주어진 위치에 페이지를 생성한다
        val inflater = LayoutInflater.from(container.context)
        val itemView = inflater.inflate(R.layout.item, container, false)
        val textViewItem : TextView? = itemView.findViewById(R.id.textViewItem)
        textViewItem?.text = items[position]
        container.addView(itemView)
        return itemView
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        // 페이지 뷰가 생성된 페이지의 object key 와 같은지 확인한다
        // 해당 object key 는 instantiateItem 메소드에서 리턴시킨 오브젝트이다
        // 즉, 페이지의 뷰가 생성된 뷰인지 아닌지를 확인하는 것
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView( `object` as View)
    }
}