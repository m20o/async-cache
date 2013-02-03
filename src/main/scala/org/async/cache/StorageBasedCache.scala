package org.async.cache

import scala.concurrent._
import collection.concurrent.TrieMap
import collection._

trait StorageBasedCache[A, B] extends AsyncCache[A, B] with MutableAsyncCache[A, B] with ExecutionContextProvider {

  def storage: Storage[A, B]

  def get(key: A) = future {
    storage.load(key)
  }

  def exists(key: A) = future {
    storage.has(key)
  }

  def put(key: A)(value: B) = future {
    storage.store(key, value)
  }

}