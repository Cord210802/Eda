public class PruebaHeap {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap();
        Heap<Integer> heap2 = new Heap();
        heap.inserta(5);
        heap.inserta(3);
        heap.inserta(8);
        heap.elimina();
        System.out.println(heap);
    }
}
