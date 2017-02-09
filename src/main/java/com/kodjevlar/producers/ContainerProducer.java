package com.kodjevlar.producers;

import com.kodjevlar.consumers.ContentItemRunner;
import com.kodjevlar.models.ContentItem;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ContainerProducer {
    protected static Producer<String, String> producer;

    public void createProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        this.producer = new KafkaProducer<String, String>(props);
    }

    public void send(String json) {
        if (ContainerProducer.producer == null)
            createProducer();

        ContainerProducer.producer.send(new ProducerRecord<String, String>(ContentItemRunner.CREATE_CONTAINER_TOPIC, "contentItem", json));
        ContainerProducer.producer.flush();
    }
}
