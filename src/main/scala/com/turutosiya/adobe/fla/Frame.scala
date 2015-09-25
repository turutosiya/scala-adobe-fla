package com.turutosiya.adobe.fla

import scala.xml.Node

/**
 * Frame
 */
case class Frame(
  //
  elements: List[Element]
){
}

/**
 * Frame companion object
 */
object Frame {

  /**
   * apply
   *
   * @param frameDomNode
   * @return
   */
  def apply(frameDomNode: Node): Frame =
    Frame(
      elements = ((frameDomNode \ "elements").head \ "DOMSymbolInstance").map(SymbolInstance(_)).toList)
}