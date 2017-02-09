package com.kodjevlar.consumers;

import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AmorConsumer {
    private ConsumerConfig config;
    // Atomic boolean is used to prevent clashes between consumer threads.
    protected final AtomicBoolean closed = new AtomicBoolean(false);
    protected final KafkaConsumer consumer;
    // Kafka topics
    protected final static String SERVICE_NAME = "amor-service";
    protected final static String AUTH_PRIVATE_KEY_= "heimdall_recieve_pk";
    protected long threadId;
    protected Gson parser = new Gson();

    public AmorConsumer() {
        // Set consumer properties.
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka:9092"); // TODO: set by ENV host:port
        props.put("group.id", SERVICE_NAME);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        this.consumer = new KafkaConsumer(props);
    }

    // Shutdown hook which can be called from a separate thread.
    protected void shutdown() {
        closed.set(true);
        consumer.wakeup();
    }

    public void printRecord(ConsumerRecord record) {
        System.out.format("[thread: %s] topic: %s, key: %s, value: %s, offset: %s, time: %s \n", this.threadId, record.topic(), record.key(), record.value(), record.offset(), record.timestamp());
    }
}
