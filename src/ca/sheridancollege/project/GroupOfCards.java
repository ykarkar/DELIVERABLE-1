/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * @Modifier Chintan Ganeshwala, Dhruv Patel , Kapil Jayswal, Yash Karkar
 * @date 20/04/2019
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards 
{
   
    private ArrayList<Card> card;

    public GroupOfCards() 
    {
        card = new ArrayList<>();
        String[] col = {"RED", "BLUE", "GREEN", "YELLOW"};
        int[] numbers = {1,2,3,4,5,6,7,8,9,10}; 
        int[] special = {2, 2, 4, 4}; 
       
        for(int i=0 ;i<col.length;i++)
        {
            for(int j =0; j<numbers.length;j++)
            {
                card.add(new Card(j,col[i]));
            }
        }
        
        for(int i=0;i<special.length;i++)
        {
            card.add(new Card(i));
        }
    }

    public GroupOfCards(ArrayList<Card> c) 
    {
        card = c;
    }
    public boolean isEmpty()
    {
        return card.size() <= 0;
    }
    
    public Card getTopCard()
    {
        return card.remove(card.size() - 1);
    }

    public Card peek()
    {
        return card.get(card.size() - 1);
    }

    public void shuffle()
    {
        Collections.shuffle(card);
    }
    @Override
    public String toString()
    {
        String deck = "";
        for (Card c : this.card)
        {
            deck = deck + c + " ";
        }
        return deck;
    } 
}//end class
