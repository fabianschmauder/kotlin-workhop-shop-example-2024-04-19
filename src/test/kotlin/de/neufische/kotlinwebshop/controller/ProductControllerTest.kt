package de.neufische.kotlinwebshop.controller

import de.neufische.kotlinwebshop.data.Product
import de.neufische.kotlinwebshop.service.ProductService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [ProductController::class])
class ProductControllerTest{

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var productService: ProductService

    @Test
    fun listProductsShouldReturnAllProducts(){

        Mockito.`when`(productService.listProducts(null))
            .thenReturn(listOf(
                Product(1, "Apple"),
                Product(2, "Banana"),
            ))

        mockMvc.perform(get("/product"))
            .andExpect(status().isOk)
            .andExpect(content().json("""[{"id": 1, "name": "Apple" },{"id": 2, "name": "Banana" }]"""))
    }
    @Test
    fun listProductsShouldReturnFilteredProducts(){

        Mockito.`when`(productService.listProducts("a"))
            .thenReturn(listOf(
                Product(1, "Apple"),
            ))

        mockMvc.perform(get("/product?q=a"))
            .andExpect(status().isOk)
            .andExpect(content().json("""[{"id": 1, "name": "Apple" }]"""))
    }
    @Test
    fun addProductShouldCreateANewProduct(){

        Mockito.`when`(productService.addProduct("Ice Cream"))
            .thenReturn(
                Product(7, "Ice Cream"),
            )

        mockMvc.perform(post("/product")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""{"name": "Ice Cream" }"""))
            .andExpect(status().isOk)
            .andExpect(content().json("""{"id": 7, "name": "Ice Cream" }"""))
    }
}
