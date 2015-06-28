package jlg.problem

/**
 * @author jlafuente
 */
object Solver {
  def solve(test : TestCase ) : Int = {
    solve(0, 0, test.audience)
  }
  
  def solve(addedClappers: Int, prevClappers: Int, audience : List[(Int, Int)]) : Int = {
    if ( audience == Nil )
      addedClappers
    else {
      val (sightnes, number) = audience.head
      
      if ( prevClappers < sightnes ) {
        val newAdded = sightnes-prevClappers
        
        solve(addedClappers + newAdded, prevClappers + number + newAdded, audience.tail)   
      } else {
        solve(addedClappers, prevClappers + number, audience.tail)   
      }
    }
  }
}

