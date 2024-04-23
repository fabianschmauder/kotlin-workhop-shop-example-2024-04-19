package de.neufische.kotlinwebshop.examples

import org.junit.jupiter.api.Test

class MultilineStrings {


    @Test
    fun createMultiLineStrings(){
        val someValue = 10


        val someString = """Hello
            World. Your Value ${someValue +10 }""".trimMargin()



    }
}
