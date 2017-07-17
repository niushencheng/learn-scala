package com.niushencheng.basic

import scala.language.implicitConversions

/**
  * 隐式转换
  */
class Girl(val name: String, val age: Int)

object ImplicitInfo {
    implicit def girl2Ordered(gir: Girl): Ordered[Girl] = new Ordered[Girl] {
        override def compare(that: Girl): Int = {
            gir.age - that.age
        }
    }
}

//
class Chooser1[T <% Ordered[T]] {
    def choose(first: T, second: T): T = {
        if (first > second) first
        else second
    }
}

class Chooser2[T: Ordering] {
    def choose(first: T, second: T): T = {
        // 先拿到一个Ordering的实例
        // Ordered中有一个方法，可以将Ordering转换成Ordered，
        // 所以ImplicitInfo中定义的girl2Orderd方法会起作用
        val ord = implicitly[Ordering[T]]
        if (ord.gt(first, second)) first
        else second
    }
}

object ImplicitDemo {
    def main(args: Array[String]): Unit = {
        import ImplicitInfo.girl2Ordered
        val g1 = new Girl("g1", 10)
        val g2 = new Girl("g2", 20)
        val c1 = new Chooser1[Girl]
        val g = c1.choose(g1, g2)
        println(g.name)
        println("-------------------------------------------------")
        val g3 = new Girl("g3", 30)
        val g4 = new Girl("g4", 40)
        val c2 = new Chooser2[Girl]
        val gg = c2.choose(g3, g4)
        println(gg.name)
    }
}

