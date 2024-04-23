package de.neufische.kotlinwebshop.repo

import de.neufische.kotlinwebshop.data.Category
import de.neufische.kotlinwebshop.data.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriesRepository: JpaRepository<Category,Int>
