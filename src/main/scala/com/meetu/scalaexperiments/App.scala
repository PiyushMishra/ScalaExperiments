package com.meetu.scalaexperiments

/**
 * @author ${Meetu Maltiar}
 */
object App {
  
  def main(args : Array[String]) {
    // just calling a function without type inference
    var resultWithoutTypeInference :Int = max(3,4);
    println( "Maximum of two numbers with type inference is: " + resultWithoutTypeInference)
    
    // well this is an example of type inference
    var resultWithTypeInference = max(2,3);
    println( "Maximum of two numbers with type inference is: " + resultWithTypeInference)
  }

  def max(x:Int, y:Int): Int = {
    if(x > y) x
    else y
  }
}