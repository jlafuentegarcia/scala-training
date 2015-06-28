package jlg.problem

import jlg.parser.Parser

/**
 * @author jlafuente
 */
object Main {
  def main(args: Array[String]) {
    val tests = Parser.parseTests("C:/Projects/Training/scala-training/google-codejam/2015/Standing_Ovation/test/resources/" + args(0))
    
    for ( (id, test) <- (1 to tests.size) zip tests ) {
      val sol = Solver.solve(test)
      
      println("Case #" + id + ": " + sol)
    }
  }
}