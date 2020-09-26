import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

class ApplicationTest {

    private Set<String> words;

    @BeforeEach
    void setUp() {
        words = new LinkedHashSet<>();
        words.add("abc");
        words.add("c");
        words.add("abcd");
        words.add("bc");
    }

    @Test
    void sortAndFilterWords_ascSortingType() {
        Set<String> result = Application.sortAndFilterWords(words, "asc", 1, 4);

        Set<String> expectedWordsOrder = new LinkedHashSet<>();
        expectedWordsOrder.add("c");
        expectedWordsOrder.add("bc");
        expectedWordsOrder.add("abc");
        expectedWordsOrder.add("abcd");

        Assertions.assertIterableEquals(expectedWordsOrder, result);
    }

    @Test
    void sortAndFilterWords_descSortingType() {
        Set<String> result = Application.sortAndFilterWords(words, "desc", 1, 4);

        Set<String> expectedWordsOrder = new LinkedHashSet<>();
        expectedWordsOrder.add("abcd");
        expectedWordsOrder.add("abc");
        expectedWordsOrder.add("bc");
        expectedWordsOrder.add("c");

        Assertions.assertIterableEquals(expectedWordsOrder, result);
    }

    @Test
    void sortAndFilterWords_invalidSortingType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Application
                .sortAndFilterWords(words, "up", 1, 4), "You should type asc or desc!");
    }

    @Test
    void sortAndFilterWords_notRestrictedWordLength() {
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
        Set<String> result = Application.sortAndFilterWords(words, "asc", 0, 3);

        Set<String> expectedWordsOrder = new LinkedHashSet<>();
        expectedWordsOrder.add("c");
        expectedWordsOrder.add("bc");
        expectedWordsOrder.add("abc");

        Assertions.assertIterableEquals(expectedWordsOrder, result);
    }

    @Test
    void sortAndFilterWords_restrictedMinWordLength() {
        Set<String> result = Application.sortAndFilterWords(words, "asc", 2, 0);

        Set<String> expectedWordsOrder = new LinkedHashSet<>();
        expectedWordsOrder.add("bc");
        expectedWordsOrder.add("abc");
        expectedWordsOrder.add("abcd");

        Assertions.assertIterableEquals(expectedWordsOrder, result);
    }

    @Test
    void sortAndFilterWords_restrictedMinMaxWordLength() {
        Set<String> result = Application.sortAndFilterWords(words, "asc", 2, 3);

        Set<String> expectedWordsOrder = new LinkedHashSet<>();
        expectedWordsOrder.add("bc");
        expectedWordsOrder.add("abc");

        Assertions.assertIterableEquals(expectedWordsOrder, result);
    }
}