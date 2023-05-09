package woowacourse.shopping.feature.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import woowacourse.shopping.feature.list.item.ListItem

abstract class ItemHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(listItem: ListItem, onClick: (ListItem) -> Unit)
}