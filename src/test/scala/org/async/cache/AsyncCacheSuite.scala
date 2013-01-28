package org.async.cache

import com.sun.org.apache.xpath.internal.functions.FuncStartsWith
import org.scalatest.{FunSuite, FunSpec}
import concurrent.Promise


class DementialCache extends AsyncCache[String, String] {


  def insert(entry: => Entry): Promise[Entry] = ???
}

class AsyncCacheSuite extends FunSuite
{
  test("Should insert a value of compatible type") {

    val cache = new DementialCache

    cache.Entry("hello", "world")

  }
}
