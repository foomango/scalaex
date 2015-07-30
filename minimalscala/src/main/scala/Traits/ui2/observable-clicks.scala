// code-examples/Traits/ui2/observable-clicks.scala

package ui2
import observer._

trait ObservableClicks extends Clickable with Subject {
  abstract override def click() = {
    println("ObservableClicks is clicked.")
    super.click()
    notifyObservers
  }
}
