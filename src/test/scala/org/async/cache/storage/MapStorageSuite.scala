package org.async.cache.storage

import org.scalatest.FunSuite

class MapStorageSuite extends FunSuite {

  test("basic operations") {
    val storage = new MapStorage[String, String]

    assert(storage.has("John") === false)
    assert(storage.load("John"))

    storage.store("John", "Doe")

    assert(storage.has("John"))
    assert(storage.load("John") === Some("Doe"))
  }

}
