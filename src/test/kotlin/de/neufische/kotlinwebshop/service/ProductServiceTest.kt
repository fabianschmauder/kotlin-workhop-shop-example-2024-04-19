package de.neufische.kotlinwebshop.service

import de.neufische.kotlinwebshop.data.Product
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {

    @Autowired
    lateinit var productService : ProductService

    @Test
    fun getProductByIdShouldReturnProductWithCorrespondingId() {

        // WHEN
        val result = productService.getProductById(2)
        // THEN
        assertEquals(Product(2, "Banana"), result)
    }


    @Test
    fun listAllProducts(){

        // WHEN
        val result = productService.listProducts()
        // THEN
        assertThat(result, containsInAnyOrder(
            Product(1, "Apple"),
            Product(2, "Banana"),
            Product(3, "Orange")))
    }


}
