package com.turutosiya.adobe.fla

import com.turutosiya.adobe.Fla
import scala.xml.Node

/**
 * SymbolInstance class
 */
case class SymbolInstance(
  fla: Fla,
  libraryItemName: String, // name of the library item of this instance
  name: String,            // name of this instance
  selected: String) {      // "true"

  /**
   * libraryItem
   *
   * @return
   */
  def libraryItem: LibraryItem =
    fla.libraryItem(libraryItemName)
}

/**
 * SymbolInstance companion object
 */
object SymbolInstance {

  /**
   * apply
   *
   * @param fla
   * @param node
   * @return
   */
  def apply(fla: Fla, node: Node): SymbolInstance =
    SymbolInstance(
      fla = fla,
      libraryItemName = (node \ "@libraryItemName").text,
      name = (node \ "@name").text,
      selected = (node \ "@selected").text)

}