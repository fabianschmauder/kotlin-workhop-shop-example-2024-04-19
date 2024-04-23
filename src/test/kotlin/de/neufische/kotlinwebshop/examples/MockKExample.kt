package de.neufische.kotlinwebshop.examples

import de.neufische.kotlinwebshop.data.Product
import de.neufische.kotlinwebshop.repo.CategoriesRepository
import de.neufische.kotlinwebshop.repo.ProductRepository
import de.neufische.kotlinwebshop.service.ProductService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Test

class MockKExample {

   val mockProductRepository =  mockk<ProductRepository>()
   val mockCategoryRepository =  mockk<CategoriesRepository>()


    private val service = ProductService(mockProductRepository,mockCategoryRepository)
    @Test
    fun listTest(){

        every { mockProductRepository.findAll() } returns listOf(Product(1, "Apple", 1), Product(2, "Banana", 1))

        val listProductsFormDb = service.listProductsFormDb()

        assertThat(listProductsFormDb, containsInAnyOrder(Product(1, "Apple", 1), Product(2, "Banana", 1)))

        verify { mockProductRepository.findAll() }
    }
}
