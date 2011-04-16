package com.inphina.ibat.suite

import org.scalatest.Suite
import org.scalatest.matchers.ShouldMatchers

/**
 * Mixin Traits ShouldMatchers for DSl type assertions
 */

class DSLMatchersSuiteDemo extends Suite with ShouldMatchers {

  def testAddition() {
    val sum = 1 + 1
    sum should equal (2)
    sum + 2 should equal (4)
  }

}