// code-examples/AdvOOP/objects/radio-button-unapply-spec.scala

package objects
import org.scalatest._

class RadioButtonUnapplySpec extends FlatSpec with Matchers {
  "RadioButton.unapply" should 
    "should match a RadioButton object" in {
      val b = new RadioButton(true, "click me")
      b match {
        case RadioButton(on, label) => label should equal("click me")
        case _ => fail()
      }
    }
    it should "not match a Button (parent class) object" in {
      val b = new Button("click me")
      b match {
        case RadioButton(on, label) => fail()
        case x => x should not be(null)
      }
    }
    it should "not match a non-RadioButton object" in {
      val tf = new TextField("hello world!")
      tf match {
        case RadioButton(on, label) => fail()
        case x => x should not be(null)
      }
    }
    it should "extract the RadioButton's on/off state and label" in {
      val b = new RadioButton(true, "click me")
      b match {
        case RadioButton(on, label) => {
          label should equal("click me")
          on    should equal( true)
        }
        case _ => fail()
      }
    }
}
