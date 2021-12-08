import scala.annotation.tailrec
object Main extends App {

  val inputs:List[Int] = 
    List (199,
          200,
          208,
          210,
          200,
          207,
          240,
          269,
          260,
          263)

  def getHead(l: List[Int]): Int = if (l.size > 0) l.head else 0
    
  @tailrec
  def execute(inputs: List[Int], result: List[Boolean]): List[Boolean] = {
    if (inputs.size == 0) result

    val newList = inputs.drop(1)
    val valueIncreased = getHead(inputs) < getHead(newList)

    execute(newList, valueIncreased :: result)
  }

  val result = execute(inputs, List()).filter(p => p).size

  println(result)
}