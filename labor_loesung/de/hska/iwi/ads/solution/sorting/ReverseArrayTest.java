package de.hska.iwi.ads.solution.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseArrayTest {

    public <E extends Comparable<E>> ReverseArray<E> createReverse() {
        return new ReverseArray<>();
    }


    @Test
    void custom_0() {
        ReverseArray<Integer> m = this.createReverse();
        Integer a[] = {0,1,2,3};
        Integer sol[] = {3,2,1,0};

        m.reverse(a,0,a.length-1);

        assertArrayEquals(sol,a);
    }


    @Test
    void custom_1() {
        ReverseArray<Integer> m = this.createReverse();
        Integer a[] = {3,2,1,0};
        Integer sol[] = {0,1,2,3};
        m.reverse(a,0,a.length-1);

        assertArrayEquals(sol,a);
    }

    @Test
    void custom_duplicates1() {
        ReverseArray<Integer> m = this.createReverse();
        Integer a[] =   {0,0,1,0};
        Integer sol[] = {0,1,0,0};
        m.reverse(a,0,a.length-1);

        assertArrayEquals(sol,a);
    }

    @Test
    void custom_duplicates2() {
        ReverseArray<Integer> m = this.createReverse();
        Integer a[] =   {0,1,0,0};
        Integer sol[] = {0,0,1,0};
        m.reverse(a,0,a.length-1);

        assertArrayEquals(sol,a);
    }

    @Test
    void custom_invalid1() {
        ReverseArray<Integer> m = this.createReverse();
        Integer a[] =   {};
        Integer sol[] = {};
        m.reverse(a,0,0);

        assertArrayEquals(sol,a);
    }

    @Test
    void custom_invalid2() {
        ReverseArray<Integer> m = this.createReverse();
        Integer a[] = null;
        Integer sol[] = null;

        try{
            m.reverse(a, 0, 0);  // sort() has no exception handling specified
        }
        catch (Exception e){
            assertTrue(false);
            return;
        }
        assertTrue(true);
    }
}
