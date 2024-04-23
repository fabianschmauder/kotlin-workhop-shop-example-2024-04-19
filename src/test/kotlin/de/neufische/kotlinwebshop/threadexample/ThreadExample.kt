package de.neufische.kotlinwebshop.threadexample

import org.junit.jupiter.api.Test

class ThreadExample {


    @Test
    fun threadExample(){

        Thread(){
          kotlin.run {
            println("Thread started")
            Thread.sleep(1000)
            println("Thread finished")
          }
        }.start()


    }
}
