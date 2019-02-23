/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
/*
Group Members 
Yash Karkar
Dhruv Patel
Kapil Jayswal
Chintan Ganeshwala
*/
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 */
public  class Card 
{   
     public enum Colors {Red, Yellow,Green,Blue};
        public enum Ranks{ZERO,ONE,TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,SKIP, REVERSE, DRAWTWO,DRAWFOUR,WILDCARD };
        private final Colors colour;
        private final Ranks rank;
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    /*
        We have taken the reference from the inclass assignment of uno game.
        Source Inclass Assigement ICE02
        */
     public Card(Colors s, Ranks gVal)
        {
           colour =s;
           rank = gVal;
        }
	public Ranks getValue() {
		return this.rank;
	}

	
	public Colors  getColors() {
		return this.colour;
        }
}
