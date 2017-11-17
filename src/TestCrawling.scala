/**
  * Created by Etudes on 17/11/2017.
  */

import scala.xml.XML
import scala.util.matching
import scala.Predef


object TestCrawling extends App{

  import scala.io.Source
  val html = Source.fromURL("http://paizo.com/pathfinderRPG/prd/bestiary2/achaierai.html#achaierai-")

  val s = html.mkString
  var n = s.replaceAll("<meta charset = \"utf-8\">", "<meta charset = \"utf-8\"/>");
  n = n.replaceAll("<meta name = \"viewport\" content = \"width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0\">" , "<meta name = \"viewport\" content = \"width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0\"/>");
  n = n.replaceAll("<img src = \"/pathfinderRPG/prd/include/menu.png\">","<img src = \"/pathfinderRPG/prd/include/menu.png\"/>")
  println(n)

  val xmlString = n

  val xml = XML.loadString(xmlString)

  val temp = (xml \\ "meta" \\ "div" \ "div" \ "p") text

  println(temp)
  /*// convert the String to a scala.xml.Elem

  // handle the xml as desired ...
  val titleNodes = (xml \\ "item" \ "title")
  val headlines = for {
    t <- titleNodes
  } yield t.text
  headlines.foreach(println)*/


}
