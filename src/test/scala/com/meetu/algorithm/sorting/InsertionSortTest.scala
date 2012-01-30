package com.meetu.algorithm.sorting

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class InsertionSortTest extends FunSuite {

  test("Sort on array of numbers should return sorted array") {
    val sortedArray = InsertionSort.sort(Array(2, 6, 3, 5, 8, 1))
    assert(sortedArray.head === 1)
    assert(sortedArray.tail.head === 2)
    assert(sortedArray(sortedArray.length - 1) === 8)
  }

}