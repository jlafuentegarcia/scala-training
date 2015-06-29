package solver

import collection.breakOut

/**
 * @author jlafuente
 */
object Solver {
  
  def computeFrom(conf : Configuration) : List[Configuration] = {
      (for { i <- 1 to (conf.height / 2);
             (distance, newConf) = conf.cutBy(i)
             if ( distance + newConf.height < conf.height )
      } yield  (conf))(breakOut)
  }
  
  def solve(initConf : Configuration) : (Int, List[Configuration]) = {
    def solveFrom(path : List[Configuration]) : List[Configuration] = { 
      val lastConf = path.head
      
      val nextConfs = computeFrom(lastConf)
      
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