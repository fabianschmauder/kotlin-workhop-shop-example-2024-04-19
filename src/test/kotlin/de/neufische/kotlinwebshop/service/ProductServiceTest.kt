package de.neufische.kotlinwebshop.service

import com.ninjasquad.springmockk.MockkBean
import de.neufische.kotlinwebshop.data.Product
import de.neufische.kotlinwebshop.data.ProductType
import de.neufische.kotlinwebshop.repo.ProductRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import java.util.*

@SpringBootTest
class ProductServiceTest {

    @MockkBean
    lateinit var productRepo: ProductRepository

    @Autowired
    lateinit var productService: ProductService

    @Test
    fun getProductByIdShouldReturnProductWithCorrespondingId() = runTest {

        every { productRepo.findById(2) } returns Optional.of(Product(2, "Banana", 1, ProductType.FRUIT))

        // WHEN
        val result = productService.getProductById(2)
        // THEN
        assertEquals(Product(2, "Banana", 1, ProductType.FRUIT), result)
    }


    @Test
    fun listAllProducts() = runTest {
        every { productRepo.findAll() } returns listOf(
            Product(1, "Apple", 1, ProductType.FRUIT),
            Product(2, "Banana", 1, ProductType.FRUIT),
            Product(3, "Orange", 1, ProductType.FRUIT),
            Product(4, "Table", 1, ProductType.NON_FOOD)
        )
        // WHEN
        val result = productService.listProducts()
        // THEN
        assertThat(
            result, containsInAnyOrder(
                Product(1, "Apple", 1, ProductType.FRUIT),
                Product(2, "Banana", 1, ProductType.FRUIT),
                Product(3, "Orange", 1, ProductType.FRUIT),
                Product(4, "Table", 1, ProductType.NON_FOOD)
            )
        )
    }


}
