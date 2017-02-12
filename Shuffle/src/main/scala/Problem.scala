import scala.collection.mutable

object Problem {

  def execute(args: Iterator[String]) = {
    args.drop(1).map(line => {
      val groups = new mutable.HashSet[Int]()

      line.split(" ").map(_.toInt).foreach(elem=>{
        if (groups.contains(elem - 1)){
          groups.remove(elem - 1)
        }
        groups.add(elem)
      })
      val size = groups.size

      Math.ceil(Math.log(size)/Math.log(2)).toInt.toString

    }).toSeq
  }
}