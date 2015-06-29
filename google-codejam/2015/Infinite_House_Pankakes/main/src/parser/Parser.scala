package parser

import collection.breakOut

/**
 * @author jlafuente
 */
object Parser {
  def parse(fileName : String) : List[List[Int]] = {
    val fileLines = io.Source.fromFile(fileName).getLines().drop(1).toList
    
    parseLines(fileLines)
  }
  
  def parseLines(lines : List[String]) : List[List[Int]] = {
    if ( lines == Nil )
      Nil
    else {
      val number = lines.head.toInt
      val dishes : List[Int] = (for ( d <- lines.tail.head.split(" ") ) yield d.toInt)(breakOut) 

      dishes :: parseLines(lines.tail.tail)
    }
  } 
}