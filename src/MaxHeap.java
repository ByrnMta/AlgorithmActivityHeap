/*public class MaxHeap {

    private int[] Heap;
    private int size;
    private int maxsize;

    // Constructor para iniciar el max heap con el máximo de capacidad dado
    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }

    //Método para obtener la posición del padre
    private int parent(int pos) { return (pos - 1) / 2; }

    //Método para obtener la posición del hijo izquierdo
    private int leftChild(int pos) { return (2 * pos); }

    //Método para obtener la posición del hijo derecho
    private int rightChild(int pos) { return (2 * pos) + 1; }

    // Método para saber si un nodo es hoja o no, true or false
    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Método para el intercambio de nodos
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Método recursivo para maximizar la heapificación del subárbol dado
    private void maxHeapify(int pos) {
        if (isLeaf(pos))
            return;
        if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    // Método para insertar nodos
    public void insert(int element) {
        Heap[size] = element;
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    // Método para realizar print del arból
    public void print() {
        for (int i = 0; i <= size / 2; i++) {
            System.out.print(
                        " PARENT : " + Heap[i]
                                + " LEFT CHILD : " + Heap[2 * i + 1]
                                + " RIGHT CHILD :" + Heap[2 * i + 2]);
            System.out.println();
        }
    }

    // Método para extraer un nodo
    public int extractMax() {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }

    public static void main(String[] arg) {
        System.out.println("The Max Heap is ");

        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();

        System.out.println("The max val is "
                + maxHeap.extractMax());
        }
    }*/
