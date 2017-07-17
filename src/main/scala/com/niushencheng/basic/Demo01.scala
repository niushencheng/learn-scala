package com.niushencheng.basic

import java.util

class Demo01 {
    def func1: PartialFunction[String, Int] = {
        case "one" => 1
        case _ => -1
    }
}

object Demo01 {

    var l: Int = _
    val (first, second, _) = (1, 2, 3)
    val arr = Array(1, 2, 3, 4)

    def sum(i: Int*): Int = {
        var sum = 1
        for (k <- i)
            sum += k
        sum
    }

    def main(args: Array[String]): Unit = {
        println(sum(1 to 10: _*))
        val ints = arr.filter(_ % 2 == 0)
        for (i <- ints) {
            println(i)
        }
    }
}
