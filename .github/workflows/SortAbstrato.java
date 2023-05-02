package T1;
import java.util.ArrayList;

public abstract class SortAbstrato implements Sort{

    private ComparadorProduto<Produto> cp;
    private <T> void templateMethod(ArrayList<T> v, String campo){
        this.cp = new ComparadorProduto<>(campo);

        ordenar(v,this.cp);
    }


    @Override
    public <T> void executeSort(ArrayList<T> v, String campo){
        templateMethod(v, campo);
    }

    public abstract <T>  void ordenar(ArrayList<T> v,ComparadorProduto cp);

}