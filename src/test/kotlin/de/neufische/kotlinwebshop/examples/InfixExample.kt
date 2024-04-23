package de.neufische.kotlinwebshop.examples

import de.neufische.kotlinwebshop.data.Category
import de.neufische.kotlinwebshop.data.Product
import org.junit.jupiter.api.Test


infix fun List<Product>.contain(category: Category): Boolean {
    return this.any{ it.categoryId == category.id }
}



class InfixExample {


    @Test
    fun createInfixNotation(){
        val category = Category(1, "Fruit")
        val products = listOf(Product(1, "Apple", 2), Product(2, "Banana", 1))


        val result = products contain category

        println(result)
    }
}
