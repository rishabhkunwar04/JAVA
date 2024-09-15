package org.example.orderProducer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.example.orderProducer.OrderCallback;

// ctr+alt+o :-> auto import missing library
// sout ctrl+j	System.out.println(“”)
public class OrderProducer {
    public static void main(String[] args) {

        Properties props = new Properties();
//        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        // ctrl+N and search stringserializer and Integerserializer and then copy
        // the package+classname from that module in the 2nd argument of below
        // properties
//        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.setProperty("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");

        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerSerializer");
        props.setProperty(ProducerConfig.ACKS_CONFIG,"all");//it ensures that message sent to all the replicas of partition
        props.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG,"1024");
        props.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG,"gzip");//compress the msg sent by producer in format defined as value
        props.setProperty(ProducerConfig.RETRIES_CONFIG,"2"); //ensures no of retries to send msg,if any failure in first time
        props.setProperty(ProducerConfig.RETRY_BACKOFF_MS_CONFIG,"400");//time in millisecond after reties will be attempted
        props.setProperty(ProducerConfig.BATCH_SIZE_CONFIG,"1024");//allocates the size of each batch in kb as value
        props.setProperty(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,"200");//time in milisecond for which producer wait for broker response
        props.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,"true");//ensures only once msg delivers and saves us from msg lost and msg duplicacy
        //by Default KAFKA uses at least Once message delivery semantic
        // ctr+ alt+v in intellij := give option to import respective library and also to create local
        // variable
        KafkaProducer<String, Integer> producer = new KafkaProducer<String, Integer>(props);
        ProducerRecord<String, Integer> record = new ProducerRecord<String,Integer>("OrderTopic", "first message Delivery", 10);

    //===> 1. Synchronous call()
//        try {
//            RecordMetadata recorddata=producer.send(record).get();
//            System.out.println(recorddata.partition());
//            System.out.println(recorddata.offset());
//            System.out.println("Successfully sent");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            producer.close();
//        }
//
        //===> 2.Asynchronous call()

        try {

            producer.send(record, new OrderCallback());
            System.out.println("Successfully sent");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}