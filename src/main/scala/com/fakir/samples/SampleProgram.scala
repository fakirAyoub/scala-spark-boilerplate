package com.fakir.samples

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.sql.SparkSession
object SampleProgram {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    println("new feature")

    val sparkConf = new SparkConf().setAppName("My First Program in Spark!")
      .setMaster("local[2]")
    val sparkContext = new SparkContext(sparkConf)

    val rddFromList = sparkContext.parallelize(Seq("this", "is", "an", "rdd", "from", "a", "Sequence"))
    rddFromList.map(_.toUpperCase).foreach(println)

    
    //If you want to start working with Spark 2, go through a SparkSession!
    val sparkSession = SparkSession.builder().getOrCreate()
    
    
  }
}

