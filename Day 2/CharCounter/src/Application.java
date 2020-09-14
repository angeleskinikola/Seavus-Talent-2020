import java.util.HashMap;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Write something:");
        String sentence = (new Scanner(System.in)).nextLine();
        char[] chars = sentence.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println("Character: appearance ");
        for (Character c : map.keySet()) {
            System.out.println(c + ": " + map.get(c));
        }
    }
}
