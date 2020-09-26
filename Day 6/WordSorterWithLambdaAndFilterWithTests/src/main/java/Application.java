import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the word order (asc/desc)");
        String sortingType = new Scanner(System.in).nextLine();

        System.out.println("Enter the minimum length of the words:");
        int minWordLength = new Scanner(System.in).nextInt();

        System.out.println("Enter the maximum length of the words:");
        int maxWordLength = new Scanner(System.in).nextInt();

        Set<String> words = findUniqueWords(new File("file.txt"));

        sortAndFilterWords(words, sortingType, minWordLength, maxWordLength).forEach(System.out::println);
    }

    public static Set<String> sortAndFilterWords(Set<String> words, String sortingType, int minWordLength,
                                                 int maxWordLength) {

        Comparator<String> comparator = chooseComparator(sortingType);

        return words.stream().sorted(comparator).filter(word -> minWordLength == 0 ? true : word.length() >= minWordLength)
                .filter(word -> maxWordLength == 0 ? true : word.length() <= maxWordLength)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }


    public static Comparator<String> chooseComparator(String sortingType) {
        Comparator<String> comparator;
        if (sortingType.equalsIgnoreCase("asc")) {
            comparator = (o1, o2) -> o1.length() - o2.length();
        } else if (sortingType.equalsIgnoreCase("desc")) {
            comparator = (o1, o2) -> o2.length() - o1.length();
        } else {
            System.out.println("Type asc or desc.");
            throw new IllegalArgumentException("You should type asc or desc!");
        }
        return comparator;
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
