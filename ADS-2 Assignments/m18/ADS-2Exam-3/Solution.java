import java.util.Scanner;
import java.util.TreeSet;


public class Solution {

	// Don't modify this method.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();

		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String each : t9.getAllWords(prefix)) {
					System.out.println(each);
				}
			}
			break;

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		default:
			break;

		}
	}

	// Don't modify this method.
	public static String[] toReadFile(String file) {
		In in = new In(file);
		return in.readAllStrings();
	}

	public static BinarySearchST<String, Integer> loadDictionary(String file) {
		   BinarySearchST<String, Integer>  st
      = new BinarySearchST<String, Integer>();
    String[] files = toReadFile(file);
    for (String word : files) {
      word = word.toLowerCase();
      if (!st.contains(word)) {
        st.put(word, 1);
      } else {
        st.put(word, st.get(word) + 1);
      }
    }
    return st;
  }

}


class T9 {
TST<Integer> tst;
	public T9(BinarySearchST<String, Integer> st) {
		// your code goes here
		tst = new TST();
		for (String word : st.keys()) {
			tst.put(word, st.get(word));
		}

	}

	// get all the prefixes that match with given prefix.
	public Iterable<String> getAllWords(String prefix) {
		// your code goes here
		return tst.keysWithPrefix(prefix);
	}

	public Iterable<String> potentialWords(String t9Signature) {
		// your code goes here
		TreeSet<String> out = new TreeSet<>();
		for (String input : tst.keys()) {
			String[] tokens = input.split("");
			String check = "";
			for (String letter: tokens) {
				if (letter.equals("a") || letter.equals("b") || letter.equals("c")) {
					check += "2";
				} else if (letter.equals("d") || letter.equals("e") || letter.equals("f")) {
					check += "3";
				} else if (letter.equals("g") || letter.equals("h") || letter.equals("i")) {
					check += "4";
				} else if (letter.equals("j") || letter.equals("k") || letter.equals("l")) {
					check += "5";
				} else if (letter.equals("m") || letter.equals("n") || letter.equals("o")) {
					check += "6";
				} else if (letter.equals("p") || letter.equals("q") || letter.equals("r") || letter.equals("s")) {
					check += "7";
				} else if (letter.equals("t") || letter.equals("u") || letter.equals("v")) {
					check += "8";
				} else if (letter.equals("w") || letter.equals("x") || letter.equals("y") || letter.equals("z")) {
					check += "9";
				}
			}
			if (check.equals(t9Signature)) {
				out.add(input);
			}
		}
		return out;
	}

	// return all possibilities(words), find top k with highest frequency.
	public Iterable<String> getSuggestions(Iterable<String> words, int k) {
		// your code goes here
		TreeSet<String> out = new TreeSet<>();
		MaxPQ<Integer> mpq = new MaxPQ<>();
		 for (String eachword : words) {
		 	mpq.insert(tst.get(eachword));
		 	}
		 for (int i = 0; i < k; i++) {
		 	int a = mpq.delMax();
		 		for (String eachword : words) {
		 			if (a == tst.get(eachword)) {
		 				out.add(eachword);
		 			}
		 		}
		 }
		return out;
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(String t9Signature, int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}
