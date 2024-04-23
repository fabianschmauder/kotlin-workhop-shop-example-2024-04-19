package de.neufische.kotlinwebshop.controller

import de.neufische.kotlinwebshop.repo.CategoriesRepository
import de.neufische.kotlinwebshop.repo.ProductRepository
import de.neufische.kotlinwebshop.service.ProductService
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

// For older spring version
fun ResultActions.asyncDispatch(mockMvc: MockMvc):ResultActions {
    val mvcResult = andReturn()
    mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult))
    return this
}

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc


    @Test
    fun createProductAndList() = runTest {

        // Add product
        mockMvc.perform(
            post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""{"name": "Ice Cream" }""")
        ).asyncDispatch(mockMvc)
            .andExpect(status().isOk)
            .andExpect(content().json("""{"id": 1, "name": "Ice Cream" }"""))

        // Add product
        mockMvc.perform(
            post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""{"name": "Banana" }""")
        ).asyncDispatch(mockMvc)
            .andExpect(status().isOk)
            .andExpect(content().json("""{"id": 2, "name": "Banana" }"""))


        // List products
        mockMvc.perform(get("/product"))
            .asyncDispatch(mockMvc)
            .andExpect(status().isOk)
            .andExpect(content().json("""[{"id": 1, "name": "Ice Cream" },{"id": 2, "name": "Banana" }]"""))

    }


}
