package de.hska.iwi.ads.solution.list;

import com.sun.jdi.Value;
import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

import java.util.Iterator;
import java.util.List;

public class DoubleLinkedList<K extends Comparable<K>,V> extends AbstractDoubleLinkedList<K, V> {

    private ListElement tail;

    public ListElement getHead() { return this.head; }
    public ListElement getTail() { return this.tail; }

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public V get(Object o) {

        if (o == null)
            throw new NullPointerException();

        if (this.head == null)
            return null;

        Iterator<Entry<K, V>> it = this.iterator();
        while (it.hasNext()) {
            Entry<K,V> _e =  it.next();
            if (_e.getKey().equals((K) o)){
                return _e.getValue();
            }
        }

        return null;
    }

    public V put(K key, V value){

        if (key == null)
            throw new NullPointerException();

        ListElement _tmp = new ListElement(
            new SimpleEntry<K,V>(key, value),
            null,
            null
        );

        if (this.head == null) {
            this.head = _tmp;
            this.tail = _tmp;
            this.size = 1;
            return null;
        }

        // Sequenzielle Suche nach KEY bis Listenende
        // Danach wird this.head.next = _tmp gemacht

        Iterator<Entry<K, V>> it = this.iterator();
        while (it.hasNext()) {
            Entry<K,V> _e =  it.next();
            if (_e.getKey().equals(key)) {
                V _oldval = _e.getValue();
                _e.setValue(value);
                return _oldval;
            }
        }

        // after loop we are at tail[len] hence tail.next -> null
        _tmp.next = this.tail.next; // preserve tail.next (null) to newTail.next (null)
        _tmp.previous = this.tail;  // make current tail the former one
        this.tail.next = _tmp;
        this.tail = this.tail.next; // go to the next element

        this.size++;    // update size
        return null;
    }
}
