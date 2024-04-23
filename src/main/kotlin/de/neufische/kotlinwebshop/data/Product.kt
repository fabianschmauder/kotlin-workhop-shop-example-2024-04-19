package de.neufische.kotlinwebshop.data

import jakarta.persistence.*


@Entity
@Table(name = "product")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val name:String? = null,
    val categoryId: Int? = null,
    val type: ProductType = ProductType.NON_FOOD

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false
        if (name != other.name) return false
        if (categoryId != other.categoryId) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (categoryId ?: 0)
        result = 31 * result + type.hashCode()
        return result
    }
}


enum class ProductType {
    FRUIT, NON_FOOD
}
