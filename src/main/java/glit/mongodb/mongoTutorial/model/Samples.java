package glit.mongodb.mongoTutorial.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "samples")
public class Samples {
    @Id
    private String id;
    private String drugname;
    private Integer label;
    private String smiles;
    private String cellline;
    private Float dosage;
    private Integer duration;
    private List<Integer> ecfp;
    private List<Float> gex;

    public Samples(String drugname, Integer label, String smiles,
                   String cellline, Float dosage, Integer duration, List<Integer> ecfp, List<Float> gex) {
        this.drugname = drugname;
        this.label = label;
        this.smiles = smiles;
        this.cellline = cellline;
        this.dosage = dosage;
        this.duration = duration;
        this.ecfp = ecfp;
        this.gex = gex;
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

    public String getCellline() { return cellline; }
    public void setCellline(String cellline) { this.cellline = cellline; }

    public Float getDosage() { return dosage; }
    public void setDosage(Float dosage) { this.dosage = dosage; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public List<Integer> getEcfp() { return ecfp; }
    public void setEcfp( List<Integer> ecfp) { this.ecfp = ecfp; }

    public List<Float> getGex() { return gex; }
    public void setGex(List<Float> gex) { this.gex = gex; }

}
