package jlg.problem

import jlg.parser.Parser

/**
 * @author jlafuente
 */
object Main {
  def main(args: Array[String]) {
    val tests = Parser.parseTests("C:/Projects/Training/scala-training/google-codejam/2015/Standing_Ovation/test/resources/" + args(0))
    
    var i = 1
    for ( test <- tests ) {
      val sol = Solver.solve(test)
      
      println("Case #" + i + ": " + sol)
      
      i = i + 1
    }
  }
}