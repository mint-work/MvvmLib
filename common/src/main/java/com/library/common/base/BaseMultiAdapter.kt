package com.library.common.base

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.library.common.view.baseviewholder.CommonViewHolder

/**
 * 多类型ListAdapter
 *
 * @author yangbw
 * @date 2020/8/31
 */
@Suppress("LeakingThis")
abstract class BaseMultiAdapter<T : MultiItemEntity>(data: MutableList<T>) :
    BaseMultiItemQuickAdapter<T, CommonViewHolder>(data) {

    init {
        addItemType()
    }

    abstract fun addItemType()

    open fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

}