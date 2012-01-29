package com.meetu.scalaexperiments

object SimplifiedParameterizedArrays extends App {

  /**
   * shorthand for creating an array. A static factory method apply is called
   * which takes a variable number of objects and is defined on Array
   * companion object
   */
  val greetString = Array("Hello", " world", "!")
  for (i <- 0 to 2) {
    print(greetString(i))
  }

  println("")

  /**
   * One of the big idea of functional programming is that methods should not
   * have side effects. A method job is to compute and tyhen return a value
   * without any side effects. This removes interdependency and has less
   * coupling
   */

  /**
   * The problem with this is that even when greetString is val, the object
   * pointed by it can be changed. which in sense makes it mutable apart from
   * fact that you cannot change the length of an array. so, Scala Array is a
   * mutable sequence of objects that all share the same type
   */

  /**
   * For an immutable sequence of objects all having a same type always use a
   * List class.
   */
  val welcomestring = List("Hello", "World", "!");
  for (i <- 0 to 2) {
    print(welcomestring(i));
  }

  val list = List[String]()
}
