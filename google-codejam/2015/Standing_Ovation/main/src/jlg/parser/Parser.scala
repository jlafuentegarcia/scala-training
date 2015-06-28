package jlg.parser

import jlg.problem.TestCase
import collection.breakOut
import java.io.InputStream


/**
 * @author jlafuente
 */
object Parser {
  def parseTests(file: String) : List[TestCase] = {
    val fileLines = io.Source.fromFile(file).getLines().drop(1)
    
    (for ( line <- fileLines ) yield parseTest(getNumber(line), getAudience(line))).toList
  }
  
  def getNumber (line : String ) : Int = {
    line.split(' ')(0).toInt
  } 
  
  def getAudience (line : String ) : String = {
    line.split(' ')(1)
  } 
  
  def parseTest(nPeople: Int, audience : String) : TestCase = {
    new TestCase((for ( (s, n) <- (0 to nPeople) zip audience ) yield (s, n.asDigit)) (breakOut))
  }
}