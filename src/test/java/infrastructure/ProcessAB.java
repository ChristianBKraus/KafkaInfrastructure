package infrastructure;

import appl.TransformAB;
import infrastructure.model.Key;
import infrastructure.model.Message;
import infrastructure.service.Process;
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
