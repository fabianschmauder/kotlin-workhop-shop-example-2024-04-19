package de.neufische.kotlinwebshop.service

import de.neufische.kotlinwebshop.data.Product
import de.neufische.kotlinwebshop.data.ProductType
import de.neufische.kotlinwebshop.repo.CategoriesRepository
import de.neufische.kotlinwebshop.repo.ProductRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository, private val categoriesRepository: CategoriesRepository){

    suspend fun listProducts(q: String? = null,
                     limit: Int? = 10,
                     type:ProductType? = null): List<Product> {
        // TODO add filtering
        return productRepository.findAll()
    }

    suspend fun getProductById(id: Int): Product? {
        return productRepository.findById(id).orElseGet { null }
    }

    suspend fun addProduct(name: String): Product {
        return productRepository.save(Product(
            name = name))
    }


    fun listProductsFormDb(): List<Product> {
        return productRepository.findAll()
    }


    fun mapProductsAndCategories() = runBlocking{
        val products = async { productRepository.findAll() }
        val categories = async { categoriesRepository.findAll() }


        categories.await().map { category ->
            category.id
        }

        products.await().map { product ->

        }
    }


}
