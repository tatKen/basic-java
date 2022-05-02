package com.learn.java.basic.stream;

import com.learn.java.basic.model.UimCardModel;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PipelineServiceImpl {

    public Stream<UimCardModel> getCardList(){
        UimCardModel card1 = new UimCardModel("Dummy005S3", "Splitter", "S");
        UimCardModel card2 = new UimCardModel("Dummy006S3", "Splitter", "S");
        UimCardModel card3 = new UimCardModel("Dummy007S3", "Splitter", "S");
        UimCardModel card4 = new UimCardModel("Dummy008S3", "Splitter", "S");
        UimCardModel card5 = new UimCardModel("Dummy009S3", "Splitter", "S");

        List<UimCardModel> cards = new ArrayList<UimCardModel>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        return cards.stream();
    }

    // Predicate practice
    Predicate<UimCardModel> isNameWithDummy = (uimCardModel -> {
        if(uimCardModel.getCardOType().equalsIgnoreCase("LOCALDP"))
            return true;
        else
            return uimCardModel.getName().contains("Dummy");
    });

    Predicate<UimCardModel> isSplitter = (uimCardModel) -> {
        return uimCardModel.getCardOType().equalsIgnoreCase("Splitter");
    };

    Predicate<UimCardModel> isTargetSplitter = isNameWithDummy.and(isSplitter);

    public void pipelineShowCase(){
        System.out.println("--------------  begin pipelineShowCase");

        // creation
        System.out.println("--------------  initializing objects");
        UimCardModel card1 = new UimCardModel("Dummy001S3", "Splitter", "S");
        UimCardModel card2 = new UimCardModel("Dummy002S3", "Splitter", "S");
        UimCardModel card3 = new UimCardModel("Dummy003S3", "LOCALDP", "W");
        UimCardModel card4 = new UimCardModel("Dummy004S3", "Splitter", "W");
        UimCardModel card5 = new UimCardModel("ADMHKRPS005S3", "Splitter", "W");

        List<UimCardModel> cards = new ArrayList<UimCardModel>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        System.out.println("--------------  creation of stream");
        // Create the Stream from List
        Stream<UimCardModel> cardStreamFrArray = cards.stream();

        // Create the Stream from Stream of Ts....
        Stream<UimCardModel> cardStreamFrStrOf = Stream.of(card1, card2, card3, card4, card5);

        // create the Stream from generate
        Stream<UimCardModel> cardStrFrGenerate = Stream.generate(() -> new UimCardModel("Dummy010GB", "LOCALDP", "S"));

        // stream.limit
//        Stream<UimCardModel> cardStrWithLimit = cardStreamFrArray.limit(4);

        // use for each
        // Test result, throwing exception for cardStreamFrArray - java.lang.IllegalStateException: stream has already been operated upon or closed
//        System.out.println("--------------  printing [cardStreamFrArray]");
//        cardStreamFrArray.forEach(System.out::println);
//
//        System.out.println("--------------  printing [cardStreamFrStrOf]");
//        cardStreamFrStrOf.forEach(System.out::println);
//
//        System.out.println("--------------  printing [cardStrFrGenerate]");
//        cardStrFrGenerate.limit(10).forEach(System.out::println);

//        System.out.println("--------------  printing [cardStrWithLimit]");
//        cardStrWithLimit.forEach(System.out::println);



        // stream.filter
        List<UimCardModel> cardsWithFilter = cardStreamFrStrOf.filter(dto -> isTargetSplitter.test(dto)).collect(Collectors.toList());

//        System.out.println("--------------  printing [cardStreamFrStrOf]");
//        cardStreamFrStrOf.forEach(System.out::println);

        System.out.println("--------------  printing [strWithFilter]");
        cardsWithFilter.forEach(System.out::println);

        // filter the target list and update the target list and put back the original list
//        List<UimCardModel> tagetSplitterCards = cards.stream().filter(dto -> isTargetSplitter.test(dto)).collect(Collectors.toList());
        List<UimCardModel> tagetSplitterCards = cards.stream().filter(dto -> (dto.getName().contains("Dummy") && dto.getCardOType().equalsIgnoreCase("Splitter"))).collect(Collectors.toList());

        tagetSplitterCards.forEach(dto -> {dto.setStatus("WInfra");});

        System.out.println("[intermediate update to WInfra] --------------  printing [cards]");
        cards.forEach(System.out::println);

        System.out.println("[intermediate update to WInfra] --------------  printing [tagetSplitterCards]");
        tagetSplitterCards.forEach(System.out::println);

        // put back the original list
        for(UimCardModel card : cards){
            tagetSplitterCards.forEach(dto -> {
                if(dto.getName().equalsIgnoreCase(card.getName())){
                    card.setStatus(dto.getStatus());
                }
            });
        }

//        System.out.println("[result] --------------  printing [cards]");
//        cards.forEach(System.out::println);
//
//        System.out.println("[result] --------------  printing [tagetSplitterCards]");
//        tagetSplitterCards.forEach(System.out::println);



        //

//        Instant start

        // stream.anyMatch
        cards.stream().anyMatch(dto -> dto.getName().equalsIgnoreCase(""));

        // stream.match how to put the output list to original list
//        Stream<UimCardModel> streamFromMap = cards.stream().map(dto -> dto.setStatus());

        // stream.count


        // dropwhile


        // takewhile


        // skip


        // collect


        // reduce


        // stream.iterate

    }
}
