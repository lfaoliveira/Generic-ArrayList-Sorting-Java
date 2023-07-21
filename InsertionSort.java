package T1;
import java.util.ArrayList;


public class InsertionSort extends SortAbstrato {

    @Override
    public <T> void ordenar(ArrayList<T> v, ComparadorProduto cp){

        sort(v,0, v.size() - 1, cp);
    }


    public <T> void sort(ArrayList<T> v, int inicio, int fim, ComparadorProduto cp){
        int cont = 0;
        // primeiro elemento fica ordenado temporariamente
        for(int i = 1; i < v.size(); i++){

            T elem = v.get(i);
            int j = i - 1;
            // checa para ver se o elemento ja esta na posicao correta
            while(j >= 0 && cp.compare(v.get(j) , elem) > 0){
                v.set(j + 1, v.get(j));
                --j;
            }
            v.set(j + 1, elem);
        }
    }


}
