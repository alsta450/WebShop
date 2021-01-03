//Implements the trait Artikel and Logger
class StoreItem(artnumber: Int, artname: String, artvalue: Int) extends Logger with Artikel {

  override def logAction(actionName: String, name: String): Unit = {
    println( name + " " + actionName )
  }

  override var id: Int = artnumber
  override var name: String = artname
  override var value: Int = artvalue
}
