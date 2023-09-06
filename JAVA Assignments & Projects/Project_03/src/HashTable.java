//import java.util.*;
//
//public class HashTable {
//    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
//    private int threshold;              //when you reach a point the array needs to be doubled
//    private float loadFactor;
//    private int modCount;
//    private int count;
//    Element<?>[] table;
//
//
//    public HashTable(int initialCapacity, float loadFactor) {
//        if (initialCapacity == 0) {
//            initialCapacity = 1;
//        }
//        table = new Element<?>[initialCapacity];
//        this.loadFactor = loadFactor;
//        threshold = (int) Math.min(initialCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
//    }
//
//    public HashTable() {
//        this(11, 0.75f);
//    }
//
//    private void addEntry(int hash, int index) {
//        modCount++;
//
//        Element<?> tab[] = table;
//        if (count >= threshold) {
//            tab = table;
//            index = (hash & 0x7FFFFFFF) % tab.length;
//        }
//        @SuppressWarnings("unchecked")
//        Element<String> e = (Element<String>) tab[index];
//        tab[index] = new Element<>(e);
//        count++;
//    }
//}