import org.apache.spark.rdd.RDD

class RadInputClass {
  private val csv_path : String = "data/country-codes.csv"

  def read_csv(csv_path : String): Unit ={
    println("reading input csv file...")
  }
}
