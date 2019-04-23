package hashtable;

import java.util.ArrayList;

class KeyValue {
    int key;
    String value;

    KeyValue(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class HashTable {
    private int modulo = 7;
    private ArrayList<KeyValue> elements[] = new ArrayList[modulo];

    private String get(int key) {
        int hash = key % modulo;

        //System.out.println("Key: " + key + " Hash: " + hash);

        if(elements[hash] == null) {
            return "Not Present";
        }

        for (KeyValue keyValue : elements[hash]) {
            if(keyValue.key == key) {
                return keyValue.value;
            }
        }
        return "Not Found";
    }

    private void put(int key, String value) {
        int hash = key % modulo;

        //For the first time, create new list
        if(elements[hash] == null) {
            elements[hash] = new ArrayList<KeyValue>();
        }

        int index = 0;
        for(KeyValue keyValue : elements[hash]) {
            //If existing, then update and return
            if(keyValue.key == key) {
                elements[hash].get(index).value = value;
                return;
            }
            index++;
        }

        //If not null, append key and value to the list
        KeyValue keyValue = new KeyValue(key, value);
        elements[hash].add(keyValue);
    }

    public static void main(String[] args) {
        //Test the HashTable
        HashTable hashTable = new HashTable();
        hashTable.put(1, "Hello");
        hashTable.put(2, "World");
        hashTable.put(8, "This");
        hashTable.put(9, "Real");
        hashTable.put(10, "Test");
        hashTable.put(1, "Hello1");
        System.out.println(hashTable.get(1));
        System.out.println(hashTable.get(2));
        System.out.println(hashTable.get(8));
        System.out.println(hashTable.get(9));
        System.out.println(hashTable.get(10));
        System.out.println(hashTable.get(11));
    }
}

