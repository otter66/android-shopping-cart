package com.example.domain

class Cart(
    products: List<CartProduct> = listOf()
) {
    private var _products: MutableList<CartProduct> = products.toMutableList()

    val products: List<CartProduct>
        get() = _products.toList()

    fun updateAll(cartProducts: List<CartProduct>) {
        _products = cartProducts.toMutableList()
    }

    fun removeByProductId(productId: Int): Boolean = _products.removeIf { it.productId == productId }

    fun removeByIndex(index: Int): CartProduct = _products.removeAt(index)

    fun getCheckedItemCount(): Int = _products.count { it.checked }

    fun getCheckedProductsTotalPrice(): Int = products
        .filter { it.checked }
        .sumOf { it.count * it.productPrice }

    fun updateCheckedByProductId(productId: Int, checked: Boolean) {
        val index = getIndexByProductId(productId)
        _products[index].checked = checked
    }

    fun updateCountByProductId(productId: Int, count: Int) {
        val index = getIndexByProductId(productId)
        _products[index].count = count
    }

    fun isAllChecked(): Boolean = products.count() == products.count { it.checked }

    fun setAllChecked(checked: Boolean) = _products.map { it.checked = checked }

    fun subList(fromIndex: Int, toIndex: Int) = _products.subList(fromIndex, toIndex)

    private fun getIndexByProductId(productId: Int): Int = _products.indexOfFirst { it.productId == productId }
}
