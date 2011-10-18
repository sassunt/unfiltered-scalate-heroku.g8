package com.example

import unfiltered.request._
import unfiltered.response._
import unfiltered.scalate._
import util.Properties

class App extends unfiltered.filter.Plan {

  def intent = {
    case req => Ok ~> Scalate(req, "index.ssp", ("name", "Scalaist"))
  }
}

object Web {
  def main(args: Array[String]) {
    val port = Properties.envOrElse("PORT", "8080").toInt
    unfiltered.jetty.Http(port).filter(new App).run
  }
}
