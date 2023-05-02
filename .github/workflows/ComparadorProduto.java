package T1;

import java.util.Comparator;


public  class  ComparadorProduto<T> implements Comparator<T>{
    private String campo;

    public ComparadorProduto(String campo){
        this.campo = campo;
    }

    public String getCampo(){
        return this.campo;
    }
    public void setCampo(String campo){
        this.campo = campo;
    }


    @Override
    public int compare(T p1,T p2){

        switch(campo){
            // case para os dois tipos de campo e suas versoes de orndenacao inversa

            case "idReverso":
                if( (p1 instanceof Produto) && (p2 instanceof Produto) ) {
                    Produto aux1 = (Produto) p1;
                    Produto aux2 = (Produto) p2;


                    return aux2.getId() - aux1.getId();
                }


            case "id":
                if( (p1 instanceof Produto) && (p2 instanceof Produto) ) {
                    Produto aux1 = (Produto) p1;
                    Produto aux2 = (Produto) p2;

                    return aux1.getId() - aux2.getId();
                }


            case "categoria":

                if((p1 instanceof Produto) && (p2 instanceof Produto)){
                    Produto aux1 = (Produto) p1; Produto aux2 = (Produto) p2;
                    char c1 = aux1.getCategoria().charAt(0);
                    char c2 = aux2.getCategoria().charAt(0);

                    return c1 - c2;
                }

            case "categoriaReverso":

                if((p1 instanceof Produto) && (p2 instanceof Produto)) {
                    Produto aux1 = (Produto) p1; Produto aux2 = (Produto) p2;

                    char c1 = aux1.getCategoria().charAt(0);
                    char c2 = aux2.getCategoria().charAt(0);

                    return c2 - c1;

                }
            case "outroSort":
                if((p1 instanceof Produto) && (p2 instanceof Produto)) {
                    Produto aux1 = (Produto) p1; Produto aux2 = (Produto) p2;

                    return aux1.getCategoria().compareTo(aux2.getCategoria());

                }
            case "outroSortReverso":
                if((p1 instanceof Produto) && (p2 instanceof Produto)) {
                    Produto aux1 = (Produto) p1; Produto aux2 = (Produto) p2;

                    return aux2.getCategoria().compareTo(aux1.getCategoria());

                }

            default:
                throw new IllegalArgumentException("Invalid field: " + campo);


        }


    }


}