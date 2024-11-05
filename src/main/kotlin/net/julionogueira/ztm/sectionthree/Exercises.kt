package net.julionogueira.ztm.sectionthree

class Exercises {
    fun findNemo(list: List<String>): String{
        var foundNemo = "Never found nemo =/ ."
        for (item in list){
            if (item == "nemo") foundNemo = "Found nemo!"
        }
        return foundNemo
    }
}