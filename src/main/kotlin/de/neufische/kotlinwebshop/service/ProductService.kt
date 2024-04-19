package de.neufische.kotlinwebshop.service

import de.neufische.kotlinwebshop.data.Product
import org.springframework.stereotype.Service

@Service
class ProductService {

    val products = listOf(
        Product(1, "Apple"),
        Product(2, "Banana"),
        Product(3, "Orange")
    )

    fun listProducts(q: String? = null): List<Product> {
        return products
    }

    fun getProductById(id: Int): Product? {
        return products.find { product -> product.id == id }
    }
}
