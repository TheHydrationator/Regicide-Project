# Regicide

A console-based version of a card game called Regicide built when I first began learning Java. This acted as my first major Java project to help me apply the skills I had learned. 

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
- A designated study mode that removes the player's ability to play the game (this game shouldn't be too distracting!)

## Program Structure

There are only three main classes:
- `Deck.java`
    - Handles the creation, shuffling, sorting, and other modifications to decks.
- `Card.java`
    - Represents the values and suits of specific cards, as well as its face-card status.
- `Regicide.java`
    - Handles the gameplay loop (card combinations, player and enemy hands, general combat)
