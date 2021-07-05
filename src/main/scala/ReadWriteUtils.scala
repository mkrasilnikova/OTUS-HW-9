import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object ReadWriteUtils {
  def readParquet(path: String)(implicit spark: SparkSession): DataFrame = {
    spark.read.parquet(path)
  }

  def readCSV(path: String)(implicit spark: SparkSession): DataFrame =
    spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(path)

  def writeToFile(df: DataFrame, format: String, path: String)(implicit spark: SparkSession): Unit =
    df.write.format(format).save(path)

  def writeToCsv(df: DataFrame, path: String)(implicit spark: SparkSession): Unit =
    df.write
      .option("sep", " ")
      .option("header", "true")
      .csv(path)

  def writeToPostgres(df: DataFrame)(implicit spark: SparkSession): Unit = {
    df.write
      .format("jdbc")
      .option("driver", "org.postgresql.Driver")
      .option("url", scala.util.Properties.envOrElse("MYAPP_JDBC_URL", ""))
      .option("dbtable", "taxi_trips_info")
      .option("user", "postgres")
      .option("password", "postgres")
      .mode(SaveMode.Append)
      .save()
  }

}