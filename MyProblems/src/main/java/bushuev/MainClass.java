package bushuev;

import bushuev.HashFunctions;
import death.Heap;
import bushuev.HashTable;
import bushuev.Hasher;

public class MainClass {

    public static void main(String[] args) {

        HashTable table = new HashTable(20);

        table.add("12");
        table.add("15");
        table.add("214");
        table.add("345");
        table.add("76");
        table.add("12");
        table.add("12");
        table.add("12234");
        table.add("122");
        table.add("1255");
        table.add("1266");

        Hasher<Integer,String> tbl = new Hasher<>(20);

        tbl.put(12,"123a");
        tbl.put(13,"12364");
        tbl.put(1,"123342");
        tbl.put(15,"123645");
        tbl.put(100,"123213");
        tbl.put(100,"123212");
        tbl.put(100,"123211");

    }

}
