package com.inphina.ibat.suite

import org.scalatest.Suite

/**
 * Traits approach to writing tests. Simply create classes
 * extending Suite and define test methods.
 *
 * Test methods have names testXXXX. All methods must be public.
 *
 * Scala Test provides === operator. It is defined in Traits Assertions. Allows the failure report
 * to include both right and left values.
 */

class SimpleSuiteDemo extends Suite {

   def testAddition() {
        val sum = 1 + 1
        assert(sum === 2)
   }

  def testSubtraction() {
    val diff = 4 - 1
    assert(diff === 3)
  }
}