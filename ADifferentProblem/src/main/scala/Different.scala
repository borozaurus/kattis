object Different {
  def execute(args: Iterator[String]) = {
    args.map(line=>{
      val Array(a, b) = line.split(" ").map(_.toLong)
      val r = scala.math.abs(a - b)
      r toString
    }).toSeq
  }
}