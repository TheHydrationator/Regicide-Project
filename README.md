# Regicide

A console-based version of a card game called Regicide built when I first began learning Java. This acted as a first project to help me apply the Java skills I had learned (which, looking back at the code, were not a lot of skills)

This program uses `Card` and `Deck` classes to manage the player's hand, the discard pile, and enemies. `Regicide.java` handles the main gameplay loop which involves suit abilities, drawing cards, and combat.

## Features

- Card and Deck management
-  Deck shuffling
-  Player and enemy decks
-  Player hand management and card drawing
-  Card combinations and damage calculations
    - Spades: Reduces enemy attack
    - Hearts: Recover cards from the discard pile
    - Clubs: Doubles damage dealt
    - Diamonds: Draw cards from draw pile
- Card abbreviation interpretation
- Enemy progression (Jacks, Queens, Kings)
- Health and attack tracking
- Multiple lives and game over conditions
- A designated study mode that removes the player's ability to play (this game shouldn't be too distracting!)
