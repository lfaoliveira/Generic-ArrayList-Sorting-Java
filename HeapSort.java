package T1;
import java.util.ArrayList;



public class HeapSort extends SortAbstrato{

    @Override
    public <T> void ordenar(ArrayList<T> v, ComparadorProduto cp){

        heapSort(v, cp);
    }


    private <T> void heapSort(ArrayList<T> v, ComparadorProduto cp) {
        int n = v.size();

        // Constroi MaxHeap
        int i;
        for (i = (n - 1)/2; i >= 0; i--) {
            heapify(v, n, i, cp);
        }

        int cont = 0;
        // troca maior com menor
        for (i = n - 1; i >= 0; i--) {


            // move current root to end
            T temp = v.get(0);
            v.set(0, v.get(i));
            v.set(i, temp);

            // heapify no resto do heap
            heapify(v, i, 0, cp);
        }
    }

    // MaxHeapifica o subarray
    private <T> void heapify(ArrayList<T> v, int size, int i, ComparadorProduto cp)
    {
        //maior = raiz
        int max   = i;
        int left  = 2 * i + 1;
        int right = 2 * i + 2;


        // se esq > pai
        if (left < size && (cp.compare(v.get(left), v.get(max)) ) >= 0)
            max = left;

            // se dir > pai
        if (right < size && (cp.compare(v.get(right), v.get(max)) ) > 0)
            max = right;

        // se max nao eh o pai
        if (max != i)
        {
            // swap
            T temp = v.get(i);
            v.set(i, v.get(max));
            v.set(max, temp);

            // recursivamente heapifica a sub-arvo afetada
            heapify(v, size, max, cp);
        }
    }

}
