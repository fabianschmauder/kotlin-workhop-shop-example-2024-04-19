package de.neufische.kotlinwebshop.data

import de.neufische.kotlinwebshop.service.StuffWithName

data class Product(
    val id: Int,
    override val name:String,
    val type: String): StuffWithName

data class Category(
    val id: Int,
    override val name:String,
    val someOtherInfo: String): StuffWithName

