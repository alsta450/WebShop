//Trait Warenkorb, that defines Actions, that can be taken in the online shop, implemented in Database
trait Warenkorb {
  def delete(id: Int): Array[StoreItem]
  def search(name: String): Array[StoreItem]
  def store(item: StoreItem): Array[StoreItem]
  def sumUp(): Int
}
