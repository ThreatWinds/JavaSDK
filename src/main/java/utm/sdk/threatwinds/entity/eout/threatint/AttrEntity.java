package utm.sdk.threatwinds.entity.eout.threatint;

public class AttrEntity {

    String name;
    String comment;
    ThreatIntEntity entity;

    public AttrEntity(String name, String comment, ThreatIntEntity entity) {
        this.name = name;
        this.comment = comment;
        this.entity = entity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ThreatIntEntity getEntity() {
        return entity;
    }

    public void setEntity(ThreatIntEntity entity) {
        this.entity = entity;
    }
}
