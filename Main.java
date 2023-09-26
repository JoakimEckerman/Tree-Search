/**
 * Group 6 - Sec 03 5022
 * Jarrod Amyx - 014770897
 * Joakim Eckerman - 028731311
 * Justin - 027438097
 * 4/12/2022
 * This program takes a list of words and counts how many times
 * that they occur. We can search for a specific word or 
 * display all of the words in the list.
 * This was split up evenly each of us doing different parts of each section.
 */
import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {
    TreeMap<String, Integer> map = readFile(); // Create Tree map
    int input = 0; // set input
    while(input != 3){
      input = menu(); // Get user's choice
      switch(input){
        case 1:
          search(map); // Search Tree
          break;
        case 2:
          display(map); // Display all keys and values
          break;
        default:
          break;
      }
    }
  }

/** Reads the words.txt file and counts how often
  * the word appears in the file.
  * @return Returns a tree map of the words
  * and the frequency that they appear
  */
  public static TreeMap<String, Integer> readFile() {
    TreeMap<String, Integer> map = new TreeMap<String, Integer>();
    // try to open and extra information from files.
    try{
      File file = new File("words.txt"); // Create file object
      Scanner read = new Scanner( file ); // Open words to be read
      // Read through each line of txt.
      while( read.hasNextLine() ) {
        String data = read.nextLine();
        // If word is in key
        if(map.containsKey(data)){
          map.put(data, map.get(data) + 1 ); // Increment value
        }
        else{
          map.put(data, 1); // Add key and set to one
        }
      }
      read.close();
      return map;
    }
    // if file not found, catch
    catch (FileNotFoundException e) {
      System.out.println("An error occurred. File could not be found");
      e.printStackTrace();
      System.exit(0);
    }
    return map;
  }

/** search - Searches for a word in the file
  * if it exists, displays the word and their frequency.
  * @param map - the TreeMap of all the words in the file.
  */
  public static void search(TreeMap<String, Integer> map) {
    int frequency;
    String word;
    System.out.print("Enter word: ");
    word = CheckInput.getString();
    // sets frequency to the times the word appears in the map
    frequency = (map.containsKey(word)) ? map.get(word): 0;
    // displays the word and it's frequency in desired format
    System.out.println(word + " => " + frequency);
  }

/** display - displays all the words in the document
  * and their frequencies.
  * @param map - the TreeMap of all the words in the file.
  */
  public static void display(TreeMap<String, Integer> map) {
    // Loops through tree map values
    for (Map.Entry<String, Integer> entry : map.entrySet())
        System.out.println(entry.getKey()+ " => " + entry.getValue()); // Display Tree map key and value
  }

/** menu - displays the users options and returns the input
  * @return input - the option the user chooses.
  */
  public static int menu(){
    int input;
    System.out.println("1. Search \n2. Display \n3. Quit");
    input = CheckInput.getIntRange(1,3); // get value 1-3
    return input;
  }
}