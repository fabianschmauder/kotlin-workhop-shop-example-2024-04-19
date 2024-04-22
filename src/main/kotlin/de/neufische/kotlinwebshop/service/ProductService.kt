package de.neufische.kotlinwebshop.service

import de.neufische.kotlinwebshop.data.Product
import org.springframework.stereotype.Service

interface StuffWithName {
    val name: String
}

@Service
class ProductService {

    val products = mutableListOf(
        Product(1, "Apple", "FRUIT"),
        Product(2, "Banana", "FRUIT"),
        Product(3, "Orange", "FRUIT"),
        Product(4, "Table", "NON_FOOD"),
    )

    fun listProducts(q: String? = null,
                     limit: Int? = 10,
                     type:String? = null): List<Product> {
        return products.filterMatchedType(type)
//            .filterMatchedName(q) TODO  toLower  -> start with
            .toList()
    }

    fun getProductById(id: Int): Product? {
        return products.find { product -> product.id == id }
    }

    fun addProduct(name: String): Product {
        val newProduct = Product(products.size + 1, name, "NON_FOOD")
        products += newProduct
        return newProduct
    }
}
fun List<Product>.filterMatchedType(type:String?): List<Product> {
    type ?: return this
    return this.filter { it.type == type }
}
