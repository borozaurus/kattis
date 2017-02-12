/**
  * Created by Wojciech on 18/1/2017.
  */
import java.io.InputStream

import org.scalatest._

class ProblemSpec extends FlatSpec with Matchers {
  "Sample data from page 1" should "generate correct" in {
    val streamIn : InputStream = getClass.getResourceAsStream("/1.in")
    val testData = scala.io.Source.fromInputStream( streamIn).getLines

    val streamOut : InputStream = getClass.getResourceAsStream("/1.out")
    val expectedResult = scala.io.Source.fromInputStream(streamOut).getLines.toSeq

    val result = Problem execute testData

    assert(expectedResult.zip(result).forall(a=>{
      a._1 == a._2
      }
    ))
  }
}
