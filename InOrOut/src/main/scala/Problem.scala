object Problem {
  class Complex(val a: Double, val b: Double){
    // represents the complex number a + b*i
    def +(that: Complex) = new Complex(this.a+that.a,this.b+that.b)
    def *(that: Complex) = new Complex(this.a*that.a-this.b*that.b,this.a*that.b+that.a*this.b)
    def abs() = Math.sqrt(this.a*this.a + this.b*this.b)
  }


  def execute(args: Iterator[String]) = {
    var counter = 0;
    args.map(line=>{
      counter = counter +1
      val Array(x, y, n) = line.split(" ").map(_.toDouble)

      var z = new Complex(0,0)
      val c = new Complex(x,y)
      for(i <- 0 until n.toInt)
        z = z*z + c

      if (z.abs < 2)
        s"Case $counter: IN"
      else
        s"Case $counter: OUT"
    }).toSeq
  }
}