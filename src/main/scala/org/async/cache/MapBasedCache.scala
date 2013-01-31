package org.async.cache

import scala.concurrent._

trait MapBasedCache[A, B] extends AsyncCache[A, B] with ExecutionContextProvider {

  def map: Map[A, B]

  def get(key: A) = future {
    map.get(key)
  }

  def exists(key: A) = future {
    map.isDefinedAt(key)
  }
}
