package nextstep.shoppingcart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.productlist.ProductListScreen
import org.junit.Rule
import org.junit.Test
import java.util.UUID

class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 장바구니화면_타이틀과_아이콘이_보인다() {
        // given
        composeTestRule.setContent {
            ProductListScreen(
                products = emptyList(),
                onProductClick = {},
            )
        }

        // then
        composeTestRule
            .onNodeWithText("상품 목록")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithContentDescription("ShoppingCart")
            .assertIsDisplayed()
    }

    @Test
    fun 장바구니화면_상품목록이_보인다() {
        // given
        val cartItems = List(5) {
            Product(
                id = UUID.randomUUID().toString(),
                name = "PET보틀 - ${it + 1}",
                price = 10000,
                imageUrl = "https://picsum.photos/500"
            )
        }
        composeTestRule.setContent {
            ProductListScreen(
                products = cartItems,
                onProductClick = {},
            )
        }

        // then
        cartItems.forEach { item ->
            composeTestRule
                .onNodeWithText(item.name)
                .assertIsDisplayed()
        }
    }
}
