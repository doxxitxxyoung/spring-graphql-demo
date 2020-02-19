package glit.mongodb.mongoTutorial.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "drugs")
public class Drugs {
    @Id
    private String id;
    private String drugname;
    private Integer label;
    private String smiles;
}
*/


@Document(collection = "samples")
public class Drugs {
    @Id
    private String id;
    private String drugname;
    private Integer label;
    private String smiles;

    public Drugs(String drugname, Integer label, String smiles) {
        this.drugname = drugname;
        this.label = label;
        this.smiles = smiles;
    }

    public String get_id() { return id; }
    //    public void set_id(ObjectId)
    public void set_id(String id) {this.id = id;}

    public String getDrugname() { return drugname; }
    public void setDrugname(String drugname) { this.drugname = drugname; }

    public Integer getLabel() { return label; }
    public void setLabel(Integer label) { this.label = label; }

    public String getSmiles() { return smiles; }
    public void setSmiles(String smiles) { this.smiles = smiles; }

}
