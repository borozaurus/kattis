
object Problem {
  def execute(args: Iterator[String]) = {
    args.takeWhile(_ != "0 0").map(line => {
      val Array(p, q) = line.split(" ").map(_.toLong)

      var r: Long = 0
      (2 to 50000)
        .map(sum => {
          val n: Long = sum.toLong * (sum.toLong - 1) * p
          while (r * (r - 1) * q < n) {
            r = r + 1
          }
          if (r * (r - 1) * q == n) (r.toInt, sum)
          else (0, 0)
        })
        .find(p => p._2 > 0) match {
        case None => "impossible"
        case Some(p) => {
          val (r, sum) = p
          val b = sum.toLong - r
          s"$r $b"
        }
      }
    }).toSeq
  }
}