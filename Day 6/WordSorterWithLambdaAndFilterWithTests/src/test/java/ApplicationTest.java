import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

class ApplicationTest {

    @Test
    void sortAndFilterWords_ascSortingType() {
        Set<String> words = new LinkedHashSet<>();
        words.add("abc");
        words.add("c");
        words.add("bc");

        Set<String> result = Application.sortAndFilterWords(words, "asc", 1, 3);

        Set<String> expectedWordsOrder = new LinkedHashSet<>();
        expectedWordsOrder.add("c");
        expectedWordsOrder.add("bc");
        expectedWordsOrder.add("abc");

        Assertions.assertIterableEquals(expectedWordsOrder, result);
    }

    @Test
    void sortAndFilterWords_descSortingType() {
        Set<String> words = new LinkedHashSet<>();
        words.add("abc");
        words.add("c");
        words.add("bc");

        Set<String> result = Application.sortAndFilterWords(words, "desc", 1, 3);

        Set<String> expectedWordsOrder = new LinkedHashSet<>();
        expectedWordsOrder.add("abc");
        expectedWordsOrder.add("bc");
        expectedWordsOrder.add("c");

        Assertions.assertIterableEquals(expectedWordsOrder, result);
    }

    @Test
    void sortAndFilterWords_invalidSortingType() {
        Set<String> words = new LinkedHashSet<>();
        words.add("abc");
        words.add("c");
        words.add("bc");

        Assertions.assertThrows(IllegalArgumentException.class, () -> Application
                .sortAndFilterWords(words, "up", 1, 3), "You should type asc or desc!");
    }

    @Test
    void sortAndFilterWords_notRestrictedWordLength() {
        Set<String> words = new LinkedHashSet<>();
        words.add("abc");
        words.add("c");
        words.add("bc");
        words.add("abcd");

        Set<String> result = Application.sortAndFilterWords(words, "asc", 0, 0);

        Set<String> expectedWordsOrder = new LinkedHashSet<>();
        expectedWordsOrder.add("c");
        expectedWordsOrder.add("bc");
        expectedWordsOrder.add("abc");
        expectedWordsOrder.add("abcd");

        Assertions.assertIterableEquals(expectedWordsOrder, result);
    }

    @Test
    void sortAndFilterWords_restrictedMaxWordLength() {
        Set<String> words = new LinkedHashSet<>();
        words.add("abc");
        words.add("c");
        words.add("bc");
        words.add("abcd");

        Set<String> result = Application.sortAndFilterWords(words, "asc", 0, 3);

        Set<String> expectedWordsOrder = new LinkedHashSet<>();
        expectedWordsOrder.add("c");
        expectedWordsOrder.add("bc");
        expectedWordsOrder.add("abc");

        Assertions.assertIterableEquals(expectedWordsOrder, result);
    }

    @Test
    void sortAndFilterWords_restrictedMinWordLength() {
        Set<String> words = new LinkedHashSet<>();
        words.add("abc");
        words.add("c");
        words.add("bc");
        words.add("abcd");

        Set<String> result = Application.sortAndFilterWords(words, "asc", 2, 0);

        Set<String> expectedWordsOrder = new LinkedHashSet<>();
        expectedWordsOrder.add("bc");
        expectedWordsOrder.add("abc");
        expectedWordsOrder.add("abcd");

        Assertions.assertIterableEquals(expectedWordsOrder, result);
    }

    @Test
    void sortAndFilterWords_restrictedMinMaxWordLength() {
        Set<String> words = new LinkedHashSet<>();
        words.add("abc");
        words.add("c");
        words.add("bc");
        words.add("abcd");

        Set<String> result = Application.sortAndFilterWords(words, "asc", 2, 3);

        Set<String> expectedWordsOrder = new LinkedHashSet<>();
        expectedWordsOrder.add("bc");
        expectedWordsOrder.add("abc");

        Assertions.assertIterableEquals(expectedWordsOrder, result);
    }
}