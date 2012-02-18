package com.anchormath.logstream

import scala.xml._
object Reader extends App {
  val data = XML.loadFile("C:\\cygwin\\opt\\Solr\\apache-solr-3.5.0\\sears\\remoteLogs\\solr0.log")
  for (entry <- data \\ "record") { Console.println((entry \\ "level").text + ":" + (entry \\ "message").text); }

}
