package woowacourse.shopping.feature.product.recent.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class RecentProductState(
    val productId: Int,
    val productImageUrl: String,
    val productPrice: Int,
    val productName: String
) : Parcelable