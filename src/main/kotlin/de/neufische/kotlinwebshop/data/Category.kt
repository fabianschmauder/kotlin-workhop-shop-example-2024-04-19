package de.neufische.kotlinwebshop.data

import jakarta.persistence.*

@Entity
@Table(name = "category")
class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val name:String? = null
)
