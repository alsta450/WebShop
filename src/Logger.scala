//Trait Logger, that prints the taken action
trait Logger {
  def logAction(actionName: String, name: String): Unit
}
