package parser

import collection.breakOut
import solver.Configuration

/**
 * @author jlafuente
 */
object Parser {
  def parse(fileName : String) : List[Configuration] = {
    val fileLines = io.Source.fromFile(fileName).getLines().drop(1).toList
    
    parseLines(fileLines)
  }
  
  def parseLines(lines : List[String]) : List[Configuration] = {
    if ( lines == Nil )
      Nil
    else {
      val number = lines.head.toInt
      val dishes : List[Int] = (for ( d <- lines.tail.head.split(" ") ) yield d.toInt)(breakOut) 

      (new Configuration(dishes)) :: parseLines(lines.tail.tail)
    }
  } 
}