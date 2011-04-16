package com.inphina.ibat.funsuite

import org.scalatest.FunSuite

/**
 * A test fixture is objects or other artifacts (such as files, sockets, database connections, etc.) used by tests
 * to do their work.
 *
 * This is a very simple contrived example
 */

class SimpleSharedFixture extends FunSuite {

  val shared = 7

  test("addition") {
    val sum = 4 + 3
    assert(shared === sum)
  }

  test("subtractiion") {
    val diff = 12 -5
    assert(shared === diff)
  }

}