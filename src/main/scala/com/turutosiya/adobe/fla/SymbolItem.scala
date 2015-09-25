package com.turutosiya.adobe.fla

import scala.xml.Node

/**
 * SymbolItem
 */
case class SymbolItem(
  //
  name: String,               // "linkCP",
  itemID: String,             // "55cc6cc1-000001c9",
  linkageExportForAS: String, // "true",
  linkageBaseClass: String,   // "dtcontent.page.PageLinkClickPoint",
  linkageClassName: String,   // "lcp",
  lastModified: String,
  //
  timeline: Timeline
) extends Item {
}

/**
 * SymbolItem companion object
 */
object SymbolItem {

  /**
   * apply
   *
   * @param symbolItemDomNode
   * @return
   */
  def apply(symbolItemDomNode: Node): SymbolItem =
    SymbolItem(
      //
      name = (symbolItemDomNode \@ "name"),
      itemID = (symbolItemDomNode \@ "itemID"),
      linkageExportForAS = (symbolItemDomNode \@ "linkageExportForAS"),
      linkageBaseClass = (symbolItemDomNode \@ "linkageBaseClass"),
      linkageClassName = (symbolItemDomNode \@ "linkageClassName"),
      lastModified = (symbolItemDomNode \@ "lastModified"),
      //
      timeline = Timeline(((symbolItemDomNode \ "timeline").head \ "DOMTimeline").head))
}