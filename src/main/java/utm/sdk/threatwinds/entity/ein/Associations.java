package utm.sdk.threatwinds.entity.ein;

import java.util.List;

public class Associations {
    List<String> associations;

    public Associations(List<String> associations) {
        this.associations = associations;
    }

    public Associations(){}

    public List<String> getAssociations() {
        return associations;
    }

    public void setAssociations(List<String> associations) {
        this.associations = associations;
    }
}
