package com.kodjevlar.consumers;

import com.google.gson.Gson;
import com.kodjevlar.models.ContentItem;
import com.kodjevlar.utils.Mongo;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.errors.WakeupException;

import java.util.Arrays;
import java.util.Iterator;

public class ContentItemRunner extends AmorConsumer implements Runnable {
    public final static String CREATE_CONTAINER_TOPIC = "amor_create_container";
    public final static String DELETE_CONTAINER_TOPIC = "amor_delete_container";

    public ContentItemRunner() {
        super();

        this.consumer.subscribe(Arrays.asList(
                ContentItemRunner.CREATE_CONTAINER_TOPIC,
                ContentItemRunner.DELETE_CONTAINER_TOPIC
        ));
    }

    @Override
    public void run() {
        this.threadId = Thread.currentThread().getId();

        try {
            while (!this.closed.get()) {
                ConsumerRecords records = consumer.poll(200);

                if (records.count() > 0) {
                    Iterator it = records.iterator();

                    while(it.hasNext()) {
                        ConsumerRecord record = (ConsumerRecord) it.next();

                        this.printRecord(record);
                        System.out.println(record.toString());
                        this.createContentItem((String)record.value());
                    }
                }
            }
        } catch(WakeupException e) {
            // Ignore exception if closing
            if (!closed.get()) throw e;
        } finally {
            consumer.close();
        }
    }

    private void createContentItem(String meta) {
        try {
            Object item  = this.parser.fromJson(meta, ContentItem.class);

            Mongo.getDatastore().save(item);
        } catch(Exception err) {
            System.out.print(err.toString()); // TODO: Write to log.
        }
    }

    private void removeContentItem(String contentItemId) {}

    private void updateContentItem(String payload) {}
}
