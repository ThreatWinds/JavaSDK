package com.sdk.threatwinds.entity.eout;

// Class to define attribute on EntityDef, it is used in /api/v1/entity/definitions endpoint
// Used by EntityDef class
public class EntityDefAttribute {
    String description;
    String name;
    EntityDefResponse type;

    public EntityDefAttribute(String description, String name, EntityDefResponse type) {
        this.description = description;
        this.name = name;
        this.type = type;
    }

    public EntityDefAttribute(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntityDefResponse getType() {
        return type;
    }

    public void setType(EntityDefResponse type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "EntityDefAttribute{" +
                ", \"description\"=\"" + description + '\"' +
                ", \"name\"=\"" + name + '\"' +
                ", \"type\"=\"" + type.getType() + '\"' +
                '}';
    }
}
