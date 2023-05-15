package woowacourse.shopping.feature.main

import com.example.domain.Product
import com.example.domain.RecentProduct
import woowacourse.shopping.feature.list.item.ListItem
import woowacourse.shopping.feature.model.ProductState

interface MainContract {

    interface View {
        fun setProducts(products: List<Product>, recentProducts: List<RecentProduct>)
        fun addProducts(products: List<Product>)
        fun showProductDetail(productState: ProductState)
        fun showEmptyProducts()
    }

    interface Presenter {
        fun loadMoreProducts()
        fun showProductDetail(listItem: ListItem)
    }
}
