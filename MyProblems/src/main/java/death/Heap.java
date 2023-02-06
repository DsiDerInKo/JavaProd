package death;

public class Heap<E extends Comparable> {

    private Vectors<E> arr;
    private int curSize;


    public Heap(){
        arr = new Vectors<E>();
        curSize = 0;
    }

    public int getCurSize() {
        return curSize;
    }

    private void swap(int a, int b){
        E temp = arr.get(a);
        arr.set(arr.get(b),a);
        arr.set(temp,b);
    }

    private void siftUp(int index){
        int parentIndex = (int)(index-1)/2;

        while (index>0){

            if (arr.get(parentIndex).compareTo(arr.get(index)) > 0) {
                swap(parentIndex, index);
                index = parentIndex;
                parentIndex = (int) (index - 1) / 2;
            }
            else break;
        }

    }

    private void siftDown(int index){
        int childIndex = index * 2 + 1;

        while(curSize - childIndex>0){
            if (curSize - childIndex + 1 > 0){
                if (arr.get(childIndex).compareTo(arr.get(childIndex+1)) > 0) childIndex++;
            }

            if (arr.get(childIndex).compareTo(arr.get(index)) < 0){
                swap(index,childIndex);
            }

            else break;
        }
    }

    public void add(E elem){
        arr.add(elem);
        siftUp(curSize);
        curSize++;
    }

    public E extractMin(){
        if (arr.getCurSize() == 0){
            throw new IllegalStateException("You are trying to extractMin from empty Heap");
        }
        swap(0,curSize-1);
        E temp = arr.popLast();
        siftDown(0);
        curSize--;

        return temp;
    }

    public E peek(){
        if (arr.getCurSize()>0){
            return arr.get(0);
        }
        else throw new IllegalStateException("Heap is empty");
    }

    public static<E extends Comparable<E>> E[] heapSort(E[] newArr){
        Heap<E> heap = new Heap<>();

        for (E e : newArr) {
            heap.add(e);
        }

        E[] resultArr = (E[]) new Object[heap.getCurSize()];

        for (int i = 0; i< heap.getCurSize();i++){
            resultArr[i] = heap.extractMin();
        }

        return resultArr;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "arr=" + arr +
                '}';
    }
}
