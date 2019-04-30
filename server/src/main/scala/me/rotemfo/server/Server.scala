package me.rotemfo.server

import akka.actor.{ActorSystem, Props}

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

/**
  * project: akka-remoting-example
  * package: me.rotemfo.server
  * file:    Server
  * created: 2019-04-30
  * author:  rotem
  */
object Server extends App {
  val system = ActorSystem("AkkaRemoteServer")
  system.actorOf(Props(classOf[CalculatorActor]), "CalculatorActor")

  implicit val ex: ExecutionContext = system.dispatcher

  system.scheduler.scheduleOnce(10.seconds, new Runnable {
    override def run(): Unit = system.terminate()
  })
}
