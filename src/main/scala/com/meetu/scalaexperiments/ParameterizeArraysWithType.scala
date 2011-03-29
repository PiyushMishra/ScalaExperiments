/*
 * A Scala Program showing Parameterized Arrays
 */

package com.meetu.scalaexperiments

object ParameterizeArraysWithType {

  def main(args: Array[String]) {
    /**
     * When you define a variable with val, the variable can’t be reassigned, 
     * but the object to which it refers could potentially still be changed.
     */
    val greetString = new Array[String](4)

    /**
     * Scala has fewer special cases than java. Arrays are simply instances of
     * classes. When we apply parentheses surrounding one or more values to a
     * variable, Scala will transform the code into an invocation of a method
     * named apply on that variable. Therefore greetString(0) gets converted to
     * greetString.apply(0)
     */
    greetString(0) = "Hello"
    greetString(1) = ", "
    greetString(2) = "world"

    /**
     * so much so that we can define apply function for that object and this may
     * provide a neat solution
     */

    /**
     * When a function accepts only one argument we can call it without a .dot
     * and paranthesis. "to" is actually a method which takes an Int argument
     * "0 to 2" is actually (0).to(2)
     */
    for(i <- 0 to 2) {
      print(greetString(i))
    }

    println("");

    /**
     * greetString(0) = "Hello" gets trandformed to
     * greetString.update(0, "Hello")
     */
    greetString.update(3, "!")

    for(i <- 0 to 3) {
      print(greetString apply i)
    }

  }
}