package me.rotemfo.server

import akka.actor.{Actor, ActorLogging}
import akka.event.LoggingReceive
import me.rotemfo.shared.Messages

/**
  * project: akka-remoting-example
  * package: me.rotemfo.server
  * file:    CalculatorActor
  * created: 2019-04-30
  * author:  rotem
  */
class CalculatorActor extends Actor with ActorLogging {
  override def receive: Receive = LoggingReceive {
    case Messages.Sum(first, second) => {
      log.info("received {}+{} from {}", first, second, sender.path.name)
      sender ! Messages.Result(first + second)
    }
  }
}
