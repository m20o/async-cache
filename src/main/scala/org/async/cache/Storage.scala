package org.async.cache

trait Storage[A,B] {

  def load(element: A): Option[B]

  def store(element: A, value: B)

  def has(element:A): Boolean

}
