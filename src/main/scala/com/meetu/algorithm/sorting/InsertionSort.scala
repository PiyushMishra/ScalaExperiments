package com.meetu.algorithm.sorting

object InsertionSort {

  def sort(numbers: Array[Int]): Array[Int] = {
    var i = 0
    for (j <- 1 until numbers.length) {
      val key = numbers(j)
      i = j - 1

      while (i >= 0 && numbers(i) > key) {
        numbers(i + 1) = numbers(i)
        i = i - 1
      }
      numbers(i + 1) = key
    }
    numbers
  }
}