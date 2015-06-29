package dijkstra

/**
 * @author jlafuente
 */
object Solver {
  def solve(str : String) : (Boolean, (Int, Int)) = {
    val cuts = for { i <- 1 until str.length
                     j <- i+1 until str.length
                     val eval1 = Evaluator.evaluate(str.substring(0, i))
                     if ( eval1 == (false, 'i') )
                     val eval2 = Evaluator.evaluate(str.substring(i, j))
                     if ( eval2 == (false, 'j') )
                     val eval3 = Evaluator.evaluate(str.substring(j))
                     if ( eval3 == (false, 'k') )
        } yield (i, j)
        
    if ( !cuts.isEmpty ) 
      (true, cuts(0))
    else 
      (false, (-1, -1))
  }
}