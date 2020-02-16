package glit.mongodb.mongoTutorial.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@Document(collection = "drugs")
public class Drugs {
    @Id
    private String id;
    private String drugname;
    private Integer label;
    private String smiles;
}
