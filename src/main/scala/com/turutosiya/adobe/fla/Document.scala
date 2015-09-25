package com.turutosiya.adobe.fla

import java.nio.file.Files

import com.turutosiya.adobe.Fla

/**
 * Document
 */
case class Document(
  //
  library: Library,
  timelines: List[Timeline]
  ) {
}

/**
 * Document companion object
 */
object Document {

  /**
   * apply
   *
   * @param fla
   * @return
   */
  def apply(fla: Fla): Document = {
    val documentDomNode = scala.xml.XML.load(
      Files.newInputStream(
        fla.base.resolve("DOMDocument.xml")))
    Document(
      library =
        Library(documentDomNode, fla),
      timelines =
        ((documentDomNode \ "timelines").head \ "DOMTimeline").map(Timeline(_)).toList)
  }
}