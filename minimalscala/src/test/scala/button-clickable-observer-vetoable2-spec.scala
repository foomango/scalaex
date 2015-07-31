// code-examples/AdvOOP/ui3/button-clickable-observer-vetoable2-spec.scala
package ui3

import org.scalatest._
import observer._
import ui.ButtonCountObserver

class ButtonClickableObserverVetoableSpec2 extends FlatSpec with Matchers {
  "A Button Observer with Vetoable Clicks" should 
    "observe only the first 'maxAllowed' clicks" in {
      val observableButton = 
        new Button("Okay") with ObservableClicks with VetoableClicks {
          maxAllowed = 2
      }
      observableButton.maxAllowed should equal(2)
      val buttonClickCountObserver = new ButtonCountObserver
      observableButton.addObserver(buttonClickCountObserver)
      for (i <- 1 to 3) observableButton.click()
      buttonClickCountObserver.count should equal(2)
    }
}
