// code-examples/Traits/ui2/button-clickable-observer-vetoable-spec.scala

package ui2
import org.scalatest._
import observer._
import ui.ButtonCountObserver

class ButtonClickableObserverVetoableSpec extends FlatSpec with Matchers {
  "A Button Observer with Vetoable Clicks" should 
    "observe only the first button click" in {
      val observableButton = 
          new Button("Okay") with ObservableClicks with VetoableClicks
      val buttonClickCountObserver = new ButtonCountObserver
      observableButton.addObserver(buttonClickCountObserver)

      for (i <- 1 to 3) observableButton.click()
      buttonClickCountObserver.count should equal(1)
    }
}
