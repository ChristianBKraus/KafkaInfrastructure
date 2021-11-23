package model;

import jupiterpa.infrastructure.model.IEntity;
import lombok.Data;

@Data
public class EntityB implements IEntity {
    String type;
    String id;

    String attr1;
}
