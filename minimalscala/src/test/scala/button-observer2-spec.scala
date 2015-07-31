// code-examples/AdvOOP/observer/button-observer2-spec.scala

package ui
import org.scalatest._
import observer._

class ButtonObserver2Spec extends FlatSpec with Matchers {
  "An Observer watching a SubjectForReceiveUpdateObservers button" should 
    "observe button clicks" in {
      val observableButton = 
        new Button("Button1") with SubjectForReceiveUpdateObservers {
        override def click() = { 
          super.click()
          notifyObservers
        }
      }
      val buttonObserver = new ButtonCountObserver
      observableButton.addObserver(buttonObserver)
      for (i <- 1 to 3) observableButton.click()
      buttonObserver.count should equal(3)
    }
  
  "An Observer watching a SubjectForFunctionalObservers button" should 
    "observe button clicks" in {
      val observableButton = 
        new Button("Button2") with SubjectForFunctionalObservers {
        override def click() = { 
          super.click()
          notifyObservers
        }
      }
      var count = 0
      observableButton.addObserver((button) => count += 1)
      for (i <- 1 to 3) observableButton.click()
      count should equal(3)
    }
}
