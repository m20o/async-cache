package org.async.cache

import org.scalatest.FunSuite

import scala.concurrent._
import ExecutionContext.Implicits._
import scala.util.Try

class MapBasedCacheSuite extends FunSuite {

  val cache: MapBasedCache[String, String] = new MapBasedCache[String, String] {
    val map = Map("John" -> "Doe", "Jane" -> "Doe")
  }

  test("Should check for esistence of Jane") {
    cache.exists("Jane").onComplete { b =>
      assert(b == Try(true))
    }
  }

  test("Should get surname of John") {
    cache.get("John").onComplete { b =>
      assert (b.get === Some("Doe"))
    }
  }
}
