package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

public class Mergesort<E extends Comparable<E>> extends AbstractMergesort<E> {

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
        int _left = left;
        int _right = m + 1;
        for (int i = left; i < right; i++ ){
            if(_right > right || (left <= m && (a[_left].compareTo(a[_right]) <= 0))){
                this.b[i] = a[i];
                _left++;
            }
            else{
                b[i] = a[_right];
                _right++;
            }
        }
        for (int i = left; i < right; i++){
            a[i] = b[i];
        }
    }
}