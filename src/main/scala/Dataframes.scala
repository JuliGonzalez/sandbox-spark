import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession



object Dataframes {

    def main(args: Array[String]) {
        Logger.getLogger("org").setLevel(Level.ERROR)
        val spark = SparkSession
          .builder()
          .appName("Spark SQL basic example")
          .master("local[1]")
          .getOrCreate()

        import spark.implicits._


        val df = spark.read.json("data/reduced-tweets.json")
        //println(df.schema)
        //println(df.show())

        val filtered = df.filter($"Country" like "India").show()

        //df.filter($"Country" like "India").groupBy("country").count().show()

        df.createOrReplaceTempView("people")

        val sqlDF = spark.sql("SELECT country FROM people WHERE country = 'India'").show()


    }
}
