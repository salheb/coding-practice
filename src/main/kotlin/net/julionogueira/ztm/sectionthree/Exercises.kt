package net.julionogueira.ztm.sectionthree

import io.smallrye.mutiny.uni
import kotlin.time.measureTime

class Exercises {
    enum class findMethod{
        SEQUENTIAL
    }
    fun findNemo(list: List<String>): String{
        var foundNemo = "Never found nemo =/ ."
        for (item in list){
            if (item == "nemo") foundNemo = "Found nemo!"
        }
        return foundNemo
    }

    fun findInt(listOfInts: List<Int>, method: findMethod): String{
        when (method) {
            findMethod.SEQUENTIAL -> {return findIntSequential(listOfInts)}
        }
    }

    // Sequential read means O(n) / Linear Time
    private fun findIntSequential(listOfInt: List<Int>): String{
        val fixedNumber = 550

        var found = false;
        val timeTaken = measureTime {

            for (item in listOfInt) {
                if (item == fixedNumber) found = true
            }
        }
        println("Valor encontrado ? R: $found")

        val resultJson = "{" +
                "Tempo de execução da função: $timeTaken," +
                "Valor encontrado: $found" +
                "}"
        return resultJson;
    }

    // It doesn't matter the number of items or inputs
    // this function will run always 2 operations
    // which means that we have a Constant Time - O(1)
    fun arraySize(listOfInts: List<Int>): String {
        println("${listOfInts.size}")
        listOfInts.size.let { return it.toString() }
    }
}