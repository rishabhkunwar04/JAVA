package org.example.orderconsumer;

import org.apache.kafka.clients.consumer.*;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class OrderConsumer {
    public static void main(String [] args){
        Properties props = new Properties();
//        props.setProperty("bootstrap.servers","localhost:9092");
        props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");

        props.setProperty("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer","org.apache.kafka.common.serialization.IntegerDeserializer");
        props.setProperty("group.id","OrderGroup");
        props.setProperty(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG,"300"); //broker waits foe 300 ms and then send messages to consumer
        props.setProperty(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG,"1000");//after this 1000ms interval consumer givec hearbeat signal to group-cordinator
        props.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,"100");//maxm no of record each poll will return
        props.setProperty(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, RangeAssignor.class.getName()); // it is by default, it responsible for partition assignment to consumer,it assigns in concesutive fashion

        KafkaConsumer<String,Integer> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("OrderTopic"));

        ConsumerRecords<String,Integer> orders=consumer.poll(Duration.ofSeconds(20));
        for (ConsumerRecord<String,Integer>order:orders) {
            System.out.println("key is: "+order.key());
            System.out.println("value is: "+order.value());

            System.out.println("consumer received  messages successfully");

        }
    }
}
