import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger


object KafkaStreaming {
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder()
      .appName("Kafka streaming")
      .master("local[1]")
      .getOrCreate()

    import spark.implicits._

    val df = spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "host1:port1, host2:port2")
      .option("subscribe", "topic1") //subscribed only to 1 topic
      .load()

  }
}
