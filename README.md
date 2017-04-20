# BLACKJACK
Command Line Blackjack Game

## Sample Output
![Blackjack Demo](Blackjack.gif)

## Sample Code

## About this Project
### Origin
In one of my classes I was given the option to either refactor a piece of exsiting code or write a program from scratch.  I chose the latter and thought it would be fun to write a Blackjack game.

### Installation
Currently, the only way to get this code is to clone this repository.
```
$ git clone https://github.com/rossweinstein/Blackjack
```
### How The Game Words
If you are unfamiliar with blackjack, read [this](https://en.wikipedia.org/wiki/Blackjack) first.
  
For my game, the player starts out with a balance of $100.  They can bet before each hand and double down if their initial deal is 11 (and they have enough money to place that bet).  As they play, their stats will be recorded (games, wins, losses, etc.).  If they lose all their money, they will be prompted to reset their stats and their balance returns to $100.

### Testing
I used JUnit to test all my code in this project.  Those tests can be seen [here]().

### Future Improvements
1. Give the player the opportunity to select how many decks they want to play with.  Currrently, they can only play with one.
1. Give the player the opportunity to split their hand.  At the moment they can only double down.
1. Give the player the opportunity for insurance if they dealer's initial hand shows an ace.

## Resources
I used no outside resources for this project.

## License
[MIT License](https://en.wikipedia.org/wiki/MIT_License)
