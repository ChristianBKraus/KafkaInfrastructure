package infrastructure.service;

import infrastructure.model.IEntity;
import infrastructure.model.Key;
import infrastructure.model.Message;
import infrastructure.model.Types;

public class Process<A extends IEntity, B extends IEntity> {
    public Message<B> transform(Message<A> in,
                                ITransformation<A,B> transformation
            ) {
        B out = transformation.transform(in.getPayload());
        return new Message<>(
                new Key(out.getType(),out.getId()),
                in.getKey(),
                in.getOrigin(),
                Types.StatusCode.INITIAL,
                in.getCreatedAt(),
                in.getCreatedBy(),
                out);
    }

}
