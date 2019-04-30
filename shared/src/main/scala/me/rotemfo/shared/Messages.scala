package me.rotemfo.shared

/**
  * project: akka-remoting-example
  * package: me.rotem.fo.shared
  * file:    Messages
  * created: 2019-04-30
  * author:  rotem
  */
object Messages {
  case class Sum(first: Int, second: Int)
  case class Result(result: Int)
}
