package com.inphina.ibat.suite

import org.scalatest.Suite

/**
 * Sometimes you need to test whether a method throws an expected exception under certain circumstances, such as when
 * invalid arguments are passed to the method. You can do this in the JUnit style
 */

class InterceptedSuiteDemo extends Suite {

  def testInterceptCharAt() {
    val s = "hello"
    val caught = intercept[IndexOutOfBoundsException] {
      s.charAt(-1)
    }
    assert(caught.getMessage === "String index out of range: -1")
  }

}