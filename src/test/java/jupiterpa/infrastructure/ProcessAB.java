package jupiterpa.infrastructure;

import jupiterpa.appl.TransformAB;
import jupiterpa.infrastructure.model.Key;
import jupiterpa.infrastructure.model.Message;
import jupiterpa.infrastructure.service.Process;
import model.EntityA;
import model.EntityB;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

public class ProcessAB extends Process<EntityA, EntityB> {

    @Bean
    public Function<KStream<Key, Message<EntityA>>,
                    KStream<Key, Message<EntityB>>> a_2_b() {
        return in -> in
                .flatMapValues(v -> transform(v, new TransformAB() ) )
                .selectKey( (k,v) -> v.getKey());
    }

}
