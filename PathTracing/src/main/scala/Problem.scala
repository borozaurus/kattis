
object Problem {
  case class Chain(x :Int, y:Int, previous:Option[Chain])

  def visit(map: Array[Array[Char]], minx:Int, miny:Int, a:Chain):Unit = {
    map((a.y - miny) + 1).update((a.x - minx) +1 , '*')
    a.previous match {
      case Some(b) => visit(map,minx,miny,b)
      case None => Unit
    }
  }

  def execute(args: Iterator[String]) = {
    val end = Chain(0,0, None)
    var head = end
    var maxx = 0
    var maxy = 0
    var minx = 0
    var miny = 0
    args.foreach(line=>{
      head = line match {
        case "down"  => Chain(head.x, head.y+1, Option(head))
        case "up"    => Chain(head.x, head.y-1, Option(head))
        case "left"  => Chain(head.x-1, head.y, Option(head))
        case "right" => Chain(head.x+1, head.y, Option(head))
      }
      maxx = Math.max(maxx, head.x)
      maxy = Math.max(maxy, head.y)
      minx = Math.min(minx, head.x)
      miny = Math.min(miny, head.y)
    })

    val map = Array.ofDim[Char]((maxy-miny) + 3, (maxx - minx) + 3)

    for (i <- 0 until map.length){
      map(i).update(0,'#')
      map(i).update(map(i).length-1,'#')
    }
    for (i <- 0 until map(0).length){
      map(0).update(i,'#')
      map(map.length-1).update(i,'#')
    }

    for (i <- 1 until map.length-1;
         j <- 1 until map(i).length-1
       )map(i).update(j,' ')

    visit(map, minx, miny, head)
    map((0 - miny) + 1).update((0 - minx) +1 , 'S')
    map((head.y - miny) + 1).update((head.x - minx) +1 , 'E')

    map.map(String.join("",_)).toSeq
  }
}