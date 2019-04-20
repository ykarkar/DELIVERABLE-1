/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 * @Modifier Chintan Ganeshwala, Dhruv Patel , Kapil Jayswal, Yash Karkar
 * @date 20/04/2019
 */
package ca.sheridancollege.project;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 */
public  class Player 
{
    private final ArrayList<Card> player;
    private final String name; 

    public Player(String name) 
    {
        player = new ArrayList<>();
        this.name = name;
    }
    public ArrayList<Card> PlayerCards()
    {
        return player;
    }
    public int numberCards()
    {
        return player.size();
    }
    public void pickCards(Card c)
    {
        player.add(c);
    }
    public Card throwCard(int cs)
    {
        return player.remove(cs);
    }
    public void sayUno()
    {
        Scanner s = new Scanner(System.in);
        if (player.size() == 1)
        {
            System.out.println("Uno");
            System.out.println("Press Enter...");
            s.nextLine();
        }
    }
    public void display()
    {
        String[] card = {"      ", "        ", "        ", "       "};
        String c = "";
        System.out.println("card array length"+card.length);
        for (int i = 0; i < card.length; i++)
        {
            for (int j = 0; j < player.size(); j++) 
            {
                if (!player.get(j).isSpecial()) 
                {
                    switch (i)
                    {
                        case 1:
                            c = c + "| " + player.get(j).getColor() + " |" + " ";
                            break;
                        case 2:
                            c = c + "|  " + player.get(j).getValue() + "  |" + " ";
                            break;
                        default:
                            c = c + card[i] + " ";
                            break;
                    }
                }
                else if(player.get(j).isSpecial())
                {
                    if (i == 1)
                    {
                        c = c + "| " + "+" + player.get(j).getValue() + "  |" + " ";
                    }
                    else
                    {
                        c = c + card[i] + " ";
                    }
                }
            }
            c += "\n";
        }
        System.out.print(c);
    }   
    public boolean Win() 
    {
        return player.isEmpty();
    }
    @Override
    public String toString()
    {
        return this.name;
    }
}
