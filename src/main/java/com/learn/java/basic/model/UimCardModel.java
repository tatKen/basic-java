package com.learn.java.basic.model;

public class UimCardModel {
    private String name;
    private String cardOType;
    private String status;

    public UimCardModel() {
    }

    public UimCardModel(String name, String cardOType, String status) {
        this.name = name;
        this.cardOType = cardOType;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardOType() {
        return cardOType;
    }

    public void setCardOType(String cardOType) {
        this.cardOType = cardOType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UimCardModel{" +
                "name='" + name + '\'' +
                ", cardOType='" + cardOType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
