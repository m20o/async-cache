package org.async.cache

import scala.concurrent._
import collection.concurrent.TrieMap
import collection._

class MapBasedCache[A, B](private var map: mutable.Map[A, B]) extends AsyncCache[A, B] with MutableAsyncCache[A, B] with ExecutionContextProvider {

  def get(key: A) = future {
    map.get(key)
  }

  def exists(key: A) = future {
    map.isDefinedAt(key)
  }

  def put(key: A)(value: B) = future {
    map = map.updated(key, value)
  }
}

sealed class TrieMapBasedCache[A, B] extends MapBasedCache[A, B](map = TrieMap.empty)

object MapBasedCache {
  def apply[A, B]: MapBasedCache[A, B] = new TrieMapBasedCache[A, B]()
}