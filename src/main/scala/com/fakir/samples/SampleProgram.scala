package com.fakir.samples

import java.io._

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.tika.metadata._
import org.apache.tika.parser._
import org.apache.tika.parser.pdf._
object SampleProgram {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val sparkSession = SparkSession.builder().master("local").getOrCreate()

    import java.io.FileInputStream

    import org.apache.tika.sax.BodyContentHandler
    val stringWriter = new StringWriter()
    val handler = new BodyContentHandler(stringWriter)
    val metadata = new Metadata()
    val inputstream = new FileInputStream(new File("pdf1.pdf"))
    val pcontext = new ParseContext()

    //parsing the document using PDF parser
    val pdfparser = new PDFParser()
    pdfparser.parse(inputstream, handler, metadata, pcontext)

    //getting the content of the document
    println("Contents of the PDF :" + handler.toString)

    //getting metadata of the document
    println("Metadata of the PDF:")
    val metadataNames = metadata.names

    for (name <- metadataNames) {
      println(name + " : " + metadata.get(name))
    }
    
  }
}

