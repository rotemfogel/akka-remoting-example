package me.rotemfo.client

import akka.actor.{ActorSystem, Props}

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

/**
  * project: akka-remoting-example
  * package: me.rotemfo.client
  * file:    Client
  * created: 2019-04-30
  * author:  rotem
  */
object Client extends App {
  val system = ActorSystem("AkkaRemoteClient")
  val client = system.actorOf(Props(classOf[ClientActor]), "client-actor")

  implicit val ex: ExecutionContext = system.dispatcher

  system.scheduler.scheduleOnce(2.seconds, new Runnable {
    override def run(): Unit = system.terminate()
  })
}
