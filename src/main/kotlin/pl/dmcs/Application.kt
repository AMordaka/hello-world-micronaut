package pl.dmcs

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("pl.dmcs")
                .mainClass(Application.javaClass)
                .start()
    }
}