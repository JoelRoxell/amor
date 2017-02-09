package com.kodjevlar.consumers;

import com.kodjevlar.models.Like;
import com.kodjevlar.utils.Mongo;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.util.Arrays;
import java.util.Iterator;

public class LikeRunner extends AmorConsumer implements Runnable {
    protected final static String LIKE_TOPIC = "amor_on_like";
    protected final static String UNLIKE_TOPIC = "amor_off_like";

    public LikeRunner() {
        super();

        this.consumer.subscribe(Arrays.asList(
                LikeRunner.LIKE_TOPIC,
                LikeRunner.UNLIKE_TOPIC
        ));
    }

    @Override
    public void run() {
        this.threadId = Thread.currentThread().getId();

        Iterator it;

        while(!this.closed.get()) {
            ConsumerRecords records = consumer.poll(200);
            it = records.iterator();

            while (it.hasNext()) {
                ConsumerRecord record = (ConsumerRecord)it.next();

                if (record.value().toString().length() == 0) {
                    continue;
                }

                // TODO: trigger action on topic type.
                switch (record.topic()) {
                    case LikeRunner.LIKE_TOPIC:
                        System.out.println(record.value());
                        System.out.println("received like topic");
                        break;

                    case LikeRunner.UNLIKE_TOPIC:
                        System.out.print("received unlike topic");
                        break;
                    default:
                        return;
                }
            }
        }
    }

    void like(String userId, String contentItemId) {
        // TODO: update content item likes reference.
    }
}
