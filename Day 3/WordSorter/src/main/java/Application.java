import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException {

        System.out.println("Enter the word order(asc/desc)");
        String answer = new Scanner(System.in).nextLine();

        ArrayList<String> wordsArray = new ArrayList<>(findUniqueWords(new File("file.txt")));

        if (answer.equalsIgnoreCase("asc")) {
            Collections.sort(wordsArray, new AscendingLengthStringComparator());
            printList(wordsArray);
        } else if (answer.equalsIgnoreCase("desc")) {
            Collections.sort(wordsArray, new DescendingLengthStringComparator());
            printList(wordsArray);
        } else {
            System.out.println("You should type ascending or descending!");
        }
    }

    public static void printList(ArrayList<String> list) {
        for (String word : list) {
            System.out.println(word);
        }
    }


    public static HashSet<String> findUniqueWords(File file) throws IOException {
        String text = FileUtils.readFileToString(file, "UTF-8");
        text = text.toLowerCase();
        String clearText = text.replaceAll("[^a-zA-Z ]", "");
        String[] words = clearText.split(" ");

        HashSet<String> wordsSet = new HashSet<>();
        wordsSet.addAll(Arrays.asList(words));

        return wordsSet;
    }
}

