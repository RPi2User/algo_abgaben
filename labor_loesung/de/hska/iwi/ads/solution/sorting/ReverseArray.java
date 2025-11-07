package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {

    /**
     * Dreht die Reihenfolge aller Werten <code>a[from..to]</code>
     * um. Die Bereiche <code>a[0..from-1]</code> und <code>a[to+1..a.length-1]</code>
     * bleiben unver�ndert. Der Bereich muss mindestens einen Wert enthalten.
     * Die Imlementierung muss in-place sein.
     *
     * @param a    Feld, in dem die Werte umgedreht werden sollen
     * @param from Anfangsindex mit 0 <= from < to
     * @param to   Endindex mit from < to <= a.length - 1
     */
    @Override
    public void reverse(E[] a, int from, int to) {
        if ((from - to) == 0 || from >= a.length)   // Input validiation
            return;
        for (int i = 0; i <= ((to - from) / 2); i++) {
            E first = a[from + i];  // save first element
            E last = a[to-i];       // save last element

            a[from+i] = last;
            a[to-i] = first;
        }
    }
}