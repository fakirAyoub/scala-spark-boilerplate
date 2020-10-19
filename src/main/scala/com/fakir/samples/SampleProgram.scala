package com.fakir.samples

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession



object SampleProgram {

  def majuscule(s: String, filtre: String): String = {
    if(s.contains(filtre)) s
    else s.toUpperCase
  }


  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)

    val sparkSession = SparkSession.builder().master("local").getOrCreate()


    val rdd = sparkSession.sparkContext.textFile("data")
    val majRDD = rdd.map(elem => majuscule(elem, "Juventus"))
    val barcaRDD = majRDD.filter(elem => !elem.contains("Juventus"))
    barcaRDD.foreach(println)
  }
}