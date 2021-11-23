package jupiterpa.infrastructure.service;

import jupiterpa.infrastructure.model.IEntity;

import java.util.List;

public interface ITransformation<A extends IEntity,
                                 B extends IEntity> {
    List<B> transform(A input) throws BusinessException;
}
