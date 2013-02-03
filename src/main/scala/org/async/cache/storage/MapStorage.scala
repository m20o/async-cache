package org.async.cache.storage

import org.async.cache.Storage
import collection.concurrent.TrieMap
import collection.mutable

class MapStorage[A,B](val storage: mutable.Map[A,B] = TrieMap.empty[A,B]) extends Storage[A,B] {

  def load(element: A) = storage.get(element)

  def store(element: A, value: B) {
    storage.put(element, value)
  }

  def has(element: A) = storage.contains(element)
}
