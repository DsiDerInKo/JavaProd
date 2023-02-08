package bushuev;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyMap<K, V> {

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
            arr.set(index,new LinkedList<>());
        }

        arr.get(index).add(tmp);

        return true;
    }

    /* Удаление узла для ключа . */
    public V remove(K key) throws IllegalAccessException {

        LinkedList<Pair> list = getList(key);
        if(list == null) throw new IllegalAccessException();

        for (Pair pair : list) {
            if(pair.key == key){
                V tmp = (V) pair.value;
                list.remove(pair);
                return tmp;
            }
        }

        return null;
    }

    public LinkedList getList(K key) {
        if (key == null) return null;
        int index = getIndexForKey(key);
        return arr.get(index)==null? null:arr.get(index);
    }


    /* Очень наивная функция для связывания ключа с индексом . */
    private int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % arr.size());
    }

    public void printTable() {
        for (int i = 0; i < arr.size(); i++) {
            //String s = arr.get(i) == null ? "" : arr.get(i).printForward();
            if (arr.get(i) == null) continue;
            for(int j=0; j < arr.get(i).size();j++){
                String s = arr.get(i).get(j) == null? "empty": arr.get(i).get(j).key.toString();
                String t = arr.get(i).get(j).value.toString();
                System.out.println(i + ": " + "key,value:"+s+","+t);
            }



        }
    }
}
