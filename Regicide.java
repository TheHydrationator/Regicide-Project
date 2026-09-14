import java.util.*;

public class Regicide extends ConsoleProgram {
    public void run() {

        Scanner scan = new Scanner(System.in);
        String command = null;

        Deck deck = new Deck();
        deck.createNoFaceCardDeck();
        deck.shuffleDeck();

        Deck discardPile = new Deck();
        Deck hand = new Deck();
        Deck evilDeck = new Deck();
        evilDeck.createEvilDeck();

        final int MAX_HAND_SIZE = 8;
        Card currentEnemy;
        int enemyHealth = -1;
        int enemyAttack = -1;
        
        int lives = 3;
        
        final int MAX_LIVES = lives;
        
        //so my friends can focus on their academics
        // :)
        final boolean STUDY_MODE = false;
        
        boolean gameOver = false;

        for (int i = 0; i < MAX_HAND_SIZE; i++) {
            hand.addCard(deck.drawCard());
        }

        currentEnemy = evilDeck.drawCard();
        enemyHealth = 20;
        enemyAttack = 10;

        while ((evilDeck.getDeckSize() > 0 || enemyHealth >= 0) && !gameOver) {
            ArrayList<Card> chosenCards = new ArrayList<>();
            boolean spadePower = false;
            boolean heartPower = false;
            boolean clubPower = false;
            boolean diamondPower = false;
            Card currentCard = null;
            Card iterationCard = null;
            int comboTotal = 0;
            boolean cardMatches = false;
            boolean stopComboing = false;
            boolean hasComboed = false;
            int total = 0;
            int pendingDamage = 0;
            
            
            if(STUDY_MODE){
                System.out.println("You should be studying!!!!");
                lives = -1;
                break;
            }
            
                //the magic lives if statement
                    if(hand.getDeckSize() <= 0){
                    System.out.print("\033[H\033[2J");
                    
                        //draw back up i guess
                        if(lives > 1){
                        lives--;
                        System.out.println("You're out of cards! You've lost a life!\n");
                        System.out.println("You have " + lives + " lives remaning.\n");
                
                        System.out.println("Press ENTER to continue");
                        scan.nextLine();
                        
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        
                        
                        } else {
                            gameOver = true;
                        }
                        
                        while(true){
                            if (deck.getDeckSize() == 0 || hand.getDeckSize() >= MAX_HAND_SIZE) {
                                break;
                            } else {
                                hand.addCard(deck.drawCard());
                            }
                        }
                    }
                    
                    hand.sort();
                    
                    if(gameOver){
                        break;
                    }
                
            do{
            
            System.out.println("The current enemy is the " + currentEnemy + ".\n");
            System.out.println("They have " + enemyHealth + " health and " + enemyAttack + " attack.\n");
            System.out.println("There are " + deck.getDeckSize() + " cards left in your deck and " +
                    discardPile.getDeckSize() + " cards in the discard pile.\n");
            System.out.println("Your current hand:\n");
            hand.printDeck();
            System.out.print("\nWhich card would you like to play?\n> ");
            
            
                
                    if(hand.getDeckSize() <= 0){
                        gameOver = true;
                        break;
                    }
                
    
                command = scan.nextLine();
                command = command.toLowerCase();
    
                for (int i = 0; i < hand.getDeckSize(); i++) {
                    currentCard = hand.get(i);
    
                    if (command.equals(currentCard.toString().toLowerCase())
                            || command.equals(currentCard.getAbbreviation())) {
                        chosenCards.add(currentCard);
                        hand.removeCard(chosenCards.get(0));
                        cardMatches = true;
                    }
                }
                
            System.out.print("\033[H\033[2J");
            System.out.flush();
                
            }while (!cardMatches);
            
            System.out.print("\033[H\033[2J");
            System.out.flush();

            if (chosenCards.get(0).getValue().equals("Ace") && !hasComboed && hand.getDeckSize() != 0) {
                System.out.println("You can combo your Ace with one other card!\nYour current hand is:\n");
                hand.printDeckExcept(chosenCards.get(0));
                System.out.print("Which card would you like to add to your Ace? (N for no combo)\n> ");

                hasComboed = true;
                command = scan.nextLine();
                command = command.toLowerCase();
                
                System.out.print("\033[H\033[2J");
                System.out.flush();

                for (int i = 0; i < hand.getDeckSize(); i++) {
                    currentCard = hand.get(i);
                    if (command.equals(currentCard.toString().toLowerCase())
                            || command.equals(currentCard.getAbbreviation().toLowerCase())) {
                        chosenCards.add(currentCard);
                        break;
                    } else if (command.equals("n")) {
                        break;
                    }
                }
            }

            if (!chosenCards.get(0).getIsFaceCard() && Integer.parseInt(chosenCards.get(0).getValue()) <= 5
                    && !hasComboed) {

                comboTotal += Integer.parseInt(chosenCards.get(0).getValue());

                while (comboTotal + Integer.parseInt(chosenCards.get(0).getValue()) <= 10) {

                    ArrayList<Card> possibleCards = hand.getCardsOfValue(chosenCards.get(0).getValue(),
                            chosenCards.get(0));

                    Deck possibleCombos = new Deck();
                    possibleCombos.setDeck(possibleCards);

                    if (possibleCards.size() != 0) {
                        System.out.println("You can combo the " + chosenCards.get(0) + " with the following cards:\n");
                        possibleCombos.printDeck();
                        System.out.print(
                                "\nWhich card would you like to pair? (N for no combo, possibly use an Ace to combo, or end the combo)\n> ");

                        command = scan.nextLine();
                        command = command.toLowerCase();
                        
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        for (int j = 0; j < possibleCombos.getDeckSize(); j++) {
                            iterationCard = possibleCombos.get(j);

                            if (command.equals("n")) {
                                stopComboing = true;
                                break;
                            }

                            if (command.equals(iterationCard.toString().toLowerCase())
                                    || command.equals(iterationCard.getAbbreviation())) {
                                chosenCards.add(iterationCard);
                                hand.removeCard(iterationCard);
                                hasComboed = true;
                                comboTotal += Integer.parseInt(chosenCards.get(0).getValue());

                                if (possibleCards.size() == 0) {
                                    break;
                                }
                            }
                        }

                        if (stopComboing) {
                            break;
                        }

                    } else {
                        break;
                    }
                }
            }

            if (hand.checkCardsOfValue("Ace") && cardMatches && !hasComboed) {
                Deck aces = new Deck();
                aces.setDeck(hand.getCardsOfValue("Ace"));

                System.out.println("You can combo with an ace!\n\nYour aces are:\n");
                aces.printDeck();
                System.out.print("\nWhich card would you like to combo? ('N' to not combo)\n> ");

                command = scan.nextLine();
                command = command.toLowerCase();
                
                System.out.print("\033[H\033[2J");
                System.out.flush();

                for (int i = 0; i < aces.getDeckSize(); i++) {
                    currentCard = aces.get(i);
                    if (command.equals(currentCard.toString().toLowerCase())
                            || command.equals(currentCard.getAbbreviation().toLowerCase())) {
                        chosenCards.add(currentCard);
                        break;
                    } else if (command.equals("n")) {
                        break;
                    }
                }
            }

            for (int i = 0; i < chosenCards.size(); i++) {
                hand.removeCard(chosenCards.get(i));

                String value = chosenCards.get(i).getValue();

                switch (chosenCards.get(i).getSuit()) {
                    case "Spades":
                        spadePower = true;
                        break;
                    case "Hearts":
                        heartPower = true;
                        break;
                    case "Clubs":
                        clubPower = true;
                        break;
                    case "Diamonds":
                        diamondPower = true;
                        break;
                }

                if (!value.equals("Ace") && !value.equals("Jack") && !value.equals("Queen") && !value.equals("King")) {
                    total += Integer.parseInt(chosenCards.get(i).getValue());
                } else {
                    switch (value) {
                        case "Ace":
                            total += 1;
                            break;
                        case "Jack":
                            total += 10;
                            break;
                        case "Queen":
                            total += 15;
                            break;
                        case "King":
                            total += 20;
                            break;
                    }
                }
            }

            if (clubPower && !currentEnemy.getSuit().equals("Clubs")) {
                enemyHealth -= (total * 2);
                System.out.println("Enemy took " + (total * 2) + " damage!\n");
                System.out.println("Enemy has " + enemyHealth + " health remaining.\n");
                
                System.out.println("Press ENTER to continue");
                scan.nextLine();
                
                System.out.print("\033[H\033[2J");
                System.out.flush();
                
            } else {

                enemyHealth -= total;
                System.out.println("Enemy took " + (total) + " damage!\n");
                System.out.println("Enemy has " + enemyHealth + " health remaining.\n");
                
                System.out.println("Press ENTER to continue");
                scan.nextLine();
                
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

            if (heartPower && !currentEnemy.getSuit().equals("Hearts")) {
                discardPile.shuffleDeck();
                for (int i = 0; i < total; i++) {
                    if (discardPile.getDeckSize() == 0) {
                        break;
                    }
                    if (i <= total) {
                        deck.addCard(discardPile.drawCard());
                    } else {
                        break;
                    }
                }
            }

            if (diamondPower && !currentEnemy.getSuit().equals("Diamonds")) {
                for (int i = 0; i < total; i++) {
                    if (deck.getDeckSize() == 0 || hand.getDeckSize() >= MAX_HAND_SIZE) {
                        break;
                    }

                    if (i <= total) {
                        hand.addCard(deck.drawCard());
                    } else {
                        break;
                    }
                }
            }
            
            hand.sort(); //to sort incoming cards

            if (spadePower && !currentEnemy.getSuit().equals("Spades")) {
                enemyAttack -= total;
                if (enemyAttack < 0) {
                    enemyAttack = 0;
                }
            }
            
            //discard all cards used
            while(chosenCards.size() > 0){
                discardPile.addCard(chosenCards.get(0));
                chosenCards.remove(0);
            }

            if (enemyAttack != 0 && enemyHealth > 0) {
                pendingDamage = enemyAttack;
                System.out.println(currentEnemy + " attacks!\n");

                do {
                    
                    
                    //the magic lives if statement
                    if(hand.getDeckSize() <= 0){
                    System.out.print("\033[H\033[2J");
                    
                        //draw back up i guess
                        if(lives > 1){
                        lives--;
                        System.out.println("You're out of cards! You've lost a life!\n");
                        System.out.println("You have " + lives + " lives remaning.\n");
                
                        System.out.println("Press ENTER to continue");
                        scan.nextLine();
                        
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        
                        
                        } else {
                            gameOver = true;
                        }
                        
                        while(true){
                            if (deck.getDeckSize() == 0 || hand.getDeckSize() >= MAX_HAND_SIZE) {
                                break;
                            } else {
                                hand.addCard(deck.drawCard());
                            }
                        }
                    }
                    
                    hand.sort();
                    
                    if(gameOver){
                        break;
                    }

                    
                    System.out.println("You must discard cards that add up to at least " + pendingDamage + ".\n");
                    hand.printDeck();
                    System.out.print("\nWhich card would you like to discard?\n> ");
                    
                    if(hand.getDeckSize() <= 0){
                        gameOver = true;
                        break;
                    }

                    boolean foundValidCard = false;

                    while (!foundValidCard) {
                        command = scan.nextLine();
                        command = command.toLowerCase();
                        
                        //no clearscreen here
                        

                        for (int i = 0; i < hand.getDeckSize(); i++) {
                            if(command.equals(hand.get(i).toString().toLowerCase())
                                    || command.equals(hand.get(i).getAbbreviation().toLowerCase())) {

                                foundValidCard = true;
                                
                                Card c = hand.get(i);

                                if (!c.getIsFaceCard()) {
                                    pendingDamage -= Integer.parseInt(c.getValue());
                                } else {
                                    switch (c.getValue()) {
                                        case "Ace":
                                            pendingDamage -= 1;
                                            break;
                                        case "Jack":
                                            pendingDamage -= 10;
                                            break;
                                        case "Queen":
                                            pendingDamage -= 15;
                                            break;
                                        case "King":
                                            pendingDamage -= 20;
                                            break;
                                    }
                                }

                                hand.removeCard(c);
                                discardPile.addCard(c);
                            }
                        }
                    }
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                } while (pendingDamage > 0);
            }

            if (enemyHealth < 0 && evilDeck.getDeckSize() > 0) {
                System.out.println("The " + currentEnemy + " was defeated!\n");
                discardPile.addCard(currentEnemy);
                currentEnemy = evilDeck.drawCard();
                
            System.out.println("Press ENTER to continue");
            scan.nextLine();
            
            System.out.print("\033[H\033[2J");
            System.out.flush();

                switch (currentEnemy.getValue()) {
                    case "Jack":
                        enemyHealth = 20;
                        enemyAttack = 10;
                        break;
                    case "Queen":
                        enemyHealth = 30;
                        enemyAttack = 15;
                        break;
                    case "King":
                        enemyHealth = 40;
                        enemyAttack = 20;
                        break;
                }                                               
            } else if (enemyHealth == 0) {
                System.out.println("Perfect Damage! The " + currentEnemy + " was defeated!\n");
                deck.addCardToTop(currentEnemy);
                currentEnemy = evilDeck.drawCard();
                
            System.out.println("Press ENTER to continue");
            scan.nextLine();
            
            System.out.print("\033[H\033[2J");
            System.out.flush();

                switch (currentEnemy.getValue()) {
                    case "Jack":
                        enemyHealth = 20;
                        enemyAttack = 10;
                        break;
                    case "Queen":
                        enemyHealth = 30;
                        enemyAttack = 15;
                        break;
                    case "King":
                        enemyHealth = 40;
                        enemyAttack = 20;
                        break;
                }
            }
        } // while loop
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        if(gameOver){
            System.out.println("You died");
        } else {
            if(lives == MAX_LIVES){
                System.out.println("HOW");
            } else if (lives == 2){
                System.out.println("good job");
            } else if (lives == 1){
                System.out.println("you win");
            } else if (STUDY_MODE){
                System.out.println("You should be studying!!!!!");
            } else {
                System.out.println();
            }
        }
    }
}
