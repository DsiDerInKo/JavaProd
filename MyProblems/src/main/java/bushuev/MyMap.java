package bushuev;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyMap<K, V> {
    /* Класс узла связного списка . Используется только в хэш-таблице,
     * реализуется в виде двусвязного списка . */

    class Pair<K,V>{
        K key;
        V value;

        public Pair(K k,V v){
            key = k;
            value = v;
        }
    }

    private ArrayList<LinkedList<Pair>> arr;

    public MyMap(int capacity) {
        /* Создание списка связных списков . Список заполняется значениями
         * пull (единственный способ создания массива заданного размера ). */
        arr = new ArrayList<LinkedList<Pair>>();
        arr.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }

    public boolean contains(Pair pair){
        int index = getIndexForKey((K) pair.key);
        LinkedList<Pair> current = arr.get(index);
        return arr.contains(pair);
    }

    /* Вставка ключа и значения в хэш-таблицу . */
    public boolean put(K key, V value) {

        int index = getIndexForKey(key);
        Pair tmp = new Pair(key,value);

        if (arr.get(index) == null) {
            //arr.get(index) = new LinkedList<>();
        }

        arr.get(index).add(tmp);

        //arr.set(index, node);
        return true;
    }

    /* Удаление узла для ключа . */
    public V remove(K key) {
        int index = getIndexForKey(key);


        return null;
    }

    /* Получение значения для ключа . */
    public LinkedList getList(K key) {
        if (key == null) return null;
        int index = getIndexForKey(key);
        return arr.get(index)==null? null:arr.get(index);
    }


    /* Очень наивная функция для связывания ключа с индексом . */
    public int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % arr.size());
    }

    public void printTable() {
        for (int i = 0; i < arr.size(); i++) {
            //String s = arr.get(i) == null ? "" : arr.get(i).printForward();
            String s = arr.toString();
            System.out.println(i + ": " + s);

        }
    }
}
