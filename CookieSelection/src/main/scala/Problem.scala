import scala.collection.mutable

object Problem {
  val front = mutable.PriorityQueue.empty[Int](implicitly[Ordering[Int]].reverse)
  val back = mutable.PriorityQueue.empty[Int]

  def execute(args: Iterator[String]) = {
    args.map(p => {
      if (p == "#") {
        val ret = front.dequeue
        if (front.size < back.size) {
          front enqueue back.dequeue
        }
        ret.toString
      }
      else {
        val d = p.toInt
        front enqueue d
        if (front.size == back.size + 2) {
          back enqueue front.dequeue
        }
        else {
          if (front.size > back.size && back.size > 0) {
            if (back.head > front.head) {
              back enqueue front.dequeue
              front enqueue back.dequeue
            }
          }
        }
        "#"
      }
    }).filter(_ != "#").toSeq
  }
}