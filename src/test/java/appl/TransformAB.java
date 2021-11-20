package appl;

import infrastructure.service.ITransformation;
import lombok.var;
import model.EntityA;
import model.EntityB;

public class TransformAB implements ITransformation<EntityA, EntityB> {
    public EntityB transform(EntityA in) {
        var out = new EntityB();
        out.setType(in.getType());
        out.setId((in.getId()));
        out.setAttr1(in.getAttr1());
        return out;
    }
}
