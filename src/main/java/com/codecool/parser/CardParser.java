package com.codecool.parser;

import java.util.ArrayList;
import java.util.List;

import com.codecool.player.Card;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CardParser extends XMLParser {

    public CardParser() {
        loadXmlDocument("src/main/java/com/codecool/recources/Cards.xml");
    }

    public List<Card> parse() {
        List<Card> cardsList = new ArrayList<>();
        NodeList cardList = doc.getElementsByTagName("Card");
        for (int i = 0; i < cardList.getLength(); i++) {
            Node cards = cardList.item(i);
            if (cards.getNodeType() == Node.ELEMENT_NODE) {
                Element card = (Element) cards;
                String cardName = card.getAttribute("name");
                int[] statistic = new int[3]; 
                int index = 0;
                NodeList statsList = card.getChildNodes();
                for (int j = 0; j < statsList.getLength(); j++) {
                    Node stats = statsList.item(j);
                    if (stats.getNodeType() == Node.ELEMENT_NODE){
                        Element stat = (Element) stats;
                        statistic[index] = Integer.parseInt(stat.getTextContent());
                        index++;
                    }
                }
                cardsList.add(new Card(cardName, statistic[0], statistic[1], statistic[2]));
            }
        }
        return cardsList;
    }
    
    public void addCard(){
        Element dataTag = doc.getDocumentElement();
        Element cardTag =  (Element) dataTag.getElementsByTagName("Cards").item(0);
        
        Element newCard = doc.createElement("Card");
        newCard.setAttribute("Super", "Card");
        
        Element health = doc.createElement("Health");
        health.setTextContent("25");
        
        Element strength = doc.createElement("Strength");
        strength.setTextContent("25");

        Element magic = doc.createElement("Magic");
        magic.setTextContent("25");
        
        newCard.appendChild(health);
        newCard.appendChild(strength);
        newCard.appendChild(magic);
        
        cardTag.appendChild(newCard);
        System.out.println(cardTag);
    }
}
