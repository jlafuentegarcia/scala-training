package solver

import collection.breakOut

/**
 * @author jlafuente
 */
object Solver {
  
  def computeBestFrom(conf : Configuration) : Configuration = {
    val reachableConfs : List[(Int, Configuration)] = 
      (for { i <- 1 to (conf.height / 2)
      } yield  conf.cutBy(i))(breakOut)
      
    def best(currBest : (Int, Configuration), confs: List[(Int, Configuration)]) : (Int, Configuration) = {
      confs match {
        case Nil => currBest
        case (distance, conf) :: tail =>
          val (bestDistance, bestConf) = currBest;
          
          val newBest = if ( (bestDistance + bestConf.height) <= (distance + conf.height) ) currBest else (distance, conf);
          
          best(newBest, tail)
      }
    }
    
    best((0, conf), reachableConfs)._2
  }
  
  def solve(initConf : Configuration) : (Int, List[Configuration]) = {
    def solveFrom(path : List[Configuration]) : List[Configuration] = { 
      val lastConf = path.head
      
      val nextConf = computeBestFrom(lastConf)
      
      if ( lastConf == nextConf )
        path
      else 
        solveFrom(nextConf :: path)
    }
    
    val path = solveFrom(initConf :: Nil)
    
    def computeTransitTime(path : List[Configuration], cumulTransit : Int) : Int = {
      path match {
        case x :: Nil => cumulTransit
        case x :: y :: xs =>
          val transit = x.width - y.width 
          computeTransitTime(y :: xs, cumulTransit + transit)
      }
    }
    
    val cost = path.head.height + computeTransitTime(path, 0)
    
    (cost, path)
  }
}