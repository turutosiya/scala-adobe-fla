package com.turutosiya.adobe

import java.io.{BufferedInputStream, File, FileInputStream, FileOutputStream}
import java.nio.file.{Files, Path}
import java.util.zip.{ZipEntry, ZipInputStream}

import com.turutosiya.adobe.fla.LibraryItem

/**
 * Fla
 *
 * .fla's HEADER is invalid as ZIP then we can not use ZipfileSystem & ZipFile
 */
case class Fla(
  base: Path) {

  /**
   * DOMDocument
   *
   * @return
   */
  def DOMDocument: scala.xml.Node =
    scala.xml.XML.load(
      Files.newInputStream(
        base.resolve("DOMDocument.xml")))

  /**
   * DOMSymbolInstances
   *
   * @return
   */
  def symbols: List[com.turutosiya.adobe.fla.Symbol] =
    (DOMDocument \\ "DOMSymbolInstance")
      .map(com.turutosiya.adobe.fla.Symbol.apply(this, _))
      .toList

  /**
   * libraryItems
   *
   * @return
   */
  def libraryItems: List[LibraryItem] =
    symbols.map(_.libraryItem)

  /**
   * libraryItem
   *
   * @param name
   * @return
   */
  def libraryItem(name: String): LibraryItem =
    LibraryItem.apply(
      this,
      scala.xml.XML.load(
        Files.newInputStream(
          base.resolve(s"LIBRARY/${name}.xml"))))

}

/**
 *
 */
object Fla {

  /**
   *
   * @return
   */
  def apply(fla: File): Fla = {
    // create temporary directory
    val base = Files.createTempDirectory("pyramid")
    // buffer
    val buffer = new Array[Byte](2048)
    // get zip input stream
    val zip = new ZipInputStream(new BufferedInputStream(new FileInputStream(fla)))
    // loop each entry
    var entry: ZipEntry = zip.getNextEntry()
    while (entry != null) {
      // outpute file
      val file = new File(base.toFile.getAbsolutePath + File.separator + entry.getName())
      if(entry.isDirectory) {
        file.mkdirs()
      } else {
        // create parent folders
        val parent = new File(file.getParent())
        if (!parent.exists()) parent.mkdirs()
        // write file
        val output = new FileOutputStream(file)
        var len: Int = zip.read(buffer)
        while (len > 0) {
          output.write(buffer, 0, len)
          len = zip.read(buffer)
        }
        // cose
        output.close()
      }
      // move next
      entry = zip.getNextEntry()
    }
    zip.closeEntry()
    zip.close()
    //
    Fla(base)
  }
}