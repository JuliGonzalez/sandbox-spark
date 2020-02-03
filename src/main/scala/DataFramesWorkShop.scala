import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf



object DataFramesWorkShop {

  private val csv_path : String = "data/country-codes.csv"

  def main(args: Array[String]): Unit = {
    Logger.getLogger("Logging-Workshop").setLevel(Level.ERROR)

    val spark = SparkSession
      .builder()
      .appName("df-workshop")
      .master("local[1]")
      .getOrCreate()

    val df = spark.read.csv(csv_path)
    val filtered_df = df.columns(1)
    println(filtered_df)

  }

}
