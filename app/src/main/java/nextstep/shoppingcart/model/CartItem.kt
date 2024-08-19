package nextstep.shoppingcart.model

internal data class CartItem(
    val id: String,
    val name: String,
    val price: Int,
    val imageUrl: String?,
)
