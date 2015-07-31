// code-examples/AdvOOP/objects/widget-apply-spec.scala

package objects
import org.scalatest._

class WidgetApplySpec extends FlatSpec with Matchers {
  "Widget.apply with a valid widget specification string" should 
    "return a widget instance with the correct fields set" in {
      Widget("(button: label=click me, (Widget))") match {
        case Some(w) => w match {
          case b:Button => b.label should equal("click me")
          case x => fail(x.toString())
        }
        case None => fail("None returned.")
      }
      Widget("(textfield: text=This is text, (Widget))") match {
        case Some(w) => w match {
          case tf:TextField => tf.text should equal("This is text")
          case x => fail(x.toString())
        }
        case None => fail("None returned.")
      }
    }
  
  "Widget.apply with an invalid specification string" should 
    "return None" in {
      Widget("(button: , (Widget)") should equal(None)
    }
}
