package de.neufische.kotlinwebshop.data

import jakarta.persistence.*


@Entity
@Table(name = "product")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val name:String? = null,
    val type: ProductType = ProductType.NON_FOOD)



enum class ProductType {
    FRUIT, NON_FOOD
}
