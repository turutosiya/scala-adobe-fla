package com.turutosiya.adobe.fla

import com.turutosiya.adobe.Fla
import scala.xml.Node

/**
 * Symbol class
 */
case class Symbol(
  fla: Fla,
  libraryItemName: String, // "linkCP"
  name: String,            // "lcp001"
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
 * Symbol companion object
 */
object Symbol {

  /**
   * apply
   *
   * @param fla
   * @param node
   * @return
   */
  def apply(fla: Fla, node: Node): Symbol =
    Symbol(
      fla = fla,
      libraryItemName = (node \ "@libraryItemName").text,
      name = (node \ "@name").text,
      selected = (node \ "@selected").text)

}