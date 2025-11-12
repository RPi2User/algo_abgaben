package de.hska.iwi.ads.solution.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseMergesortTest {

    public <E extends Comparable<E>> ReverseMergesort<E> createSort() {
        return new ReverseMergesort<>();
    }

    @Test
    void custom0() {
        ReverseMergesort<Integer> m = this.createSort();
        Integer a[] = {0,1,2,3};
        Integer sol[] = {0,1,2,3};
        m.sort(a);

        assertArrayEquals(sol, m.getB());
    }


    @Test
    void custom1() {
        ReverseMergesort<Integer> m = this.createSort();
        Integer a[] = {3,2,1,0};
        Integer sol[] = {0,1,2,3};
        m.sort(a);

        assertArrayEquals(sol, m.getB());
    }

    @Test
    void custom_Small0(){
        ReverseMergesort<Integer> m = this.createSort();
        Integer a[] = {0};
        Integer sol[] = {0};
        m.sort(a);

        assertArrayEquals(sol, m.getB());
    }

    @Test
    void custom_Small1(){
        ReverseMergesort<Integer> m = this.createSort();
        Integer a[] = {1,0};
        Integer sol[] = {0,1};
        m.sort(a);

        assertArrayEquals(sol, m.getB());
    }

    @Test
    void custom_Err0(){
        ReverseMergesort<Integer> m = this.createSort();
        Integer a[] = {0};
        Integer sol[] = {0};
        m.sort(a);

        assertArrayEquals(sol, m.getB());
    }

    @Test
    void custom_Err1(){
        ReverseMergesort<Integer> m = this.createSort();
        Integer a[] = null;

        try {
            m.sort(a); // This shall throw a NullPointerException caused from b := a
        }
        catch (NullPointerException e){
            assertTrue(true);
        }
        catch (Exception e){
            assertTrue(false);
        }
    }

    @Test
    void custom_Err2(){
        ReverseMergesort<Integer> m = this.createSort();
        Integer a[] = {null};
        Integer sol[] = {null};
        m.sort(a);

        assertArrayEquals(sol, m.getB());
    }

    @Test
    void custom_duplicates1() {
        ReverseMergesort<Integer> m = this.createSort();
        Integer a[] = {3,0,0,0};
        Integer sol[] = {0,0,0,3};
        m.sort(a);

        assertArrayEquals(sol, m.getB());
    }

    @Test
    void custom_duplicates2() {
        ReverseMergesort<Integer> m = this.createSort();
        Integer a[] = {0,0,1,0};
        Integer sol[] = {0,0,0,1};
        m.sort(a);

        assertArrayEquals(a, m.getB());
    }

    @Test
    void custom_long1() {
        ReverseMergesort<Integer> m = this.createSort();
        Integer a[] =   {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0};
        Integer sol[] = {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,9};

        m.sort(a);

        assertArrayEquals(sol, m.getB());
    }

    @Test
    void custom_long2() {
        ReverseMergesort<Integer> m = this.createSort();
        Integer a[] =   {9,9,9,9,9,9,9,9,9,9,8,8,8,8,8,8,8,8,8,8,7,7,7,7,7,7,7,7,7,7,6,6,6,6,6,6,6,6,6,6,5,5,5,5,5,5,5,5,5,5,4,4,4,4,4,4,4,4,4,4,3,3,3,3,3,3,3,3,3,3,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0};
        Integer sol[] = {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,9};

        m.sort(a);

        assertArrayEquals(sol, m.getB());
    }
}
