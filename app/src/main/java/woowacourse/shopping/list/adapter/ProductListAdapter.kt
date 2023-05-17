package woowacourse.shopping.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import woowacourse.shopping.databinding.ItemProductBinding
import woowacourse.shopping.list.ViewType
import woowacourse.shopping.list.viewholder.ProductViewHolder
import woowacourse.shopping.model.ProductState

class ProductListAdapter(
    private var productStates: List<ProductState> = listOf(),
    private val onItemClick: (ProductState) -> Unit
) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun getItemCount(): Int {
        return productStates.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productStates[position], onItemClick)
    }

    override fun getItemViewType(position: Int): Int = ViewType.PRODUCT.ordinal

    fun addItems(newItems: List<ProductState>) {
        val items = this.productStates.toMutableList()
        items.addAll(newItems)
        this.productStates = items.toList()
        notifyItemRangeInserted(items.size, newItems.size)
    }

    fun setItems(items: List<ProductState>) {
        this.productStates = items.toList()
        notifyDataSetChanged()
    }
}
