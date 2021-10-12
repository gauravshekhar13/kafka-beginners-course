package com.github.simplesteph.kafka.tutorial1;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo
{
    public static void main(String[] args) {
        //System.out.println("hello world");
        Logger logger = LoggerFactory.getLogger(ProducerDemo.class);
        String bootStrapServers = "127.0.0.1:9092";
        //Create Producer Properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        //Create the Producer
        KafkaProducer<String,String> producer = new KafkaProducer<String,String>(properties);

for(int i=15;i<25;i++) {
    //Create a producer record
    ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("first_topic", "hi Gaurav from Program"+Integer.toString(i));


    //Send Data
    //producer.send(producerRecord);

    //Callback functions

    producer.send(producerRecord, new Callback() {
        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {

            if (e == null) {
                logger.info("Received New Metadata \n" + "Topic::" + recordMetadata.topic() + "\n" + "Partition::" + recordMetadata.partition() + "\n" + "Offset::" + recordMetadata.offset() + "\n");
            } else {
                logger.error("Error while Producing", e);
            }
        }
    });
}
        producer.flush();
        producer.close();
    }

}
