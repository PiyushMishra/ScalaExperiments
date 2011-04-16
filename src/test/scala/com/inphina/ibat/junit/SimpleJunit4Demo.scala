package com.inphina.ibat.junit

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import  org.junit.Before


class SimpleJunit4Demo extends AssertionsForJUnit {

  var sb: StringBuilder = _

  @Before def initialize() {
    sb = new StringBuilder("ScalaTest is ")
  }

  @Test
  def verifyEasy() {
    sb.append("easy!")
    assertEquals("ScalaTest is easy!", sb.toString)
  }

}