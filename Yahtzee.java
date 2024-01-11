
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
        int[] counts = new int[6];
        for (Die6 die: dArray) {
            counts[die.getValue() -1]++;
        }
        StringBuilder summary = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            summary.append((i + 1) + "-" + counts[i]);
             if (i < counts.length - 1) {    //to store correctly
                summary.append("; ");
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



