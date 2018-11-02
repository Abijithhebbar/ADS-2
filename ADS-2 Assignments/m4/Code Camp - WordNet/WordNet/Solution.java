import java.util.Scanner;
class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String synsetFileName = scan.nextLine();
		String hypernymFileName = scan.nextLine();
		String token = scan.nextLine();
		switch(token) {
			case "Graph":
				WordNet wordNetObj = new WordNet(synsetFileName, hypernymFileName);
			break;
			case "Queries":
			break;
			default:
				break;
		}
	}
}