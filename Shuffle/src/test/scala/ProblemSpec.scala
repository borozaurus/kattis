/**
  * Created by Wojciech on 18/1/2017.
  */
import java.io.InputStream

import org.scalatest._

class ProblemSpec extends FlatSpec with Matchers {
  "Sample data from page " should "generate correct" in {
    (1 to 3).foreach(p=>{
      val streamIn : InputStream = getClass.getResourceAsStream(s"/$p.in")
      val testData = scala.io.Source.fromInputStream( streamIn).getLines

      val streamOut : InputStream = getClass.getResourceAsStream(s"/$p.out")
      val expectedResult = scala.io.Source.fromInputStream(streamOut).getLines.toSeq

      info(s"Processing $p")
      val result = Problem execute testData

      assert(expectedResult.zip(result).forall(a=>{
        a._1 == a._2
      }
      ))

    })
  }

}