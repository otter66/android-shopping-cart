package woowacourse.shopping.feature.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import woowacourse.shopping.databinding.ItemProductBinding
import woowacourse.shopping.model.CartProductState.Companion.MAX_COUNT_VALUE
import woowacourse.shopping.model.CartProductState.Companion.MIN_COUNT_VALUE
import woowacourse.shopping.model.ProductState

class ProductViewHolder(
    binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root) {
    private val binding = binding as ItemProductBinding

    fun bind(
        productState: ProductState,
        onProductClick: (ProductState) -> Unit,
        cartProductAddFab: (ProductState) -> Unit,
        cartProductCountMinus: (ProductState) -> Unit,
        cartProductCountPlus: (ProductState) -> Unit
    ) {
        binding.product = productState
        binding.root.setOnClickListener { onProductClick(productState) }
        binding.productAddFab.setOnClickListener {
//            cartProductAddFab()
            binding.productAddFab.visibility = View.INVISIBLE
            binding.counterView.visibility = View.VISIBLE
            binding.counterView.count = MIN_COUNT_VALUE
        }
        binding.counterView.minusClickListener = {
            if (binding.counterView.count <= MIN_COUNT_VALUE) {
                binding.productAddFab.visibility = View.VISIBLE
                binding.counterView.visibility = View.INVISIBLE
            } else {
                binding.counterView.count--
//                cartProductCountMinus()
            }
        }
        binding.counterView.plusClickListener = {
            if (MAX_COUNT_VALUE > binding.counterView.count) {
                binding.counterView.count++
//                cartProductCountPlus()
            }
        }
    }

    companion object {
        fun createInstance(parent: ViewGroup): ProductViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemProductBinding.inflate(inflater, parent, false)
            return ProductViewHolder(binding)
        }
    }
}
