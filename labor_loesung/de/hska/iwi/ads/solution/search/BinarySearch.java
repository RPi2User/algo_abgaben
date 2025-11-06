package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {
    private int iterations = 0; // Debug Value for Complexity measurements

    public int getIterations() { return this.iterations; }

    /**
     * Searches the lowest index position of <code>key</code> in the
     * sorted array <code>a</code> from <code>a[left]</code> up to <code>a[right]</code>, if key is an element of a.
     * If <code>key</code> does not exists in <code>a</code>, the index <code>i</code> is returned
     * in either of the following cases:
     * <ol>
     *   <li> a[i - 1] < key < a[i] with left < i < right,</li>
     *   <li> i = left - 1 if key < a[left], or</li>
     *   <li> i = right + 1 if a[right] < key</li>
     * </ol>
     *
     * @param a     sorted in ascending order given by the Comparable<E> implementation
     * @param key
     * @param left  start index for the search, 0 <= left <= right
     * @param right end index for the search, 0 <= left <= right < a.length
     * @throws NullPointerException           if a is null
     * @throws ArrayIndexOutOfBoundsException if left or right is not within the index bounds of <code>a</code>
     */
    @Override
    public int search(E[] a, E key, int left, int right) {
        // --- Exception Handling ----------------------------------
        if (a == null) {
            throw new NullPointerException("Array must not be null");
        }
        if (left < 0 || right < 0 || left > right || right >= a.length) {
            throw new ArrayIndexOutOfBoundsException("left/right indices out of bounds or invalid");
        }
        // ---------------------------------------------------------

        int previous_left = left;
        int previous_right = right;

        // Quick checks against endpoints
        if (key.compareTo(a[previous_left]) < 0) {
            return previous_left - 1;
        }
        if (key.compareTo(a[previous_right]) > 0) {
            return previous_right + 1;
        }


        int insertPos = 0;
        int index = ((right - left) / 2) + left; // die MITTE != CVP

        while (left <= right) {
            index = left + (right - left) / 2;  // calc current index

            if (a[index].compareTo(key) < 0) {  // if a[i] < key
                left = index + 1;               // we are currently too low, so we need to 1up our lower boundary
            } else {
                insertPos = index;      // save index, if we are currently on the correct value
                right = index - 1;      // we are currently too high, so look if a[i-1] is STILL too high
            }
            this.iterations++;  // cnt++
        }

        // if key is in the upper half of the sub-list, return just the last "good" index
        // Edge-Case 3
        if (insertPos >= previous_left && insertPos <= previous_right && a[insertPos].compareTo(key) == 0) {
            return insertPos;
        }

        // If key is smaller than a[previous_left], contract requires previous_left - 1
        // Edge-Case 1
        if (insertPos == previous_left) {
            return previous_left - 1;
        }

        // Otherwise return the insertion position (could be previous_right + 1)
        // Edge-Case 2
        return insertPos;
    }
}