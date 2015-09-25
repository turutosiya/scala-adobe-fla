package com.turutosiya.adobe.fla

import scala.xml.Node

/**
 * Timeline
 */
case class Timeline(
  //
  layers: List[Layer]
){
}

/**
 * Timeline companion object
 */
object Timeline {

  /**
   * apply
   *
   * @param timelineDomNode
   * @return
   */
  def apply(timelineDomNode: Node): Timeline =
    Timeline(
      layers = ((timelineDomNode \ "layers").head \ "DOMLayer").map(Layer(_)).toList)
}