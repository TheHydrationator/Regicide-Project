import java.util.*;
public class Deck {
    
    private ArrayList<Card> deck = new ArrayList<>();
    
    
    public Deck(){
        ArrayList<Card> deck = new ArrayList<>();
    }
    
    public void createDeck(){
        
        ArrayList<Card> newDeck = new ArrayList<>();
        
        String value = "";
        String suit = "";
        String abbreviation = "";
        String abbreviationOne = "";
        String abbreviationTwo = "";
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 13; j++){
                    boolean isFaceCard = false;
                    
                    switch (i){
                        case 0:
                            suit = "Spades";
                            abbreviationTwo = "S";
                            break;
                        case 1:
                            suit = "Hearts";
                            abbreviationTwo = "H";
                            break;
                        case 2:
                            suit = "Clubs";
                            abbreviationTwo = "C";
                            break;
                        case 3:
                            suit = "Diamonds";
                            abbreviationTwo = "D";
                            break;
                    }
                    
                    if(j <= 8){ //if j is 0, the first card value will be 2, so an 8 will be 10, and anything higher is J,Q,K,A
                        value = String.valueOf(j + 2);
                        abbreviationOne = String.valueOf(j + 2);
                    } else {
                        switch (j){
                            
                            case 9:
                                value = "Jack";
                                abbreviationOne = "J";
                                isFaceCard = true;
                                break;
                            case 10:
                                value = "Queen";
                                abbreviationOne = "Q";
                                isFaceCard = true;
                                break;
                            case 11:
                                value = "King";
                                abbreviationOne = "K";
                                isFaceCard = true;
                                break;
                            case 12:
                                value = "Ace";
                                abbreviationOne = "A";
                                isFaceCard = true; //dont want this being read as a number
                                break;
                        }
                    }
                abbreviation = abbreviationOne + abbreviationTwo;
                Card c = new Card(value, suit, abbreviation, isFaceCard);
                newDeck.add(c);
                }//j
            }//i
        
        this.deck = newDeck;
        
    }//resetDeck()
    
    public void createNoFaceCardDeck(){
        
        ArrayList<Card> newDeck = new ArrayList<>();
        
        String value = "";
        String suit = "";
        String abbreviation = "";
        String abbreviationOne = "";
        String abbreviationTwo = "";

        
            for(int i = 0; i < 4; i++){
                for(int j = 0; j <= 9; j++){
                    
                    boolean isFaceCard = false;
                    
                    if(j == 9){
                        value = "Ace";
                        abbreviationOne = "A";
                        isFaceCard = true;
                    } else {
                        value = String.valueOf(j + 2);
                        abbreviationOne = String.valueOf(j + 2);
                    }
                    
                    switch (i){
                        case 0:
                            suit = "Spades";
                            abbreviationTwo = "S";
                            break;
                        case 1:
                            suit = "Hearts";
                            abbreviationTwo = "H";
                            break;
                        case 2:
                            suit = "Clubs";
                            abbreviationTwo = "C";
                            break;
                        case 3:
                            suit = "Diamonds";
                            abbreviationTwo = "D";
                            break;
                    } // switch
                    abbreviation = abbreviationOne + abbreviationTwo;
                    Card c = new Card(value, suit, abbreviation, isFaceCard);
                    newDeck.add(c);
                }//j
            }//i
            
            this.deck = newDeck;
            
        }//create no face card deck
        
        public void createEvilDeck(){
            //ONLY face cards
            
            ArrayList<Card> newDeck = new ArrayList<>();
        
        String value = "";
        String suit = "";
        String abbreviation = "";
        String abbreviationOne = "";
        String abbreviationTwo = "";
        
        //switch the "value" for loop and suit for loop
        //because we need to sort by value
            for(int i = 0; i <= 2; i++){
            boolean isFaceCard = false;
        ArrayList<Integer> chosenNumbers = new ArrayList<>();
        chosenNumbers.add(0);
                for(int j = 0; j < 4; j++){
                    
                int random = 0;
                    switch (i){
                        case 0:
                            value = "Jack";
                            abbreviationOne = "J";
                            isFaceCard = true;
                            
                            //could probably make a method out of this
                            //but i dont feel like it
                            while(chosenNumbers.indexOf(random) != -1){
                                random = (int)(Math.random() * 4) + 1;
                            }
                            chosenNumbers.add(random);
                            
                            switch (random){
                                case 1:
                                    suit = "Spades";
                                    abbreviationTwo = "S";
                                    break;
                                case 2:
                                    suit = "Hearts";
                                    abbreviationTwo = "H";
                                    break;
                                case 3:
                                    suit = "Clubs";
                                    abbreviationTwo = "C";
                                    break;
                                case 4:
                                    suit = "Diamonds";
                                    abbreviationTwo = "D";
                                    break;
                            }
                            
                            break;
                        case 1:
                            value = "Queen";
                            abbreviationOne = "Q";
                            isFaceCard = true;
                            
                            while(chosenNumbers.indexOf(random) != -1){
                                random = (int)(Math.random() * 4) + 1;
                            }
                            chosenNumbers.add(random);
                            
                            switch (random){
                                case 1:
                                    suit = "Spades";
                                    abbreviationTwo = "S";
                                    break;
                                case 2:
                                    suit = "Hearts";
                                    abbreviationTwo = "H";
                                    break;
                                case 3:
                                    suit = "Clubs";
                                    abbreviationTwo = "C";
                                    break;
                                case 4:
                                    suit = "Diamonds";
                                    abbreviationTwo = "D";
                                    break;
                            }
                            
                            break;
                        case 2:
                            value = "King";
                            abbreviationOne = "K";
                            isFaceCard = true;
                            
                            while(chosenNumbers.indexOf(random) != -1){
                                random = (int)(Math.random() * 4) + 1;
                            }
                            chosenNumbers.add(random);
                            
                            switch (random){
                                case 1:
                                    suit = "Spades";
                                    abbreviationTwo = "S";
                                    break;
                                case 2:
                                    suit = "Hearts";
                                    abbreviationTwo = "H";
                                    break;
                                case 3:
                                    suit = "Clubs";
                                    abbreviationTwo = "C";
                                    break;
                                case 4:
                                    suit = "Diamonds";
                                    abbreviationTwo = "D";
                                    break;
                            }
                        break;
                    }
                    
                    
                    abbreviation = abbreviationOne + abbreviationTwo;
                    Card c = new Card(value, suit, abbreviation, isFaceCard);
                    newDeck.add(c);
                }//j
            }//i
            
            this.deck = newDeck;
            
        }//evil deck
    
    public ArrayList<Card> getDeck(){
        return this.deck;
    }
    
    public void setDeck(ArrayList<Card> deck){
        this.deck = deck;
    }
    
    public void printDeck(){
        System.out.print("{");
        for (int i = 0; i < deck.size(); i++){
            System.out.print(deck.get(i));
            //pretty print
            if(i != deck.size() - 1){
                System.out.println(", ");
            }
        }
        System.out.println("}");
    }
    
    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }
    
    public Card drawCard(){
        Card card = this.deck.get(0);
        this.deck.remove(card);
        return card;
    }
    
    public int getDeckSize(){
        return this.deck.size();
    }
    
    public void addCard(Card card){
        this.deck.add(card);
    }
    
    public void removeCard(Card card){
        this.deck.remove(card);
    }
    
    //look at me im overriding
    public void removeCard(int idx){
        this.deck.remove(idx);
    }
    
    public void addCardToTop(Card card){
        this.deck.add(0, card);
    }
    
    public Card get(int idx){
        return this.deck.get(idx);
    }
    
    public boolean checkCardsOfValue(String value){
        ArrayList<Card> list = new ArrayList<>();
        for(int i = 0; i < deck.size(); i++){
                if(deck.get(i).getValue().equals(value)){
                    list.add(deck.get(i));
                }
            }
            return list.size() != 0;
        }
        
    public ArrayList<Card> getCardsOfValue(String value){
        ArrayList<Card> list = new ArrayList<>();
        for(int i = 0; i < deck.size(); i++){
                if(deck.get(i).getValue().equals(value)){
                    list.add(deck.get(i));
                }
            }
            return list;
        }
    
    public ArrayList<Card> getCardsOfValue(String value, Card card){
        ArrayList<Card> list = new ArrayList<>();
        for(int i = 0; i < deck.size(); i++){
            if(deck.get(i).getValue().equals(value) && deck.get(i) != card){
                list.add(deck.get(i));
            }
        }
        return list;
    }
    
public void printDeckExcept(Card card) {
    System.out.print("{");
    boolean first = true;
    for (int i = 0; i < deck.size(); i++) {
        if (!deck.get(i).equals(card)) {
            if (!first) {
                System.out.println(", ");
            }
            System.out.print(deck.get(i));
            first = false;
        }
    }
    System.out.println("}");
    }

    public void sort(){
    
    ArrayList<Card> list = new ArrayList<>();
    
        //2-14
        for(int i = 2; i <= 14; i++){
            
            String value = Integer.toString(i);
            
            if(value.equals("11")){
                value = "Jack";
            } else if(value.equals("12")){
                value = "Queen";
            } else if(value.equals("13")){
                value = "King";
            } else if(value.equals("14")){
                value = "Ace";
            }
            
            ArrayList<Card> cards = getCardsOfValue(value);

            if(cards.size() != 0){
                
                for(int j = 0; j < cards.size(); j++){
                    list.add(cards.get(j));
                }
            }
        }
        
        this.deck = list;
        
    }//sortDeck
}
