package utm.sdk.threatwinds.entity.eout;

public class AttributeResponse {
    Integer accuracyScore;
    String attributeID;
    String comment;
    String createdAt;
    String entityID;
    String hash;
    String lastSeen;
    String name;
    Integer reputationScore;
    String type;
    String updatedAt;
    String userID;
    String value;

    public AttributeResponse(Integer accuracyScore, String attributeID, String comment, String createdAt,
                             String entityID, String hash, String lastSeen, String name, Integer reputationScore,
                             String type, String updatedAt, String userID, String value) {
        this.accuracyScore = accuracyScore;
        this.attributeID = attributeID;
        this.comment = comment;
        this.createdAt = createdAt;
        this.entityID = entityID;
        this.hash = hash;
        this.lastSeen = lastSeen;
        this.name = name;
        this.reputationScore = reputationScore;
        this.type = type;
        this.updatedAt = updatedAt;
        this.userID = userID;
        this.value = value;
    }

    public AttributeResponse(){}

    public Integer getAccuracyScore() {
        return accuracyScore;
    }

    public void setAccuracyScore(Integer accuracyScore) {
        this.accuracyScore = accuracyScore;
    }

    public String getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(String attributeID) {
        this.attributeID = attributeID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "AttributeResponse{" +
                "accuracyScore=" + accuracyScore +
                ", attributeID='" + attributeID + '\'' +
                ", comment='" + comment + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", entityID='" + entityID + '\'' +
                ", hash='" + hash + '\'' +
                ", lastSeen='" + lastSeen + '\'' +
                ", name='" + name + '\'' +
                ", reputationScore=" + reputationScore +
                ", type='" + type + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", userID='" + userID + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
