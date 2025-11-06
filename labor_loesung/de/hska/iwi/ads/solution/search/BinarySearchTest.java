package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTest extends SearchTest {
    @Override
    public <E extends Comparable<E>> BinarySearch<E> createSearch() {
        return new BinarySearch<>();
    }

    @Test
    void custom_sanity0() {
        BinarySearch<Integer> search = createSearch();
        Integer [] a = {0, 1, 1, 2, 3, 4};

        assertEquals(5, search.search(a, 4));
        int a_length = ((int)(Math.log(a.length) / Math.log(2)));
        if ((Math.log(a.length) / Math.log(2)) > a_length) a_length++;  // Immer Aufrunden.
        boolean complexity = (search.getIterations() <= a_length);
        assertTrue(complexity);
    }

    @Test
    void custom_sanity1() {
        BinarySearch<Integer> search = createSearch();
        Integer [] a = {0, 1, 1, 2, 3, 4};

        assertEquals(0, search.search(a, 0));
        int a_length = ((int)(Math.log(a.length) / Math.log(2)));
        if ((Math.log(a.length) / Math.log(2)) > a_length) a_length++;
        boolean complexity = (search.getIterations() <= a_length);
        assertTrue(complexity);
    }

    @Test
    void test_tiny() {
        BinarySearch<Integer> search = createSearch();
        Integer [] a = {0, 1};

        assertEquals(0, search.search(a, 0));
        int a_length = ((int)(Math.log(a.length) / Math.log(2)));
        if ((Math.log(a.length) / Math.log(2)) > a_length) a_length++;
        boolean complexity = (search.getIterations() <= a_length);
        assertTrue(complexity);
    }

    @Test
    void test_long(){
        BinarySearch<Integer> search = createSearch();

        Integer [] a = {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
        assertEquals(8, search.search(a, 1));
        int a_length = ((int)(Math.log(a.length) / Math.log(2)));
        if ((Math.log(a.length) / Math.log(2)) > a_length) a_length++;
        boolean complexity = (search.getIterations() <= a_length);
        assertTrue(complexity);
    }
    @Test
    void test_long1(){
        BinarySearch<Integer> search = createSearch();

        Integer [] a = {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
        assertEquals(0, search.search(a, 0));
        int a_length = ((int)(Math.log(a.length) / Math.log(2)));
        if ((Math.log(a.length) / Math.log(2)) > a_length) a_length++;
        boolean complexity = (search.getIterations() <= a_length);
        assertTrue(complexity);
    }
}
