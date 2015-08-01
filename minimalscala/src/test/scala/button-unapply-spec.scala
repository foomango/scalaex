// code-examples/AdvOOP/objects/button-unapply-spec.scala

package objects
import org.scalatest._

class ButtonUnapplySpec extends FlatSpec with Matchers {
  "Button.unapply" should 
    "match a Button object" in {
      val b = new Button("click me")
      b match {
        case Button(label) => label should equal("click me")
        case _ => fail()
      }
    }
    it should "match a RadioButton object" in {
      val b = new RadioButton(false, "click me")
      b match {
        case Button(label) => label should equal("click me")
        case _ => fail()
      }
    }
    it should "not match a non-Button object" in {
      val tf = new TextField("hello world!")
      tf match {
        case Button(label) => fail()
        case x => x should not be(null) // hack to make Specs not ignore this test.
      }
    }
    it should "extract the Button's label" in {
      val b = new Button("click me")
      b match {
        case Button(label) => label should equal("click me")
        case _ => fail()
      }
    }
    it should "extract the RadioButton's label" in {
      val rb = new RadioButton(false, "click me, too")
      rb match {
        case Button(label) => label should equal("click me, too")
        case _ => fail()
      }
    }
}
