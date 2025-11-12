package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

public class ReverseMergesort<E extends Comparable<E>> extends AbstractMergesort<E> {

    public E[] getB() {
        return this.b;
    }

    @Override
    public void sort(E [] a) {
        b = a.clone();
        mergesort(a, 0, a.length - 1);
    }

    @Override
    protected void mergesort(E[] a, int left, int right) {
        if (left < right){
            int m = (left + right) / 2;
            mergesort(a, left, m);
            mergesort(a, m + 1, right);
            merge(a, left, m, right);
        }
    }

    protected void merge(E[] a, int left, int m, int right){
        ReverseArray<E> r = new ReverseArray<E>();
        // 1. reverse right half (second half)
        if (m + 1 <= right) {   // only |sub-array| > 1 need to be reversed
            r.reverse(a, m + 1, right);
        }

        // Temporary Variables
        int _left = left;
        int _right = right;

        for (int i = left; i <= right; i++) {
            // If current left (_left) is smaller than current right...
            // AND we are currently in boundaries -> hence we are in-/decrementing without further checks
            if (_left <= m && (_right < m + 1 || a[_left].compareTo(a[_right]) <= 0)) {
                b[i] = a[_left];
                _left++;
            } else {
                // else (right > left)
                b[i] = a[_right];
                _right--;
            }
        }
        // a := b
        for (int i = left; i <= right; i++) {
            a[i] = b[i];
        }
    }
}