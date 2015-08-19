package com.turutosiya.adobe.fla

import com.turutosiya.adobe.Fla
import scala.xml.Node

/**
 * LibraryItem
 */
case class LibraryItem(
  fla: Fla,
  name: String,               // "linkCP",
  itemID: String,             // "55cc6cc1-000001c9",
  linkageExportForAS: String, // "true",
  linkageBaseClass: String,   // "dtcontent.page.PageLinkClickPoint",
  linkageClassName: String,   // "lcp",
  lastModified: String) {     // "1439460545") {

}

/**
 * LibraryItem companion object
 */
object LibraryItem {

  /**
   * apply
   *
   * @param node
   * @return
   */
  def apply(fla: Fla, node: Node): LibraryItem =
    LibraryItem(
      fla = fla,
      name = (node \ "@name").text,
      itemID = (node \ "@itemID").text,
      linkageExportForAS = (node \ "@linkageExportForAS").text,
      linkageBaseClass = (node \ "@linkageBaseClass").text,
      linkageClassName = (node \ "@linkageClassName").text,
      lastModified = (node \ "@lastModified").text)

}