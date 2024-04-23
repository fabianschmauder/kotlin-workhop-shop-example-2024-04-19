package de.neufische.kotlinwebshop.examples

import de.neufische.kotlinwebshop.data.Product
import org.junit.jupiter.api.Test

typealias ProductListMap= List<Map<String, Product>>

class TypeAliasExample {


    @Test
    fun aliasExample(){
        val result : List<Map<String, Product>>? = null
        val result2 : ProductListMap? = null
    }


    fun listSomeData():List<Map<String, Product>>{
        return listOf(
            mapOf("product" to Product(1, "Apple", 1)),
            mapOf("product" to Product(2, "Banana", 1))
        )
    }
    fun listSomeDataWithTypeAlias():ProductListMap {
        return listOf(
            mapOf("product" to Product(1, "Apple", 1)),
            mapOf("product" to Product(2, "Banana", 1))
        )
    }
}
