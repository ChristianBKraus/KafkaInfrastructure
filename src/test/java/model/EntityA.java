package model;

import infrastructure.model.IEntity;
import lombok.Data;

@Data
public class EntityA implements IEntity {
    String type;
    String id;

    String attr1;
}
