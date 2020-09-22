import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) throws IOException {
        ArrayList<String> words = wordCounter(new File("file.txt"));

        System.out.println("Enter the word order(asc/desc)");
        String answer = new Scanner(System.in).nextLine();
        if (answer.equalsIgnoreCase("asc")) {
            Collections.sort(words, (o1, o2) -> o1.length() - o2.length());
        } else if (answer.equalsIgnoreCase("desc")) {
            Collections.sort(words, (o1, o2) -> o2.length() - o1.length());
        }

        System.out.println("Do you want to specify the minimum and maximum length of the words? y/n");
        String yesOrNo = new Scanner(System.in).nextLine();
        if (yesOrNo.equalsIgnoreCase("y")) {
            System.out.println("Enter the minimum length of the words:");
            int min = new Scanner(System.in).nextInt();
            System.out.println("Enter the maximum length of the words:");
            int maxInput = new Scanner(System.in).nextInt();
            int max = maxInput == 0 ? Integer.MAX_VALUE : maxInput;

            if (max >= min) {
                Stream<String> wordsStream = words.stream();
                wordsStream.filter(word -> word.length() >= min && word.length() <= max)
                        .forEach(word -> System.out.println(word));
            } else {
                System.out.println("maximum should be greater or equal to minimum");
            }
        } else {
            words.forEach(word -> System.out.println(word));
        }

    }

    public static ArrayList<String> wordCounter(File file) throws IOException {
        String text = FileUtils.readFileToString(file, "UTF-8");
        text = text.toLowerCase();
        String clearText = text.replaceAll("[^a-zA-Z ]", "");
        String[] words = clearText.split(" ");

        ArrayList<String> wordsList = new ArrayList<>();
        for (String word : words) {
            if (!wordsList.contains(word)) {
                wordsList.add(word);
            }
        }
        return wordsList;
    }
}
