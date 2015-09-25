package com.turutosiya.adobe.fla

import scala.xml.Node

/**
 * SymbolInstance class
 */
case class SymbolInstance(
  libraryItemName: String, // name of the library item of this instance
  name: String,            // name of this instance
  selected: String         // "true"
) extends Element {


}

/**
 * SymbolInstance companion object
 */
object SymbolInstance {

  /**
   * apply
   *
   * @param symbolInstanceDomNode
   * @return
   */
  def apply(symbolInstanceDomNode: Node): SymbolInstance =
    SymbolInstance(
      libraryItemName = (symbolInstanceDomNode \@ "libraryItemName"),
      name = (symbolInstanceDomNode \@ "name"),
      selected = (symbolInstanceDomNode \@ "selected"))

}