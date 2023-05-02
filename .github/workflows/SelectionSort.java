package T1;
import java.util.ArrayList;


public class SelectionSort extends SortAbstrato{

    @Override
    public <T> void ordenar(ArrayList<T> v, ComparadorProduto cp){
        int n = v.size();

        int cont = 0;
        for(int i = 0;i < n; i++){
            int pos_min = i;


            for(int  j = i; j < n; j++){
                T elem = v.get(j);
                if(cp.compare(elem , v.get(pos_min)) < 0 )  {
                    pos_min = j;
                }

            }

            T aux = v.get(i);
            v.set(i, v.get(pos_min));
            v.set(pos_min, aux);

        }


    }


}