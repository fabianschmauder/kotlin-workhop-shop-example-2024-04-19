package de.neufische.kotlinwebshop.controller

import de.neufische.kotlinwebshop.data.Product
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController {

    @GetMapping
    fun listProducts():List<Product>{
        return listOf(
            Product("Apple"),
            Product("Banana"),
            Product("Orange")
        )
    }
}
