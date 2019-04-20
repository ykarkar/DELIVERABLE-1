/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * @Modifier Chintan Ganeshwala, Dhruv Patel , Kapil Jayswal, Yash Karkar
 * @date 20/04/2019
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
    private String color;
    private int value;
    private int specialValue;
    private boolean special;

    public Card(int val, String co) 
    {
        color = co;
        value = val;
        specialValue = 0;
        special = false;
    }

    public Card(int specialValue) 
    { 
        color = "";
        this.specialValue = specialValue;
        value = 0;
        special = true;
    }

    public String getColor() 
    {
        return this.color;
    }

    public int getValue() 
    {
        if (!this.special)
        {
            return this.value;
        }
        else
        {
            return this.specialValue;
        }
    }

    public String toString() {
        String[] card ={"       ", "        ", "        ", "       "};
        String r = "";
        System.out.println("card size"+card.length);
        for (int i = 0; i < card.length; i++)
        {
            for (int j = 0; j < 1; j++)
            {
                if (!this.isSpecial())
                {
                    if (i == 1)
                    {
                        r = r + "|" + this.getColor() + "|" + " ";
                    }
                    else if (i == 2)
                    {
                        r = r + "|" + this.getValue() + "|" + " ";
                    }
                    else
                    {
                        r = r + card[i] + " ";
                    }
                } 
                else if (this.isSpecial())
                {

                    if (i == 1) 
                    {
                        r = r + "|" + "+" + this.getValue() + "|" + " ";
                    }
                    else
                    {
                        r = r + card[i] + " ";
                    }
                }
            }
            r += "\n";
        }
        return r;
    }
    public boolean isSpecial()
    {
        if (special)
        {
            return true;
        }

        return false;
    }
}