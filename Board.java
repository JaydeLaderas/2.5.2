/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board() {
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue();

    System.out.println("Phrase: " + phrase); //temp test code
  }
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  
/*Author:
*/
  public boolean guessLetter(String guess)
  {
// The letter is not found at initialization.
    boolean foundLetter = false; 
// The phrase is not solved yet at initialization.
    String newSolvedPhrase = "";
    //Loops for each letter of the word.
    for (int i = 0; i < phrase.length(); i++)
    {
	//Active if letter is found in phrase
      if (phrase.substring(i, i + 1).equals(guess))
      {
	//
	// adds guessed letter to the current guessed phrase
        newSolvedPhrase += guess + " ";
	// indicates that a letter has been found
        foundLetter = true;
      }
      else
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    solvedPhrase = newSolvedPhrase;
    return foundLetter;
  } 
} 
