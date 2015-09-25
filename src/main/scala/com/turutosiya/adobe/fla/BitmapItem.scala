package com.turutosiya.adobe.fla

import scala.xml.Node

/**
 * BitmapItem
 */
case class BitmapItem(
  name: String,
  itemID: String
) extends Item {

}

/**
 * BitmapItem companion object
 */
object BitmapItem {

  /**
   * apply
   *
   * @param node
   * @return
   */
  def apply(node: Node): BitmapItem =
    BitmapItem(
      name = (node \ "@name").text,
      itemID = (node \ "@itemID").text)
}