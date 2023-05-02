package T1;

import java.util.ArrayList;
import java.lang.Thread;
public class Ordenador<T> extends Thread {
    private Sort sort;
    private ArrayList<Produto> lista;
    private ComparadorProduto comparator;

    public Ordenador(ArrayList<Produto> pessoas, String campo) {
        this.lista = pessoas;
        this.comparator = new ComparadorProduto<Produto>(campo);
    }

    public void setComparator(ComparadorProduto cp){
        this.comparator = cp;
    }
    public ComparadorProduto getComparator(){
        return this.comparator;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }


    public  void executeSort(ArrayList<T> v, String campo) {


        sort.executeSort(v, campo);




    }

    public void add(Produto Produto) {
        if (lista == null) {
            this.lista = new ArrayList<>();
        }
        lista.add(Produto);
    }

    public void remove(Produto Produto) {
        lista.remove(Produto);
    }

    public int size() {
        return lista.size();
    }

    public Produto get(int index) {
        return lista.get(index);
    }

    public ArrayList<Produto> getArray() {
        return this.lista;
    }

}
