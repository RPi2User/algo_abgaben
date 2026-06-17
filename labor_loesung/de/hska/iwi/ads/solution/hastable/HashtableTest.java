package de.hska.iwi.ads.solution.hastable;

import de.hska.iwi.ads.dictionary.MapTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class HashtableTest extends MapTest{
    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new Hashtable<K, V>(20);
    }
}
