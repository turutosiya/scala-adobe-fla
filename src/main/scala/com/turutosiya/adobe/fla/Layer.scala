package com.turutosiya.adobe.fla

import scala.xml.Node

/**
 * Layer
 */
case class Layer(
  //
  frames: List[Frame]
){
}

/**
 * Layer companion object
 */
object Layer {

  /**
   * apply
   *
   * @param layerDomNode
   * @return
   */
  def apply(layerDomNode: Node): Layer =
    Layer(
      frames = ((layerDomNode \ "frames").head \ "DOMFrame").map(Frame(_)).toList)
}