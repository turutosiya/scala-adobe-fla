package com.turutosiya.adobe.fla

import java.nio.file.Files

import com.turutosiya.adobe.Fla

/**
 * Library
 */
case class Library(
  //
  items: List[Item]
) {
}

/**
 * Library companion object
 */
object Library {

  /**
   * apply
   *
   * @param documentDomNode
   * @return
   */
  def apply(documentDomNode: scala.xml.Node, fla: Fla): Library =
    Library(
      items = (documentDomNode \ "media").map(media =>
        (media \ "DOMBitmapItem").map(DOMBitmapItem =>
          BitmapItem(DOMBitmapItem).asInstanceOf[Item]))
        .flatten.toList ++
        (documentDomNode \ "symbols").map(symbols =>
          (symbols \ "Include").map(include =>
            SymbolItem(
              scala.xml.XML.load(
                Files.newInputStream(
                  fla.base.resolve(s"LIBRARY/${(include \@ "href")}.xml")))).asInstanceOf[Item]))
          .flatten.toList)
}