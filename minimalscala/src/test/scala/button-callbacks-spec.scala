// code-examples/Traits/ui/button-callbacks-spec.scala
package ui
import org.scalatest._ 

class ButtonWithCallbacksSpec extends FlatSpec with Matchers { 
  "A ButtonWithCallbacks" should 
    "be constructable with just a label" in { 
      val button = new ButtonWithCallbacks("button1")
      button.label should equal("button1")
      button.clickedCallbacks.isEmpty should equal(true)
    } 

    it should "be constructable with a label and one click callback" in {
      var message = ""
      val button = new ButtonWithCallbacks(
              "button1", () => message = "clicked!")
      button.clickedCallbacks.length should equal(1)
      button.click
      message should equal("clicked!")
    } 
    it should "be constructable with a label and a list of click callbacks" in {
      var message = ""
      val button = new ButtonWithCallbacks("button1", 
          List(() => message  = "clicked!", 
               () => message += " clicked again!"))
      button.clickedCallbacks.length should equal(2)
      button.click
      message should equal("clicked! clicked again!")
    } 
    it should "not be constructable with a null callback list" in { 
      val nullList:List[() => Unit] = null
      val errorMessage = 
        "requirement failed: Callback list can't be null!"

      the [IllegalArgumentException] thrownBy {
        new ButtonWithCallbacks("button1", nullList)
      } should have message errorMessage
    } 
} 
