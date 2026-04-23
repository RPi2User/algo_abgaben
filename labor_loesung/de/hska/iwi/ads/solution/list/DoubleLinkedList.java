package de.hska.iwi.ads.solution.list;

import com.sun.jdi.Value;
import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

import java.util.Iterator;
import java.util.List;

public class DoubleLinkedList<K extends Comparable<K>,V> extends AbstractDoubleLinkedList<K, V> {

    public Iterator<Entry<K,V>> it = this.iterator();
    private ListElement tail;

    public ListElement getHead() { return this.head; }
    public ListElement getTail() { return this.tail; }

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public V get(Object o) {

        while (it.hasNext()) {
            System.out.println("TEST");
            it.next();
        }


        if (this.head == null)
            return null;

        return this.head.entry.getValue();
    }
        /* trash:
        while (this.head != null && this.head.entry.getKey() != (K) o){
            // iterate until head.entry.key == o
            this.head = this.head.next;
        }

        try {
            // this separates the two cases:
            // 1) head.entry.key = o
            //    -> Return the value
            // 2) head.entry = null
            //    -> null.getValue() raises an Exception

            return this.head.entry.getValue();
        }
        catch (Exception e) {
            return null; // o is not in list
        }*/

    public V put(K key, V value){
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

        while (it.hasNext()) {
            Entry<K,V> _e =  it.next();
            if (_e.getKey().equals(key)) {
                V _oldval = _e.getValue();
                _e.setValue(value);
                return _oldval;
            }
        }

        // after loop we are at head[len] hence head.next -> null
        _tmp.next = this.head.next; // preserve null
        _tmp.previous = this.head;  // link new head to old one
        this.head = _tmp;           // promote tmp to new head
        this.head.previous.next = this.head;

        this.size++;
        return null;
    }
}
