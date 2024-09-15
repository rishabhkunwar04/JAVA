package org.example.orderProducer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;


// ctr+shift+o :-> auto import missing library
public class OrderConsumer {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        // ctrl+shift+t and search stringserializer and Integerserializer and then copy
        // the package+classname from that module in the 2nd argument of below
        // properties
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"rishabh");

        // ctr+alt+v := give option to import respective library and also to create local
        // variable
        KafkaConsumer<String,Integer> consumer=new KafkaConsumer<String,Integer>(props);
        consumer.subscribe(Collections.singleton("OrderTopic"));

        while(true) {
            try {
                ConsumerRecords<String, Integer> record = consumer.poll(Duration.ofMillis(10000));
                for (ConsumerRecord<String, Integer> consumerRecord : record) {
                    System.out.println("Key is " + consumerRecord.key());
                    System.out.println("Value is " + consumerRecord.value());
                }
            }catch (Exception e) {
                System.out.println("Error while consuming "+ e);
            }
        }
    }
}