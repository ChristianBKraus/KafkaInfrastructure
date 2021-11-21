package infrastructure.service;

import infrastructure.model.*;

import java.util.ArrayList;
import java.util.List;

public class Process<A extends IEntity, B extends IEntity> {

    public List<Message<B>> transform(Message<A> in,
                                ITransformation<A,B> transformation
            ) {
        try {
            List<Message<B>> list = new ArrayList<>();
            List<B> transformed = transformation.transform(in.getPayload());
            transformed.forEach( out ->
                    list.add(
                            new Message<>(
                                    new Key(out.getType(), out.getId()), in.getKey(), in.getOrigin(), Types.StatusCode.INITIAL,
                                    in.getCreatedAt(), in.getCreatedBy(), out
                                        )
                            )
            );
            return list;
        } catch (BusinessException ex) {
            // TODO
            return null;
        }
    }

}
