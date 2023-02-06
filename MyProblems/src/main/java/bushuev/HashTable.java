package bushuev;

import java.util.ArrayList;
import java.util.LinkedList;
import bushuev.HashFunctions;

public class HashTable {

    LinkedList[] array;

    public HashTable(int size){
        LinkedList[] arr;

        array = new LinkedList[size];

    }

    public void add(String elem){
        HashFunctions hash = new HashFunctions();
        long tmpIndex = hash.stringHash((String) elem);
        if (tmpIndex<0) tmpIndex = -tmpIndex;

        int index = (int)tmpIndex%array.length;

        if (array[index]==null) {
            array[index] = new LinkedList<>();
            array[index].add(elem);
        }
        else{
            array[index].add(elem);
        }


    }

    public void remove(String elem){

    }

}
