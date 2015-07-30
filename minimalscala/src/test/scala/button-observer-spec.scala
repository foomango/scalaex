// code-examples/Traits/ui/button-observer-spec.scala

package ui
import org.scalatest._
import observer._

class ButtonObserverSpec extends FlatSpec with Matchers {
  "A Button Observer" should "observe button clicks" in {
      val observableButton = new ObservableButton("Okay")
      val buttonObserver = new ButtonCountObserver
      observableButton.addObserver(buttonObserver)

      for (i <- 1 to 3) observableButton.click()
      buttonObserver.count should equal (3)
    }
}
