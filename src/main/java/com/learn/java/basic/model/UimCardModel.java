package com.learn.java.basic.model;

public class UimCardModel {
    private String name;
    private String cardOType;

    public UimCardModel() {
    }

    public UimCardModel(String name, String cardOType) {
        this.name = name;
        this.cardOType = cardOType;
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
}
