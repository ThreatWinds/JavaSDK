package utm.sdk.threatwinds.entity.ein;

import java.util.List;

public class ThreatIntEntity {

    String type;
    String value;
    Integer reputation;
    List<AttrEntity> attributes;
    List<AttrEntity> associations;

    public ThreatIntEntity(String type, String value, Integer reputation, List<AttrEntity> attributes, List<AttrEntity> associations) {
        this.type = type;
        this.value = value;
        this.reputation = reputation;
        this.attributes = attributes;
        this.associations = associations;
    }

    public ThreatIntEntity() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<AttrEntity> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttrEntity> attributes) {
        this.attributes = attributes;
    }

    public List<AttrEntity> getAssociations() {
        return associations;
    }

    public void setAssociations(List<AttrEntity> associations) {
        this.associations = associations;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }
}
