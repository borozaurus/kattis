object Problem {
  def execute(args: Iterator[String]) = {
    args.drop(1).map(line=>{
      val numbers = line.split(" ").map(_.toLong)
      val r = numbers.count(_ < 0)
      r toString
    }).toSeq
  }
}