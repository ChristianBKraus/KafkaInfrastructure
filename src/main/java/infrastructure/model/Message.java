package infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Message<A extends IEntity> {
    Key key;
    Key predecessor;
    Key origin;
    Types.StatusCode statusCode;
    String createdAt;
    String createdBy;
    A payload;
}
