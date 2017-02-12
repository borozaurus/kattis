/**
  * Created by Wojciech on 18/1/2017.
  */
object Entry {
  def main(args: Array[String]): Unit = {
    Problem.execute(scala.io.Source.stdin.getLines()).foreach(Console.out.println)
  }
}
