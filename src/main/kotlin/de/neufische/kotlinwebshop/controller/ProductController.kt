package de.neufische.kotlinwebshop.controller

import de.neufische.kotlinwebshop.data.Product
import de.neufische.kotlinwebshop.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun listProducts():List<Product>{
        return productService.listProducts()
    }

    @GetMapping("{id}")
    fun getProductById(id:Int): Product?{
        TODO("to be implemented")
    }
}
