package org.async.cache

import org.scalatest.FunSuite

import collection.mutable._
import concurrent.ExecutionContext
import ExecutionContext.Implicits._
import scala.util.Try
import storage.MapStorage

class StorageBasedCacheSuite extends FunSuite {

  val cache: StorageBasedCache[String, String] = new StorageBasedCache[String, String] {
     val storage = new MapStorage[String, String](Map("John" -> "Doe", "Jane" -> "Doe"))
  }
  // (Map("John" -> "Doe", "Jane" -> "Doe")) {}

  test("Should check for esistence of Jane") {
    cache.exists("Jane").onComplete {
      b =>
        assert(b == Try(true))
    }
  }

  test("Should get surname of John") {
    cache.get("John").onComplete {
      b =>
        assert(b.get === Some("Doe"))
    }
  }

  test("Should update content with James") {
    val put = cache.put("James")("Jones")
    val check = cache.exists("James")
    val res = for (p <- put; result <- check) yield result

    res.onComplete {
      b =>
        assert(b.get === true)
    }
  }

}


