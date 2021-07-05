import org.apache.spark.sql.functions.{broadcast, col}
import org.apache.spark.sql.{DataFrame, SparkSession}

object Part1{
  def main(args: Array[String]): Unit = {
    import ReadWriteUtils._

    implicit val spark = SparkSession
      .builder()
      .appName("HW3-part1")
      .getOrCreate()

    val taxiFactsDF: DataFrame = readParquet("/data/yellow_taxi_jan_25_2018")
    val taxiZoneDF: DataFrame = readCSV("/data/taxi_zones.csv")

    val result: DataFrame = getMostPopularBoroughs(taxiFactsDF, taxiZoneDF).repartition(1)
    result.show()
    writeToFile(result, "parquet", "hdfs://localhost:9000/mostPopularBoroughs")
  }

  def getMostPopularBoroughs(taxiFactsDF: DataFrame, taxiZoneDF: DataFrame): DataFrame = {
    taxiFactsDF
      .join(broadcast(taxiZoneDF), col("DOLocationID") === col("LocationID"), "left")
      .groupBy(col("Borough"))
      .count()
      .orderBy(col("count").desc)
  }
}
