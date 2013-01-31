package org.async

package object cache {

  type Fetch[T] = (() => Option[T])

  type Store[T] = (Option[T]) => Unit

}
