package solver

/**
 * @author jlafuente
 */
class Configuration (val dishes : List[Int]) {
  val width = dishes.size;
  val height : Int = {
    def max(currMax : Int, dishes: List[Int]) : Int = {
      if ( dishes == Nil )
        currMax
      else 
        max(Math.max(dishes.head, currMax), dishes.tail)
    }
    
    max(0, dishes)
  }
  
  def cutBy (by : Int) : (Int, Configuration) = {
    val newHeight = height - by
    
    def cutAux(dishes: List[Int]) : List[Int] = {
      if ( dishes == Nil )
        Nil
      else if ( dishes.head <= newHeight )
        dishes.head :: cutAux(dishes.tail)
      else 
        newHeight :: (dishes.head - newHeight) :: cutAux(dishes.tail);
    }
    
    val res      = new Configuration(cutAux(dishes))
    val distance = res.width - width;
    
    (distance, res)
  }
  
  override def toString = {
    dishes.toString
  } 
}