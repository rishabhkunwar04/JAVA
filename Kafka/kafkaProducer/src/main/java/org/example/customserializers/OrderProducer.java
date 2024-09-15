package org.example.customserializers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.example.partitioners.VIPPartitioner;

import java.util.Properties;

// ctr+alt+o :-> auto import missing library
// sout ctrl+j	System.out.println(“”)
public class OrderProducer {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        // ctrl+N and search stringserializer and Integerserializer and then copy
        // the package+classname from that module in the 2nd argument of below
        // properties
        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer", "org.example.customserializers.OrderSerializer");
        props.setProperty("partitioner.class", VIPPartitioner.class.getName());

        // ctr+ alt+v in intellij := give option to import respective library and also to create local
        // variable
        KafkaProducer<String, Order> producer = new KafkaProducer<String, Order>(props);
        Order order = new Order();
        order.setCustomerName("Rishabh");
        order.setProduct("mac Book pro");
        order.setQuantity(10);

        ProducerRecord<String, Order> record = new ProducerRecord<>("OrderPartionedTopic",order.getCustomerName(), order);

        try {
            producer.send(record);
            System.out.println("Successfully sent");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}