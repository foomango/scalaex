// code-examples/Traits/ui2/button.scala

package ui2

import ui.Widget

class Button(val label: String) extends Widget with Clickable {
  println("Button is created.")
  def click() = {
    // Logic to give the appearance of clicking a button...
    println("Button is clicked.")
  }
}
