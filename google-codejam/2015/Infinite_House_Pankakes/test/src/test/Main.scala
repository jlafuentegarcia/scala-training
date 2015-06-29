package test

import parser.Parser
import solver.Solver


/**
 * @author jlafuente
 */
object Main {
  def main(args: Array[String]) {
    val tests = Parser.parse("C:/Projects/Training/scala-training/google-codejam/2015/Infinite_House_Pankakes/test/resources/" + args(0))
    
    for ( (id, test) <- (1 to tests.size) zip tests ) {
      val sol = Solver.solve(test)
      
      println("Case #" + id + ": " + sol)
    }
  }
}