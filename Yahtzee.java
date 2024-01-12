
/**
 * Write a description of class yahtzee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;

public class Yahtzee
{
    private Die6[] dArray = {
        new Die6(),
        new Die6(),
        new Die6(),
        new Die6(),
        new Die6(),
    };
    public Yahtzee() {
        
    }   
    public void roll() {
            for (int i = 0; i < dArray.length; i++) {
             dArray[i].roll();
            }
    }
    
    public void roll(int dieNumber) { 
        if (dieNumber >= 1 && dieNumber <= 5) {
            dArray[dieNumber-1].roll();  //array indices start from 0 
        } else {
            System.out.println("Choose a number between 1 and 5");
        } 
    }

    public String summarize() {    
        int[] counts = new int[6]; //counts:array length 6
        for (Die6 die: dArray) {  //counts frequency of each die valie
            counts[die.getValue() -1]++;  //-1 to match array index(0-5)
        }
        StringBuilder summary = new StringBuilder(); //mutable string, can be changed w/o creating new object, mods
        for (int i = 0; i < counts.length; i++) {
            summary.append((i + 1) + "-" + counts[i]);  //+1 to match values of dice( displays values 1-6)
             if (i < counts.length - 1) {   
                summary.append("; ");  //append:adds data/characters, not last one(i=5)
            }
        }
        return summary.toString();
    }
    
    public String toString() {
        int[] values = new int[dArray.length];
        int i = 0;
        for (Die6 die : dArray) { //iterates over all dice in array
            values[i++] = die.getValue();
        }
        return "Dice values: " + Arrays.toString(values).replaceAll("[\\[\\],]","");
    }
}



