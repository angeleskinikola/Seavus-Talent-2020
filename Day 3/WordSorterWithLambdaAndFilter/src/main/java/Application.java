import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) throws IOException {
        ArrayList<String> words = mapKeysToArrList(WordCounter.wordCounter(new File("file.txt")));

        System.out.println("Enter the word order(asc/desc)");
        String answer = new Scanner(System.in).nextLine();
        System.out.println("Enter the minimum length of the words:");
        int min = new Scanner(System.in).nextInt();
        System.out.println("Enter the maximum length of the words:");
        int maxInput = new Scanner(System.in).nextInt();
        int max = maxInput == 0 ? Integer.MAX_VALUE : maxInput;

        if (max >= min) {
            if (answer.equalsIgnoreCase("asc")) {
                Collections.sort(words, (o1, o2) -> o1.length() - o2.length());
            } else if (answer.equalsIgnoreCase("desc")) {
                Collections.sort(words, (o1, o2) -> o2.length() - o1.length());
            }

            Stream<String> wordsStream = words.stream();
            wordsStream.filter(word -> word.length() >= min && word.length() <= max)
                    .forEach(word -> System.out.println(word));
        } else {
            System.out.println("maximum should be greater or equal to minimum");
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
