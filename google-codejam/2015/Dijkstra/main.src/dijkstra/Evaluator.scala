package dijkstra

/**
 * @author jlafuente
 */
object Evaluator {
  def evaluate(str : String) : (Boolean, Char) = {
     def eval(expr : List[Char], sign: Boolean, res: Char) : (Boolean, Char) = {
       expr match {
         case Nil => (sign, res)
         case x :: xs => (res, x) match {
           case ('1', '1') => eval (xs, sign,  '1')
           case ('1', 'i') => eval (xs, sign,  'i')
           case ('1', 'j') => eval (xs, sign,  'j')
           case ('1', 'k') => eval (xs, sign,  'k')
           case ('i', '1') => eval (xs, sign,  'i')
           case ('i', 'i') => eval (xs, !sign, '1')
           case ('i', 'j') => eval (xs, sign,  'k')
           case ('i', 'k') => eval (xs, !sign, 'j')
           case ('j', '1') => eval (xs, sign,  'j')
           case ('j', 'i') => eval (xs, !sign, 'k')
           case ('j', 'j') => eval (xs, !sign, '1')
           case ('j', 'k') => eval (xs, sign,  'i')
           case ('k', '1') => eval (xs, sign,  'k')
           case ('k', 'i') => eval (xs, sign,  'j')
           case ('k', 'j') => eval (xs, !sign, 'i')
           case ('k', 'k') => eval (xs, !sign, '1')
         }
       }
     }
     
     eval(str.toList, false, '1')
  }
}