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
            arr.get(index) = new LinkedList<>();
        }

        arr.get(index).add(tmp);

        //arr.set(index, node);
        return true;
    }

    /* Удаление узла для ключа . */
    public V remove(K key) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node == null) {
            return null;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            /* Удаление начального узла - обновление. */
            int hashKey = getIndexForKey(key);
            arr.set(hashKey, node.next);
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return node.value;
    }

    /* Получение значения для ключа . */
    public V get(K key) {
        if (key == null) return null;
        LinkedListNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    /* Получение узла связного списка для заданного ключа . */
    private LinkedListNode<K, V> getNodeForKey(K key) {
        int index = getIndexForKey(key);
        LinkedListNode<K, V> current = arr.get(index);
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /* Очень наивная функция для связывания ключа с индексом . */
    public int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % arr.size());
    }

    public void printTable() {
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i) == null ? "" : arr.get(i).printForward();
            System.out.println(i + ": " + s);
        }
    }
}
