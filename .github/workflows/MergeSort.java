package T1;
import java.util.ArrayList;


public class MergeSort extends SortAbstrato {

    @Override
    public <T> void ordenar(ArrayList<T> v, ComparadorProduto cp){


        ArrayList<T> temp = new ArrayList<>(v.size());
        temp.addAll(v);
        int cont = 0;

        MergeMain(v,temp,0, v.size() - 1, cp,cont);
    }

    public <T> void MergeMain(ArrayList<T> v, ArrayList<T> temp, int inicio, int fim, ComparadorProduto cp,int cont){
        if(inicio < fim){
            int mid = (inicio + fim)/2;

            MergeMain(v, temp, inicio, mid, cp,cont);
            MergeMain(v, temp, mid + 1, fim, cp,cont);
            merge(v,temp, inicio, mid + 1, fim, cp,cont);

        }

    }


    public <T> void merge(ArrayList<T> v, ArrayList<T> temp, int esqPos, int dirPos, int dirFim, ComparadorProduto cp,int cont){
        if(esqPos < dirFim){

            int esqFim = dirPos - 1;
            int tempPos = esqPos;
            int n = dirFim - esqPos + 1;

            while(esqPos <= esqFim && dirPos <= dirFim){

                if(  (cp.compare(v.get(esqPos) ,v.get(dirPos)) ) < 0){
                    temp.set(tempPos, v.get(esqPos));
                    esqPos++;
                }
                else{
                    temp.set(tempPos, v.get(dirPos));
                    dirPos++;
                }
                tempPos++;

            }
            while(esqPos <= esqFim){
                temp.set(tempPos, v.get(esqPos));
                esqPos++;tempPos++;
            }

            while(dirPos <= dirFim){
                temp.set(tempPos, v.get(dirPos));
                dirPos++;tempPos++;
            }

            int i = dirFim;
            for(int k = 0; k < n; k++, --i){
                v.set(i, temp.get(i));

            }

        }

    }
}