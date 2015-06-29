package solver

/**
 * @author jlafuente
 */
object Solver {
  def solve(dishes: List[Int]) : Int = {
    val flattenDishes = flatten(dishes)
    
    val nFlatten = flattenDishes.size - dishes.size
    
    nFlatten + max(0, flattenDishes) 
  }
  
  def flatten(dishes: List[Int]) : List[Int] = {
    if ( dishes == Nil )
      Nil
    else if ( dishes.head <= 3 )
      dishes.head :: flatten(dishes.tail)
    else
      2 :: flatten ((dishes.head - 2) :: dishes.tail)
  }
  
  def max(prevMax: Int, dishes: List[Int]) : Int = {
    if ( dishes == Nil )
      prevMax
    else if ( dishes.head > prevMax )
      max(dishes.head, dishes.tail)
    else 
      max(prevMax, dishes.tail)
  }
}