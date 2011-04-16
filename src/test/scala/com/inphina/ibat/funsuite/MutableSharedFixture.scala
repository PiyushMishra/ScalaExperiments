package com.inphina.ibat.funsuite

import org.scalatest.FunSuite
import collection.mutable.ListBuffer

/**
 * shared mutable fixture objects may be changed by tests such that they need to be recreated or reinitialized before
 * each test.JUnit offers methods setUp and tearDown for this purpose.
 */

class MutableSharedFixture extends FunSuite {

  def createFixture = (
    new StringBuilder("ScalaTest is "),
    new ListBuffer[String]
  )

  test("easy") {
    val (builder, lbuf) = createFixture
    builder.append("easy!")
    assert(builder.toString === "ScalaTest is easy!")
    assert(lbuf.isEmpty)
    lbuf += "sweet"
  }

  test("fun") {
    val (builder, lbuf) = createFixture
    builder.append("fun!")
    assert(builder.toString === "ScalaTest is fun!")
    assert(lbuf.isEmpty)
  }
}