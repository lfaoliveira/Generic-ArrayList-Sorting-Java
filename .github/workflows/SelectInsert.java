package T1;
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.Float.parseFloat;


public class SelectInsert extends SortAbstrato{

    // fim é o indice final e nao o tamanho do vetor
    @Override
    public <T> void ordenar(ArrayList<T> v, ComparadorProduto cp){
        System.out.print(" Porcentagem a usar SelectionSort:");


        Scanner s = new Scanner(System.in);
        String porcento = s.next();


        if(porcento.contains("%")){
            porcento = porcento.replace('%', '\0');
        }
        int n = v.size();
        float f =  parseFloat(porcento);

        // quantidade a ser ordenada pelo Selection
        int q = ( (int) (f*n)/100);


        if(q >= n/2){
            SelectionSort sel = new SelectionSort();
            sel.ordenar(v, cp);
        }

        if(q <= 1){
            InsertionSort ins = new InsertionSort();
            ins.ordenar(v,cp);
        }


  /*
  sendo "q" a quantidade de itens a serem ordenados nas extremidades  e
  contanto que q >= 2, tem como utilizar um offset no loop interior para comparar todos os itens das extremidades e achar o menor

  com um loop , se garante que o indice nunca vai sair do vetor na hora de analisar as extremidades


 loop Selection Sort das extremidades
  */

        int fim = v.size() - 1;


        /// Ordena do comeco ate q - 1
        int cont_select = 0;
        for(int i = 0; i < q; i++){
            int pos_min = i;

            for(int  j =i; j < q; j++){

                if( cp.compare(v.get(j) , v.get(pos_min)) <= 0 )  {
                    pos_min = j;
                }

            }

            T aux = v.get(i);
            v.set(i, v.get(pos_min));
            v.set(pos_min, aux);

        }


        for(int i = n - q + 1; i < n; i++){
            int pos_min = i;
            for(int  j =i; j < n; j++){

                if( cp.compare(v.get(j) , v.get(pos_min)) <= 0 )  {
                    pos_min = j;
                }

            }

            T aux = v.get(i);
            v.set(i, v.get(pos_min));
            v.set(pos_min, aux);

        }



        // Ordena o resto com InsertionSort
        InsertionSort ins = new InsertionSort();
        ins.executeSort(v,cp.getCampo());


    }  // fim sort

}
