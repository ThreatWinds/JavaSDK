package com.sdk.threatwinds.entity.eout;

import java.util.List;

public class EntityResponse {
    Integer accuracyScore;
    String createdAt;
    String entityID;
    String lastSeen;
    Integer reputationScore;
    String type;
    String updatedAt;
    String userID;
    String value;

    public EntityResponse(Integer accuracyScore, String createdAt,
                          String entityID, String lastSeen, Integer reputationScore,
                          String type, String updatedAt, String userID, String value) {
        this.accuracyScore = accuracyScore;
        this.createdAt = createdAt;
        this.entityID = entityID;
        this.lastSeen = lastSeen;
        this.reputationScore = reputationScore;
        this.type = type;
        this.updatedAt = updatedAt;
        this.userID = userID;
        this.value = value;
    }

    public EntityResponse(){}

    public Integer getAccuracyScore() {
        return accuracyScore;
    }

    public void setAccuracyScore(Integer accuracyScore) {
        this.accuracyScore = accuracyScore;
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
        return "EntityResponse{" +
                "accuracyScore=" + accuracyScore +
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
