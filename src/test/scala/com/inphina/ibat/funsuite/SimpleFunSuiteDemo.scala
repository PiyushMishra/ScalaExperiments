package com.inphina.ibat.funsuite

import org.scalatest.FunSuite

/**
 * For writing Functional Tests use FunSuite Fun => Functional Suite. "test" is a method defined in FunSuite Trait.
 * Test name goes in parentheses and the test code goes in curly braces. One benefit of using FunSuite compared to
 * Suite is that we need not name the test with testXXXX style names.
 *
 * The test code in curly braces is passed as a by-name parameter to "test" method which registers for later execution
 *
 * More benefits we can easily give long names in tests instead of camel case notation generally used.
 *
 * A FunSuite's life-cycle has two phases: the registration phase and the ready phase. It starts in registration phase
 * and enters ready phase the first time run is called on it. It then remains in ready phase for the remainder of its
 * lifetime.
 */

class SimpleFunSuiteDemo extends FunSuite {

  test("addition") {
    val sum = 1 + 1
    assert(sum === 2)
  }

  test("subtraction") {
    val diff = 5 - 2
    assert(diff === 3)
  }

}