package jupiterpa.infrastructure.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @Builder( toBuilder = true )
public class Message<A extends IEntity> {
    Key key;
    Key predecessor;
    Key origin;
    Types.StatusCode statusCode;
    String createdAt;
    String createdBy;
    List<ErrorMessage> errorMessages;

    A payload;
}
