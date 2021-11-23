package jupiterpa.appl;

import jupiterpa.infrastructure.service.ITransformation;
import model.EntityA;
import model.EntityB;

import java.util.ArrayList;
import java.util.List;

public class TransformAB implements ITransformation<EntityA, EntityB> {

    public List<EntityB> transform(EntityA in) {
        List<EntityB> list = new ArrayList<>();
        EntityB out = new EntityB();
        out.setType(in.getType());
        out.setId((in.getId()));
        out.setAttr1(in.getAttr1());
        list.add(out);
        return list;
    }

}
