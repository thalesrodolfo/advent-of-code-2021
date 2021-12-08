package day1

import scala.annotation.tailrec
import scala.io.Source

object Day1 extends App {

  val inputs:List[Int] = 
    Source
      .fromResource("./Day1.in")
      .getLines
      .toList
      .map(n => n.toInt)

  def getHead(l: List[Int]): Int = if (l.size > 0) l.head else 0

  @tailrec
  def execute(inputs: List[Int], result: List[Boolean]): List[Boolean] = {
    if (inputs.size == 0) return result

    val newList = inputs.drop(1)
    val valueIncreased = getHead(inputs) < getHead(newList)

    execute(newList, valueIncreased :: result)
  }

  val result = execute(inputs, List()).filter(p => p).size

  println("Resultado: " + result)
}
