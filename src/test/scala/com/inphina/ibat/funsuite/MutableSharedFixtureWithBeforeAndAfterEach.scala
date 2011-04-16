package com.inphina.ibat.funsuite

import org.scalatest.{BeforeAndAfterEach, FunSuite}
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfterEach
import java.io.FileReader
import java.io.FileWriter
import java.io.File

/**
 * Created by IntelliJ IDEA.
 * User: meetu
 * Date: 16/4/11
 * Time: 1:17 AM
 * To change this template use File | Settings | File Templates.
 */

class MutableSharedFixtureWithBeforeAndAfterEach extends FunSuite with BeforeAndAfterEach {

  private val FileName = "TempFile.txt"
  private var reader: FileReader = _

  // Set up the temp file needed by the test
  override def beforeEach() {
    val writer = new FileWriter(FileName)
    try {
      writer.write("Hello, test!")
    }
    finally {
      writer.close()
    }

    // Create the reader needed by the test
    reader = new FileReader(FileName)
  }

  // Close and delete the temp file
  override def afterEach() {
    reader.close()
    val file = new File(FileName)
    file.delete()
  }

  test("reading from the temp file") {
    var builder = new StringBuilder
    var c = reader.read()
    while (c != -1) {
      builder.append(c.toChar)
      c = reader.read()
    }
    assert(builder.toString === "Hello, test!")
  }

  test("first char of the temp file") {
    assert(reader.read() === 'H')
  }

  test("without a fixture") {
    assert(1 + 1 === 2)
  }
}