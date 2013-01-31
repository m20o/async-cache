package org.async.cache

import concurrent.ExecutionContext

trait ExecutionContextProvider {

  implicit def context: ExecutionContext = ExecutionContext.Implicits.global

}
