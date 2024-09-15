package org.example.customDeserializer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class OrderConsumer {
    public static void main(String [] args){
        Properties props = new Properties();
        props.setProperty("bootstrap.servers","localhost:9092");
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer",OrderDeserializer.class.getName());
        props.setProperty("group.id","OrderGroup");
        props.setProperty("auto.commit.offset","false"); // auto commit is problemetic because due to this dupicacy,data processeing can be missed

        KafkaConsumer<String,Order> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("OrderPartionedTopic"));

        try {
            while (true) {
                ConsumerRecords<String,Order> records=consumer.poll(Duration.ofSeconds(20)); // poll give offset of records
                for (ConsumerRecord<String, Order> record : records) {
                    String customerName = record.key();
                    Order order = record.value();
                    System.out.println("Customer Name: " + customerName);
                    System.out.println("product name: " + order.getProduct());
                    System.out.println("product quantity: " + order.getQuantity());
                    System.out.println("Partition: " + record.partition());
                    System.out.println("consumer received  messages successfully");
                }
              //  consumer.commitSync();// it send request to broker for commit and until then blocks the consumer applcn and if commit fails it will retry
                consumer.commitAsync(new OffsetCommitCallback() {
                    @Override
                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets, Exception exception) {
                        if(exception!=null){
                            System.out.println("offset commit failed");
                        }
                    }
                });// it doesnt blocks the consumer applcn instead it send recoed offset for commit and invoke poll for next offset records but if commit fails it doesnt retry
            }
        }finally {
            consumer.close();
        }
    }
}
