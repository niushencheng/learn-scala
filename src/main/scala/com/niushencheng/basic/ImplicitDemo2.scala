package com.niushencheng.basic

import scala.language.implicitConversions

class MissRight[T] {
    def choose(first: T, second: T)(implicit ord: T => Ordered[T]): T = {
        if (first > second) first else second
    }

    def select(first: T, second: T)(implicit ord: Ordering[T]): T = {
        if (ord.gt(first, second)) first else second
    }

    def random(first: T, second: T)(implicit ord: Ordering[T]): T = {
        import Ordered.orderingToOrdered
        //   将Ordering转换成Ordered
        if (first > second) first else second
    }
}

object MissImplicitInfo {
    implicit def girl2Ordered(g: Girl): Ordered[Girl] = new Ordered[Girl] {
        override def compare(that: Girl): Int = {
            g.age - that.age
        }
    }

    //   本方法与下面的两行的写法等效
   /*implicit object girlOrdering extends Ordering[Girl] {
        override def compare(x: Girl, y: Girl): Int = {
            x.age - y.age
        }
    }*/

    trait GirlOrdering extends Ordering[Girl] {
        override def compare(x: Girl, y: Girl): Int = {
            x.age - y.age
        }
    }

    implicit object Girl extends GirlOrdering

}

object MissRight {
    def main(args: Array[String]): Unit = {
        import MissImplicitInfo._
        val g1 = new Girl("g1", 10)
        val g2 = new Girl("g2", 20)
        val c1 = new MissRight[Girl]
        val g = c1.choose(g1, g2)
        println (g.name)
        println("-------------------------------------------------")
        val g3 = new Girl("g3", 30)
        val g4 = new Girl("g4", 40)
        val c2 = new MissRight[Girl]
        val gg = c2.select(g3, g4)
        println (gg.name)
        println("-------------------------------------------------")
        val g5 = new Girl("g5", 50)
        val g6 = new Girl("g6", 60)
        val c3 = new MissRight[Girl]
        val ggg = c2.select(g5, g6)
        println (ggg.name)
    }
}
