public class Max_Heap {
    private int[] Heap;
    private int size;
    private int maxsize;

    // Constructor para iniciar el max heap con el máximo de capacidad dado
    public Max_Heap(int size) {
        this.maxsize = size;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    // Método para obtener la posición del padre
    private int getParent(int pos) {
        return pos / 2;
    }

    // Método para obtener la posición del hijo izquierdo
    private int getLeftchild(int pos) {
        return (2 * pos)  ;
    }

    // Método para obtener la posición del hijo derecho
    private int getRightchild(int location) {
        return (2 * location) + 1;
    }

    // Método para el intercambio de nodos
    private void swap(int fLocation, int sLocation) {
        int temp;
        temp = Heap[fLocation];
        Heap[fLocation] = Heap[sLocation];
        Heap[sLocation] = temp;
    }

    // Método para mover de padres a hijos, de arriba hacia abajo
    private void downHeapify(int location) {
        if (location >= (size / 2) && location <= size)
            return;

        if (Heap[location] < Heap[getLeftchild(location)] ||
                Heap[location] < Heap[getRightchild(location)]) {

            if (Heap[getLeftchild(location)] > Heap[getRightchild(location)]) {
                swap(location, getLeftchild(location));
                downHeapify(getLeftchild(location));
            } else {
                swap(location, getRightchild(location));
                downHeapify(getRightchild(location));
            }
        }
    }

    // Método para mover de hijos a padres, de abajo hacia arriba
    private void heapifyUp(int location) {
        int temp = Heap[location];
        while(location>0 && temp > Heap[getParent(location)]){
            Heap[location] = Heap[getParent(location)];
            location = getParent(location);
        }
        Heap[location] = temp;
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
            System.out.print(+ Heap[i] + ": L->" +
                    Heap[2 * i] + " R ->" + Heap[2 * i + 1]);
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
        Max_Heap maxHeap = new Max_Heap(15);
        maxHeap.insert(1);
        maxHeap.insert(4);
        maxHeap.insert(2);
        maxHeap.insert(5);
        maxHeap.insert(13);
        maxHeap.insert(6);
        maxHeap.insert(17);

        maxHeap.print();
        System.out.println("The max is " + maxHeap.extractMax());
    }
}
