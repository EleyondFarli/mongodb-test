package eleyond.mongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "attachments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {
    @Id
    private String id;
    private String filename;
    private String taskId;
}
