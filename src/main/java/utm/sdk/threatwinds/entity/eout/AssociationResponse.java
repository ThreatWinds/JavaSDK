package utm.sdk.threatwinds.entity.eout;

public class AssociationResponse {
    Integer accuracyScore;
    String associationID;
    String createdAt;
    String entityID;
    String lastSeen;
    Integer reputationScore;
    String type;
    String updatedAt;
    String userID;
    String value;

    public AssociationResponse(Integer accuracyScore, String associationID, String createdAt,
                               String entityID, String lastSeen, Integer reputationScore,
                               String type, String updatedAt, String userID, String value) {
        this.accuracyScore = accuracyScore;
        this.associationID = associationID;
        this.createdAt = createdAt;
        this.entityID = entityID;
        this.lastSeen = lastSeen;
        this.reputationScore = reputationScore;
        this.type = type;
        this.updatedAt = updatedAt;
        this.userID = userID;
        this.value = value;
    }

    public AssociationResponse(){}

    public Integer getAccuracyScore() {
        return accuracyScore;
    }

    public void setAccuracyScore(Integer accuracyScore) {
        this.accuracyScore = accuracyScore;
    }

    public String getAssociationID() {
        return associationID;
    }

    public void setAssociationID(String associationID) {
        this.associationID = associationID;
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
        return "{" +
                "accuracyScore=" + accuracyScore +
                ", associationID='" + associationID + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", entityID='" + entityID + '\'' +
                ", lastSeen='" + lastSeen + '\'' +
                ", reputationScore=" + reputationScore +
                ", type='" + type + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", userID='" + userID + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
