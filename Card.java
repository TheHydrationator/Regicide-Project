public class Card {
    
    private String value;
    private String suit;
    private String abbreviation;
    private boolean isFaceCard;
    
    public Card(String value, String suit, String abbreviation, boolean isFaceCard){
        this.value = value;
        this.suit = suit;
        this.abbreviation = abbreviation;
        this.isFaceCard = isFaceCard;
    }
    
    public void setValue(String value){
        this.value = value;
    }
    
    public String getValue(){
        return this.value;
    }
    
    public void setSuit(String suit){
         this.suit = suit;
    }
    
    public String getSuit(){
        return this.suit;
    }
    
    public void setAbbreviation(String abbreviation){
        this.abbreviation = abbreviation;
    }
    
    public String getAbbreviation(){
        return this.abbreviation.toLowerCase();
    }
    
    @Override
    public String toString(){
        return (this.value + " of " + suit);
    }
    
    public void setIsFaceCard(boolean isFaceCard){
        this.isFaceCard = isFaceCard;
    }
    
    public boolean getIsFaceCard(){
        return this.isFaceCard;
    }
}
