package T1;

public class Produto {
    private int id;
    private String categoria;

    public Produto(int id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria(){
        return this.categoria;
    }




}

