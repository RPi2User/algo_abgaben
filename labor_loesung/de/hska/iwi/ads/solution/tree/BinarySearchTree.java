package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>,V> extends AbstractBinaryTree<K,V>{

    private Node binTreeGetAppendPos(Node node, K key){
        // gebe leeren node zurück bzw. den aktullen zum überschreiben
        if (node==null || node.entry.getKey().equals(key)){
            return node;
        }

        if (key.compareTo(node.entry.getKey())<0){
            if (node.left==null){
                return node;
            }
            else {
                return binTreeGetAppendPos(node.left,key);
            }
        }
        else {
            if (node.right==null){
                return node;
            }
            else {
                return binTreeGetAppendPos(node.right,key);
            }
        }
    }

    private Node binTreeSearch(Node node, K key){
        // wenn root := null ist return root (also null)
        // wenn wir den Key gefunden haben return root (also key)
        if (node==null || node.entry.getKey().equals(key)){
            return node;
        }
        // wenn unser key kleiner ist als der aktuelle node.key, dann links weiter suchen
        else if (key.compareTo(node.entry.getKey()) < 0 ){
            return binTreeSearch(node.left, key);
        }
        else { // sonst rechts weitersuchen
            return binTreeSearch(node.right, key);
        }
    }

    public V get (Object o){
        if (o == null)
            throw new NullPointerException();
        // root leer dann gib leer zurück
        if (root == null){
            return null;
        }

        Node current = binTreeSearch(root, (K) o);

        if (current==null){
            return null;
        }
        else {
            return current.entry.getValue();
        }
    }
    public V put(K key, V value){
        if (root == null){
            root =  new Node(key,value);
            size++;
            return null;
        }

        Node node = binTreeGetAppendPos(root, key);

        int cmp = key.compareTo(node.entry.getKey());
        if (cmp == 0) {
            V oldValue = node.entry.getValue();
            node.entry.setValue(value);
            return oldValue;
        }

        if (cmp < 0) {
            node.left = new Node(key, value);
        } else {
            node.right = new Node(key, value);
        }
        size++;
        return value;
    }
}
