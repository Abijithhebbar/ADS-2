import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
/**
 * Class for spell checker.
 */
public class BlackFilterClient {
    public static void main(String[] args) {
    	// reading the dictionary file.
        In in = new In("/Files/Dictionary.txt");
        // Read all strings (separated by whitespace) until the end of input is reached,
        // and return them as an array of strings.
        String[] dict = in.readAllStrings();
        // using the toString method so that we get the strings instead of hashvalues.
        String asString = Arrays.toString(dict);
        //  asString = asString.replaceAll("[^a-zA-Z0-9 ]", "");
        // asString = asString.replaceAll(" ", ", ");
        // converting all the characters to lower case and spliting them so that a
        // String array is formed.
        dict = asString.toLowerCase().split(", ");
        // Creating an object for the Stopwatch class to get the time elapsed by the method.
        Stopwatch time = new Stopwatch();
        // String which stores the wrong words spelt.
        //StringBuilder wrongwords = new StringBuilder();
        String wrongwords = "";
        // Scans the input from the console.
        // TrieST or TST should be the input.
        Scanner scan = new Scanner(System.in);
        // input is stored in this string.
        String s = scan.nextLine();
        // Checking if the given input is TrieST.
        // if the input is TrieST it goes to this method.
        if (s.equals("TrieST")) {
        	// Initializing the TrieST with the constructor.
            TrieST<String> dictionary = new TrieST<String>();
            // Adding the dictionary words in the TrieST.
            for (String word : dict) {
                dictionary.put(word, word);
            }
            // Reading the war.txt file.
            In i = new In("/Files/war.txt");
            // Read all strings (separated by whitespace) until the end of input is reached,
            // and return them as an array of strings.
            String[] text = i.readAllStrings();
            // using the toString method so that we get the strings instead of hashvalues.
            String aString = Arrays.toString(text);
            // cleaning the words.
            aString = aString.replaceAll("[^a-zA-Z0-9 ]", "");
            // replacing space with the comma space so that we can split the strings.
            aString = aString.replaceAll(" ", ", ");
            // converting all the characters to lower case and spliting them so that a
            // String array is formed.
            text = aString.toLowerCase().split(", ");
            // Checking the size of the String if it is a single alphabet or not.
            // And also checking if the word is available in the dictionary.txt.
            for (String word : text) {
                if (!dictionary.contains(word)  && word.length() != 1) {
                	// If the word is not present in the dictionary.
                	// The words are added to the String.
                	// which in turn are added to the output.txt file.
                    //wrongwords.append(word + "\n");
                    wrongwords += word + "\n";
                }
            }

        }
        // Checking if the given input is TST.
        // If the input is TST then it goes into the this method.
        else if (s.equals("TST")) {
        	// Initializing the TST with the constructor.
			TST<String> dictionary = new TST<String>();
            // Adding the dictionary words in the TST.
            for (String word : dict) {
                dictionary.put(word, word);
            }
            // Reading the war.txt file.
            In i = new In("/Files/war.txt");
            // Read all strings (separated by whitespace) until the end of input is reached,
            // and return them as an array of strings.
            String[] text = i.readAllStrings();
            // using the toString method so that we get the strings instead of hashvalues.
            String string = Arrays.toString(text);
            // cleaning the words.
            string = string.replaceAll("[^a-zA-Z0-9 ]", "");
            // replacing space with the comma space so that we can split the strings.
            string = string.replaceAll(" ", ", ");
            // converting all the characters to lower case and spliting them so that a
            // String array is formed.
            text = string.toLowerCase().split(", ");
            // Checking the size of the String if it is a single alphabet or not.
            // And also checking if the word is available in the dictionary.txt.
            for (String word : text) {
                if (word.length() > 1) {
                    if (!dictionary.contains(word)) {
                    // If the word is not present in the dictionary.
                	// The words are added to the String.
                	// which in turn are added to the output.txt file.
                    // wrongwords.append(word + "\n")
                        wrongwords += word + "\n";
                    }
                }
            }

        }
        // If the input is other than TrieSt or TST.
        else {
            System.out.println("wrong input");
        }
        // Used to print the values to the output.txt file.
        try {
            PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
            out.println(wrongwords);
            out.close();
        } catch(Exception e) {

        }
        // It gives the time elapsed.
        System.out.println(time.elapsedTime());
    }
}
