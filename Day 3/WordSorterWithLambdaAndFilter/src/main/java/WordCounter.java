import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class WordCounter {

    public static HashMap<String, Integer> wordCounter(File file) throws IOException {
        String text = FileUtils.readFileToString(file, "UTF-8");
        text = text.toLowerCase();
        String clearText = text.replaceAll("[^a-zA-Z ]", "");
        String[] words = clearText.split(" ");

        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        return wordCountMap;
    }

    public static void printMap(HashMap<String, Integer> map) {
        System.out.println("word: count");
        for (String word : map.keySet()) {
            System.out.println(word + ": " + map.get(word));
        }
    }
}