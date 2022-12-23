package com.sdk.threatwinds.entity.eout;

import java.util.List;

public class EntityDefResponse {
    String type;
    String description;
    String example;
    List<EntityDefAttribute> attributes;


    public EntityDefResponse(String type, String description, String example, List<EntityDefAttribute> attributes) {
        this.type = type;
        this.description = description;
        this.example = example;
        this.attributes = attributes;
    }

    public EntityDefResponse(){}

    public List<EntityDefAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<EntityDefAttribute> attributes) {
        this.attributes = attributes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String attr = (attributes.size()==0)?"]":"{\"name\"=\""+attributes.get(0).name+"\"}]";
        return "EntityDefResponse{" +
                "\"attributes\"=[" + attr +
                ", \"description\"=\"" + description + '\"' +
                ", \"example\"=\"" + example + '\"' +
                ", \"type\"=\"" + type + '\"' +
                '}';
    }
}
