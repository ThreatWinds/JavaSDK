package utm.sdk.threatwinds.entity.ein;

import java.util.List;

public class Associations {
    List<String> associations;
    String comment;

    public Associations(List<String> associations, String comment) {
        this.associations = associations;
        this.comment = comment;
    }

    public Associations(){}

    public List<String> getAssociations() {
        return associations;
    }

    public void setAssociations(List<String> associations) {
        this.associations = associations;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
