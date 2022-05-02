package com.learn.java.basic.lambda;

import com.learn.java.basic.model.UimCardModel;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class OperatorServiceImpl {
    public static UnaryOperator<Integer> unaryOperator = s -> s / 6;

    public static UnaryOperator<String> apendText = s -> String.join(" ", s, "withUnaryOperatorEnding");

    public static BinaryOperator<String> testForChangeS3Name = (splitterName, splitterType) -> {
       if(splitterType.equalsIgnoreCase("S3")){
           splitterName = String.join("",splitterName, "LL");
       }
       return splitterName;
    };

    public static Predicate<UimCardModel> isNameSame = (s) -> s.getName().equalsIgnoreCase("ADMSTC097001S3");

    public static Predicate<UimCardModel> isTypeSame = s -> s.getCardOType().equalsIgnoreCase("S3");

    public static void main(String [] args){
        Integer testRtnUnary = unaryOperator.apply(10);
        System.out.println("result for test testRtnUnary="+testRtnUnary);

        String rtnString = apendText.apply("test append ");
        System.out.println("result for test append text="+rtnString);

        String rtnSplitterName = testForChangeS3Name.apply("ADMSTC097001S3", "S3");
        System.out.println("result for test change splitter name="+rtnSplitterName);

        Predicate isTargetSplitter = isNameSame.and(isTypeSame);

        UimCardModel card = new UimCardModel("ADMSTC097001S3", "S3", "S");
        if(isTargetSplitter.test(card)){
            System.out.println(String.format("[%s] This is the target splitter", card));
        } else {
            System.out.println(String.format("[%s] NO!!! This is NOT the target splitter", card));
        }

        UimCardModel fakeCard = new UimCardModel("ADMSTC097001S3", "LOCALDP", "S");
        if(isTargetSplitter.test(fakeCard)){
            System.out.println(String.format("[%s] This is the target splitter", fakeCard));
        } else {
            System.out.println(String.format("[%s] NO!!! This is NOT the target splitter", fakeCard));
        }
    }

}

interface MyUnargOperator<T> {
    T apply(T t);
}



