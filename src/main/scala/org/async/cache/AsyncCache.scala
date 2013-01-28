package org.async.cache

import concurrent.Promise


trait AsyncCache[A,B] {


  case class Entry(k: A, v:B)


  def insert(entry: => Entry): Promise[Entry]

}


