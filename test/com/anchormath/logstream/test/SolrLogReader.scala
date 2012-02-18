package com.anchormath.logstream.test

import com.anchormath.logstream.xml.XmlParser
import com.anchormath.logstream._

object SolrLogReader extends App {
  val solrParser = new XmlParser("log", "record", Array("level", "message"))
  TailReader.start("solr0.log", solrParser)

}
