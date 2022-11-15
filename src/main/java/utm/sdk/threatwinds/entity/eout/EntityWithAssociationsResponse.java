package utm.sdk.threatwinds.entity.eout;

import java.util.List;

public class EntityWithAssociationsResponse {
    Integer accuracyScore;
    List<AssociationResponse> associations;
    List<AttributeResponse> attributes;
    String createdAt;
    String entityID;
    String hash;
    String lastSeen;
    Integer reputationScore;
    String type;
    String updatedAt;
    String userID;
    String value;

    public EntityWithAssociationsResponse(Integer accuracyScore, List<AssociationResponse> associations,
                                          List<AttributeResponse> attributes, String createdAt, String entityID,
                                          String hash, String lastSeen, Integer reputationScore, String type,
                                          String updatedAt, String userID, String value) {
        this.accuracyScore = accuracyScore;
        this.associations = associations;
        this.attributes = attributes;
        this.createdAt = createdAt;
        this.entityID = entityID;
        this.hash = hash;
        this.lastSeen = lastSeen;
        this.reputationScore = reputationScore;
        this.type = type;
        this.updatedAt = updatedAt;
        this.userID = userID;
        this.value = value;
    }

    public EntityWithAssociationsResponse(){}

    public Integer getAccuracyScore() {
        return accuracyScore;
    }

    public void setAccuracyScore(Integer accuracyScore) {
        this.accuracyScore = accuracyScore;
    }

    public List<AssociationResponse> getAssociations() {
        return associations;
    }

    public void setAssociations(List<AssociationResponse> associations) {
        this.associations = associations;
    }

    public List<AttributeResponse> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeResponse> attributes) {
        this.attributes = attributes;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Integer getReputationScore() {
        return reputationScore;
    }

    public void setReputationScore(Integer reputationScore) {
        this.reputationScore = reputationScore;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EntityWithAssociationsResponse{" +
                "accuracyScore=" + accuracyScore +
                ", createdAt='" + createdAt + '\'' +
                ", entityID='" + entityID + '\'' +
                ", hash='" + hash + '\'' +
                ", lastSeen='" + lastSeen + '\'' +
                ", reputationScore=" + reputationScore +
                ", type='" + type + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", userID='" + userID + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
