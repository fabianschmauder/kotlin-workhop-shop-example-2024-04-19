package de.neufische.kotlinwebshop.controller

import de.neufische.kotlinwebshop.data.Product
import de.neufische.kotlinwebshop.data.ProductType
import de.neufische.kotlinwebshop.service.ProductService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/product")
class ProductController(private val productService: ProductService) {

    @GetMapping
    suspend fun listProducts(
        @RequestParam(required = false) q: String?

    ): List<Product> {
        return productService.listProducts(q)
    }

    @GetMapping("/fruit")
    suspend fun listFruits(
        @RequestParam(required = false) q: String?
    ): List<Product> {
        return productService.listProducts(
            q = q,
            type = ProductType.FRUIT)
    }


    @GetMapping("{id}")
    suspend fun getProductById(@PathVariable id: Int ): Product {
        return productService.getProductById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "product with id:$id not found")
    }

    @PostMapping
    suspend fun addProduct(@RequestBody productData: AddProductDto): Product {
        productData.validateData()
        return productService.addProduct(productData.name)
    }
}
