package eleyond.mongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    private String id;
    private String name;
    private String description;
}
