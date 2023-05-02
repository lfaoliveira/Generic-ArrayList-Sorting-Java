package T1;

import java.util.ArrayList;


public class QuickMerge extends SortAbstrato{
    @Override
    public <T>  void ordenar(ArrayList<T> v, ComparadorProduto cp){
        int cont = 0;
        int h = 3;
        int inicio = 0; int fim = v.size() - 1;

        QM(v, inicio, fim, h, cont, cp);

    }


    public <T> void QM(ArrayList<T> v, int inicio, int fim, int h, int cont, ComparadorProduto cp){

        if(inicio < fim){
            cont++;
            if(cont >= h){
                MergeSort m = new MergeSort();
                m.executeSort(v, cp.getCampo());
            }
            else{
                int pos_pivot = particao(v,inicio,fim, cp);

                QM(v,inicio,pos_pivot - 1,h,cont, cp);
                QM(v,pos_pivot + 1,fim,h,cont, cp);
            }

        }


        return;
    }



    public <T> int particao(ArrayList<T> v, int inicio, int fim, ComparadorProduto cp){
        if(inicio < fim){

            T pivot = v.get(inicio);
            int i = inicio + 1, f = fim;

            while(i <= f){

                if( (cp.compare(v.get(i) , pivot) ) <= 0 ){
                    ++i;
                }
                else if( (cp.compare(v.get(f) , pivot) ) > 0 ){
                    --f;
                }
                else{
                    T aux = v.get(f);
                    v.set(f, v.get(i));
                    v.set(i, aux);
                    ++i; --f;
                }
            }
            v.set(inicio, v.get(f));
            v.set(f, pivot);
            return f;
        }
        return 0;

    }


}
