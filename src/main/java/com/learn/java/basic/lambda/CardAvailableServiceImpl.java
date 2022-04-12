package com.learn.java.basic.lambda;

public class CardAvailableServiceImpl {
    public static void main(String[] args){
        CardAvailable cardAvailable = (cardName, cardType, cnt) -> System.out.println(String.format("Lambda check card available with cardName [%s] cardType [%s]", cardName, cardType));

        cardAvailable.checkAvailable("DummySplitter", "Splitter", 1);

        ExtendCardAvailable extendCardAvailable = () -> System.out.println(String.format("Lambda check card available with cardName [%s] cardType [%s]", "Hardcode LOCALADM", "Hardcode LOCAL DP"));

        extendCardAvailable.checkAvailable("DummyLocalDP", "Local Fiber DP", 1);
        extendCardAvailable.extendCheckAvailable();
    }
}

interface ExtendCardAvailable extends CardAvailable{
    default void checkAvailable(String cardName, String cardType, int count){System.out.println("implement interface ExtendCardAvailable checkAvailable");};

    void extendCheckAvailable();
}


