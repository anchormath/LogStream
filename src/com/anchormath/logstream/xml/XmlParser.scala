package com.anchormath.logstream.xml

import com.anchormath.logstream.LogParser
import scala.xml._

class XmlParser(rootTag:String, startTag: String, printTags: Array[String]) extends LogParser {

  val currentRecord: StringBuffer = new StringBuffer()

  def parse(line: String): Unit = {
    try{
    if (line.contains("<" + startTag) && currentRecord.length()>0) {
      val data = XML.loadString(currentRecord.toString())
      val printRecord: StringBuffer = new StringBuffer()
      for (entry <- printTags) { printRecord.append((data \\ entry).text + ":") }
      currentRecord.delete(0, currentRecord.length())
      println(printRecord.toString())
    } 
    if (!line.contains("?xml") && !line.contains(rootTag))
    	currentRecord.append(line)
    }catch{
      case ex:Exception => println("Error parsing"+line+"; currentRecord="+currentRecord);throw ex
    }
  }

}