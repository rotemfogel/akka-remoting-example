package me.rotemfo.client

import akka.actor.{Actor, ActorLogging}
import akka.event.LoggingReceive
import me.rotemfo.shared.Messages

/**
  * project: akka-remoting-example
  * package: me.rotemfo.client
  * file:    ClientActor
  * created: 2019-04-30
  * author:  rotem
  */
class ClientActor extends Actor with ActorLogging {
  private val selection = context.actorSelection("akka.tcp://AkkaRemoteServer@127.0.0.1:2552/user/CalculatorActor")

  override def preStart(): Unit = {
    val first = 2
    val second = first
    log.info("{} sending {}+{}", self.path.name, first, second)
    selection ! Messages.Sum(first, second)
  }

  override def receive: Receive = LoggingReceive {
    case Messages.Result(result) => log.info("received result {} from {}", result, sender.path.name)
  }
}
