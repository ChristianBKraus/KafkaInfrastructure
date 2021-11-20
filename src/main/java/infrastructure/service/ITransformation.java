package infrastructure.service;

import infrastructure.model.IEntity;

public interface ITransformation<A extends IEntity,
                                 B extends IEntity> {
    B transform(A input);
}
