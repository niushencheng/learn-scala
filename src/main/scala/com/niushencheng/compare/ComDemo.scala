package com.niushencheng.compare

case class ComDemo(age: Int, name: String) extends Comparable[ComDemo] {
    override def compareTo(o: ComDemo): Int = {
        this.age.compareTo(o.age)
    }
}

object ComDemo {
    def main(args: Array[String]): Unit = {
        val c1:ComDemo = ComDemo(1, "hehe")
        val c2:ComDemo = ComDemo(2, "haha")

        println(c1.compareTo(c2))
    }
}
