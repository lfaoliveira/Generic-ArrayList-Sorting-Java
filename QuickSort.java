package T1;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class QuickSort extends SortAbstrato{

    private Random rand;
    @Override
    public <T> void ordenar(ArrayList<T> v, ComparadorProduto cp){
        int cont = 0;
        this.rand = new Random();

        int inicio = 0;int fim = v.size() - 1;


        sort(v, inicio, fim, cp, cont);
    }




    public <T> void sort(ArrayList<T> v, int inicio, int fim,ComparadorProduto cp,int cont){
        int[] stack = new int[fim - inicio + 1];
        int top = -1;
        stack[++top] = inicio;
        stack[++top] = fim;

        while (top >= 0) {

            fim = stack[top--];
            inicio = stack[top--];
            int pivot = particao(v, inicio, fim, cp,cont);
            if (pivot - 1 > inicio) {
                stack[++top] = inicio;
                stack[++top] = pivot - 1;

            }
            if (pivot + 1 < fim) {
                stack[++top] = pivot + 1;
                stack[++top] = fim;

            }

        }
    }


    <T> void random(ArrayList<T> v,int inicio,int fim)
    {
        int pivot = rand.nextInt(fim-inicio) + inicio;

        T temp = v.get(pivot);
        v.set(pivot,v.get(inicio));
        v.set(inicio, temp);
    }


    public <T> int particao(ArrayList<T> v, int inicio, int fim, ComparadorProduto cp, int cont){
        try{
            random(v, inicio, fim);
            T pivot = v.get(inicio);
            int i = inicio, f = fim + 1;

            while(true){
                do{
                    i++;
                }while(i <= fim && cp.compare(v.get(i), pivot) < 0);

                do{
                    f--;
                }while(cp.compare(v.get(f), pivot) > 0);

                if(i >= f){

                    break;
                }

                T temp = v.get(i);
                v.set(i, v.get(f));
                v.set(f, temp);
            }

            v.set(inicio, v.get(f));
            v.set(f, pivot);

            return f;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return -1;
    }



}
