package de.neufische.kotlinwebshop.service

import de.neufische.kotlinwebshop.data.Product
import org.springframework.stereotype.Service

@Service
class ProductService {

    val products = listOf(
        Product(1,"Apple"),
        Product(2,"Banana"),
        Product(3,"Orange")
    )

    fun listProducts(): List<Product> {
        return products
    }
}
