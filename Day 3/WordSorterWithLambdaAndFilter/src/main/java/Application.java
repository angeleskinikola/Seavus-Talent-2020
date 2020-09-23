import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the word order (asc/desc)");
        String answer = new Scanner(System.in).nextLine();

        System.out.println("Enter the minimum length of the words:");
        int min = new Scanner(System.in).nextInt();

        System.out.println("Enter the maximum length of the words:");
        int max = new Scanner(System.in).nextInt();


        Comparator<String> comparator;
        if (answer.equalsIgnoreCase("asc")) {
            comparator = (o1, o2) -> o1.length() - o2.length();
        } else if (answer.equalsIgnoreCase("desc")) {
            comparator = (o1, o2) -> o2.length() - o1.length();
        } else {
            System.out.println("Type asc or desc.");
            return;
        }

        Set<String> words = (max == 0 && (min == 0 || min == 1)) ?
                findUniqueWords(new File("file.txt")) :
                findUniqueWords(new File("file.txt")).stream()
                .filter(word -> word.length() >= min && word.length() <= max)
                .collect(Collectors.toSet());

        words.stream().sorted(comparator)
                .forEach(System.out::println);

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
