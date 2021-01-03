//The Database, that implements Warenkorb
class Database() extends Warenkorb {
  //List of the stored Items
  private var storedItems  = Array[StoreItem]()
//Deletes an Item from the List with stored items and returns the list without the item
  //Item is deleted by id
  override def delete(artnumber: Int): Array[StoreItem] = {
    //help stores the index where the deleted item is
    var help = 0
    //if the item was not found error stays true
    var error = true
    //look for the item, if found error is false and help is the index of the item
    //pretty much only needed because of the logger, the item does not even get deleted here
    for(i <- storedItems.indices){
      if(storedItems(i).id == artnumber) {
        error = false
        help = i
      }
    }
    //if the item was not found we print that the item was not found and return the list
    if(error){
      println("Id " + artnumber + " nicht gefunden")
      return storedItems
    }
    //we only get to this part, when the item was found
    //we use the logger to print, that the item was deleted
    storedItems(help).logAction("gelöscht",storedItems(help).name)
    //the item gets deleted, by filtering for every item, but the one we want to delete
    storedItems = storedItems.filter(! _.id.equals(artnumber))
    //return the list without the item
    storedItems
  }

  //Search for item(s) by name
  override def search(name: String): Array[StoreItem] = {
    var ret = Array[StoreItem]()
    var error = true
    //for every item in the list with Item.name == name, print that the item was found, with the help of logger
    //Set error to false, because the item was found
    for(p <- storedItems){
      if(p.name == name) {
        error = false
        ret = ret :+ p
        p.logAction("gefunden",p.name)
      }

    }
    //If the item was not found (error = true) print that it was not found
    if(error) println(name + " nicht gefunden")
    ret
  }

  //used to add another item to the list of items
  override def store(item: StoreItem): Array[StoreItem] = {
    //add item
    storedItems = storedItems :+ item
    //prints that the item was saved to the list, with the help of logger
    item.logAction( "gespeichert",item.name)
    storedItems
  }

  //sums the value of all items in the list up
  override def sumUp(): Int = {
    var  help = 0

    for(value_help <- storedItems){
      help += value_help.value
    }
    help
  }

}
