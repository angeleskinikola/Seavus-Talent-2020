import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        ArrayList<String> words = mapKeysToArrList(WordCounter.wordCounter(new File("file.txt")));

        System.out.println("Enter the word order(asc/desc)");
        String answer = new Scanner(System.in).nextLine();

        if (answer.equalsIgnoreCase("asc")) {
            Collections.sort(words, new AscendingLengthStringComparator());
            printList(words);
        } else if (answer.equalsIgnoreCase("desc")) {
            Collections.sort(words, new DescendingLengthStringComparator());
            printList(words);
        } else {
            System.out.println("You should type ascending or descending!");
        }
    }

    public static void printList(ArrayList<String> list) {
        for (String word : list) {
            System.out.println(word);
        }
    }

    public static ArrayList<String> mapKeysToArrList(HashMap<String, Integer> map) {
        ArrayList<String> words = new ArrayList();
        for (String word : map.keySet()) {
            words.add(word);
        }

        return words;
    }
}

