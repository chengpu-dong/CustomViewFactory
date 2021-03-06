package com.panda.customviewfactory.home.view.adapter

import com.panda.customviewfactory.home.model.MainItemModel
import com.panda.customviewfactory.home.view.viewbinder.MainItemViewBinder
import me.drakeet.multitype.MultiTypeAdapter

/**
 * @ClassName MainAdapter
 * @Description TODO
 * @Author dongchengpu
 * @Date 2021/1/29 下午6:02
 * @Version 1.0
 */
class MainAdapter : MultiTypeAdapter {
    constructor(callback: ItemClickCallback) {
        addViewBinder(callback)
    }

    interface ItemClickCallback {
        fun onItemClicked(item : MainItemModel)
    }

    private fun addViewBinder(callback: ItemClickCallback) {
        val viewBinder = MainItemViewBinder(callback)
        this.register(MainItemModel::class.java, viewBinder)
    }
}