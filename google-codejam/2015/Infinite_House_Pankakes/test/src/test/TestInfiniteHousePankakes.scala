package test

import parser.Parser
import solver.Solver


/**
 * @author jlafuente
 */
object TestInfiniteHousePankakes {
  def main(args: Array[String]) {
    val tests = Parser.parse("C:/Projects/Training/scala-training/google-codejam/2015/Infinite_House_Pankakes/test/resources/" + args(0))
    val verbose = if (args.size >= 2) args(1).equalsIgnoreCase("true") else true
    
    for ( (id, test) <- (1 to tests.size) zip tests ) {
      val (cost, path) = Solver.solve(test)
     
      if ( verbose )
        println("Case #" + id + ": " + path + " ---> " + cost)
      else 
        println("Case #" + id + ": " + cost)
    }
  }
}