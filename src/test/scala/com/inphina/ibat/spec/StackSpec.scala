package com.inphina.ibat.spec

import org.scalatest.Spec
import scala.collection.mutable.Stack

/**
 * Created by IntelliJ IDEA.
 * User: meetu
 * Date: 16/4/11
 * Time: 1:38 AM
 * To change this template use File | Settings | File Templates.
 */



class StackSpec extends Spec {

  describe("A Stack") {

    it("should pop values in last-in-first-out order") {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)
      assert(stack.pop() === 2)
      assert(stack.pop() === 1)
    }

    it("should throw NoSuchElementException if an empty stack is popped") {
      val emptyStack = new Stack[String]
      intercept[NoSuchElementException] {
        emptyStack.pop()
      }
    }
  }
}