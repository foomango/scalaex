// code-examples/Traits/ui2/vetoable-clicks.scala

package ui2
import observer._

trait VetoableClicks extends Clickable {
  println("VetoableClicks is created.")
  val maxAllowed = 1  // default
  private var count = 0

  abstract override def click() = {
    println("VetoableClicks is clicked.")
    if (count < maxAllowed) {
      count += 1
      super.click()
    }
  }
}
