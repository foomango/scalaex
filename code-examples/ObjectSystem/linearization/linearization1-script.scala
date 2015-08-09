// code-examples/ObjectSystem/linearization/linearization1-script.scala 
class C1 {
  def m = List("C1")
}

trait T1 extends C1 {
  override def m = {println("In T1: "); "T1" :: super.m }
}

trait T2 extends C1 {
  override def m = { println("In T2: "); "T2" :: super.m }
}

trait T3 extends C1 {
  override def m = { println("In T3; "); "T3" :: super.m } 
} 

class C2 extends T1 with T2 with T3 {
  override def m = { println("In C2: "); "C2" :: super.m }
}

val c2 = new C2
println(c2.m)
