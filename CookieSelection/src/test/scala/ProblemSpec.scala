/**
  * Created by Wojciech on 18/1/2017.
  */
import java.io.InputStream

import org.scalatest._

class ProblemSpec extends FlatSpec with Matchers {
  "Sample data from page 1" should "generate correct" in {
    (1 to 4).foreach(p=>{
      info(s"set $p")
      val streamIn : InputStream = getClass.getResourceAsStream(s"/$p.in")
      val testData = scala.io.Source.fromInputStream( streamIn).getLines

      val streamOut : InputStream = getClass.getResourceAsStream(s"/$p.out")
      val expectedResult = scala.io.Source.fromInputStream(streamOut).getLines.toSeq

      val result = Problem execute testData

      assert(expectedResult.zip(result).forall(a=>{
        val (exp, cal) = a
        info(s"$exp $cal")
        exp == cal
        }
      ))
    })
  }
}