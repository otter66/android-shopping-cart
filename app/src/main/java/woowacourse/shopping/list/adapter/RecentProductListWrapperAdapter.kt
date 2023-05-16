package woowacourse.shopping.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import woowacourse.shopping.databinding.ItemRecentProductListBinding
import woowacourse.shopping.list.ViewType
import woowacourse.shopping.list.viewholder.RecentProductWrapperViewHolder

class RecentProductListWrapperAdapter(
    private val recentProductListAdapter: RecentProductListAdapter,
) : RecyclerView.Adapter<RecentProductWrapperViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentProductWrapperViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecentProductListBinding.inflate(inflater, parent, false)
        return RecentProductWrapperViewHolder(binding, recentProductListAdapter)
    }

    override fun onBindViewHolder(holder: RecentProductWrapperViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 1

    override fun getItemViewType(position: Int): Int = ViewType.RECENT_PRODUCT_LIST.ordinal
}