package com.niushencheng.lombok

import lombok.Data

import scala.beans.BeanProperty

class LombokDemo {
    @BeanProperty
    var i: Int = _
}

object LombokDemo {
    def main(args: Array[String]): Unit = {
        val demo = new LombokDemo()
        demo.getI()
    }
}
