public class MaxHeapV2 {
    private int[] Heap;
    private int size;
    private int maxsize;

    // Constructor para iniciar el max heap con el máximo de capacidad dado
    public MaxHeapV2(int size) {
        this.maxsize = size;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    // Método para obtener la posición del padre
    private int parent(int pos) {
        return pos / 2;
    }

    // Método para obtener la posición del hijo izquierdo
    private int leftChild(int pos) {
        return (2 * pos)  ;
    }

    // Método para obtener la posición del hijo derecho
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Método para el intercambio de nodos
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Método para mover de padres a hijos, de arriba hacia abajo
    private void downHeapify(int pos) {
        if (pos >= (size / 2) && pos <= size)
            return;
        if (Heap[pos] < Heap[leftChild(pos)] ||
                Heap[pos] < Heap[rightChild(pos)]) {
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                downHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                downHeapify(rightChild(pos));
            }
        }
    }

    // Método para mover de hijos a padres, de abajo hacia arriba
    private void heapifyUp(int pos) {
        int temp = Heap[pos];
        while(pos>0 && temp > Heap[parent(pos)]){
            Heap[pos] = Heap[parent(pos)];
            pos = parent(pos);
        }
        Heap[pos] = temp;
    }

    // Método para insentar nodos
    public void insert(int element) {
        Heap[++size] = element;
        int current = size;
        heapifyUp(current);
    }

    // Método para realizar print del arból
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(+ Heap[i] + ": L- " +
                    Heap[2 * i] + " R- " + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    // Método para extraer un nodo
    public int extractMax() {
        int max = Heap[1];
        Heap[1] = Heap[size--];
        downHeapify(1);
        return max;
    }

    public static void main(String[] arg) {
        MaxHeapV2 maxHeapV2 = new MaxHeapV2(15);
        maxHeapV2.insert(1);
        maxHeapV2.insert(4);
        maxHeapV2.insert(2);
        maxHeapV2.insert(5);
        maxHeapV2.insert(13);
        maxHeapV2.insert(6);
        maxHeapV2.insert(17);

        maxHeapV2.print();
        System.out.println("The max is " + maxHeapV2.extractMax());
    }
}
