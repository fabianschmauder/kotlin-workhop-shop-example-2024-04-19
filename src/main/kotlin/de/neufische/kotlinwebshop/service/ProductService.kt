package de.neufische.kotlinwebshop.service

import de.neufische.kotlinwebshop.data.Product
import de.neufische.kotlinwebshop.data.ProductType
import de.neufische.kotlinwebshop.repo.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun listProducts(q: String? = null,
                     limit: Int? = 10,
                     type:ProductType? = null): List<Product> {
        // TODO add filtering
        return productRepository.findAll()
    }

    fun getProductById(id: Int): Product? {
        return productRepository.findById(id).orElseGet { null }
    }

    fun addProduct(name: String): Product {
        return productRepository.save(Product(
            name = name))
    }
}
