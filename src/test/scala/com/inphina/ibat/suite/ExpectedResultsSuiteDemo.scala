package com.inphina.ibat.suite

import org.scalatest.Suite

/**
 * Although === provides readable extension to Scala's assert mechanism. It still does not provide the way to
 * distinguish between the actual and expected values. There is an expect method.
 */

class ExpectedResultsSuiteDemo extends Suite {

  def testAddition() {
    val a = 5
    val b = 4

    expect(9) {
      a - b
    }
  }

}