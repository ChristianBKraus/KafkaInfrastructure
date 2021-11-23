package jupiterpa.appl;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class Consumer {

    @KafkaListener(topics = {"streams-wordcount-output"}, groupId = "spring-boot-kafka")
    public void consume(ConsumerRecord<String, Long> record) {
        System.out.println("received = " + record.value() + " with key " + record.key());
    }
}
