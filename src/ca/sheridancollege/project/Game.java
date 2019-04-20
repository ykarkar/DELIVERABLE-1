/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * @Modifier Chintan Ganeshwala, Dhruv Patel , Kapil Jayswal, Yash Karkar
 * @date 20/04/2019
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 */
public  class Game 
{
    private  Scanner sc;
    private Card current; 
    private GroupOfCards deck; 
    private  ArrayList<Card> cpile; 
     
    private  Player p1,p2; 
    private int pi;
    private int penalty;
    public Game() 
    {
         p1 = new Player("Player1");
        p2 = new Player("Player2");
        deck = new GroupOfCards();
        deck.shuffle();
        sc = new Scanner(System.in);
        current = getStartingCard();
        cpile = new ArrayList<>();
        cpile.add(current);
        distribute();
    }
    
     private void distribute()
    {
        for (int i = 0; i < 10; i++)
        {
            if (i % 2 == 0)
            {
                p1.pickCards(deck.getTopCard());
            }
            else
            {
                p2.pickCards(deck.getTopCard());
            }
        }
    }
    
   public void game() 
    {
        int turn = 0;
        while (!gameOver(p1, p2)) 
        {
            if (turn % 2 == 0)
            {
                playGame(p1);
            }
            else
            {
                playGame(p2);
            }
            turn++;
        }
    }
    public void playGame(Player p)
    {
        System.out.println(p + ", It is your turn , The current card on play is: \n" + current);
        showcard(p);
        if (current.isSpecial()) 
        {
            penalty += current.getValue();
            Card pick;
            if (!canOverride(p))
            {
                System.out.println("You can not override the current special card, so you are penalised");
                for (int i = 0; i < penalty; i++) 
                {
                    if (deck.isEmpty())
                    {
                        deck = new GroupOfCards(cpile);
                    }
                    pick = deck.getTopCard();
                    p.pickCards(pick);
                    System.out.println("You picked: \n" + pick);
                    pause();
                }
                penalty = 0;
                current = deck.getTopCard();
                System.out.println("The new current card is: \n" + current);
            }
        }
        if (!col(p) && !Value(p) && !Special(p)) 
        {
            Card pick1 = null;
            System.out.println(" you have to pick cards.");
            while (!col(p) && !Value(p) && !Special(p))
            {
                pause();
                pick1 = deck.getTopCard();
                p.pickCards(pick1);
                System.out.println("You picked:\n" + pick1);
                
            }
            System.out.println("You recieved a valid card!");
            pause();
            System.out.println("You have the following cards: ");
            p.display();
        }
        System.out.println("Please enter a card number:");
        pi = sc.nextInt() - 1;
        while (!isValidChoice(p, pi))
        {
            System.out.println("Invalid pick. Please pick a valid card.");
            pi = sc.nextInt() - 1;
        }
        Card play = p.throwCard(pi);
        p.sayUno();
        current = play;
        cpile.add(current);
    }
    private boolean Special(Player p)
    {
        return p.PlayerCards().stream().anyMatch((c) -> (c.isSpecial()));
       
    }
    private boolean isValidChoice(Player pl, int choice)
    {
        if(choice <= pl.PlayerCards().size())
        {
            if(pl.PlayerCards().get(choice).getColor().equals(current.getColor()) || pl.PlayerCards().get(choice).getValue() == current.getValue() || pl.PlayerCards().get(choice).isSpecial()) 
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean col(Player p)
    {
        return p.PlayerCards().stream().anyMatch((c) -> (c.getColor().equals(current.getColor())));
    }
    private boolean Value(Player p)
    {
        return p.PlayerCards().stream().anyMatch((c) -> (c.getValue() == current.getValue()));
    }
    private boolean canOverride(Player p) 
    {
        return p.PlayerCards().stream().filter((c) -> (c.isSpecial())).anyMatch((c) -> (c.getValue() >= current.getValue()));
    }
    private Card getStartingCard()
    {
        Card temp = deck.peek();
        while (temp.isSpecial())
        {
            deck.shuffle();
            temp = deck.peek();
        }
        temp = deck.getTopCard();
        return temp;
    }

    public boolean gameOver(Player p1, Player p2)
    {
        if (p1.Win())
        {   
            System.out.println("Player 1 win the game");
            return true;
        }
        else if (p2.Win()) 
        {
            System.out.println("Player 2 win the game");
             return true;
        }
        return false;
    }
    /**
     * this method is use for to show player to shoe it's own card when it turn come 
     */
    public void showcard(Player p) 
    {
        if (p.toString().equals("Player1")) 
        {
            System.out.println("Player-1:");
                p1.display();
        } 
        else
        {
            System.out.println("Player-2:");
                p2.display();
        }
    }

    private void pause() 
    {
        System.out.println("Press enter to continue");
        sc.nextLine();
    }
   
    
}//end class
