package jupiterpa.infrastructure.service;

import jupiterpa.infrastructure.model.*;

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
                            Message.<B>builder()
                                    .key(new Key(out.getType(),out.getId()))
                                    .predecessor(in.getKey())
                                    .origin(in.getOrigin())
                                    .statusCode(Types.StatusCode.INITIAL)
                                    .createdAt(in.getCreatedAt())
                                    .createdBy(in.getCreatedBy())
                                    .errorMessages(new ArrayList<>())
                                    .payload( out )
                                    .build()
                            )
            );
            return list;
        } catch (BusinessException ex) {
            // TODO
            return null;
        }
    }

}
