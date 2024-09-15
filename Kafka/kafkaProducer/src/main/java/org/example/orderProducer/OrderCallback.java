package org.example.orderProducer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class OrderCallback implements Callback {
    @Override
    public void onCompletion(RecordMetadata recorddata,Exception e){
        System.out.println(recorddata.partition());
        System.out.println(recorddata.offset());
        System.out.println("message sent successfully");

        if(e!=null){
            e.printStackTrace();
        }
    }

}
