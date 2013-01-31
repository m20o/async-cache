package org.async.cache

import scala.concurrent._

trait AsyncCache[A, B] {

  type Data = Option[B]

  def get(key: A): Future[Data]

  def exists(key: A): Future[Boolean]
}


trait MutableAsyncCache[A, B] extends AsyncCache[A, B] {

  def put(key:A)(value: B): Future[Unit]

}

