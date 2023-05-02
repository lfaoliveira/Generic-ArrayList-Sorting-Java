package T1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;
import java.io.FileWriter;


public class Main {
    public static long runCollectionSort(ArrayList<Produto> v, ComparadorProduto<Produto> cp, ArrayList<Long> temposCollection){
        long ini = System.currentTimeMillis();
        v.sort(cp);
        long fim = System.currentTimeMillis();
        temposCollection.add(fim - ini);
        return fim - ini;
    }

    public static void main(String[] args) {

        //Array de long para os tempos de execução


        long inicio, fim, tempoExecucao1, tempoExecucao2;


        ArrayList<Long> temposCollection = new ArrayList<>();

        // le o CSV e ja retorna o Array de Objetos

        ArrayList<Produto> v = ReadCSV.leitura();


        // classe gerenciadora das ordenacoes
        Ordenador<Produto> pessoas = new Ordenador<>(v, null);

        ComparadorProduto<Produto> cp = new ComparadorProduto<>(null);
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao = 0;

            String sortEscolhido = "";


            while (true) {




                    //Faz ordenação crescente e decrescente


                    do {

                            PrintMenuSort();
                            opcao = Integer.parseInt(scanner.nextLine());


                        switch (opcao) {
                            case 1:
                                pessoas.setSort(new SelectionSort());
                                sortEscolhido = "Selection";
                                break;
                            case 2:
                                pessoas.setSort(new InsertionSort());
                                sortEscolhido = "Insertion";
                                break;
                            case 3:
                                pessoas.setSort(new QuickSort());
                                sortEscolhido = "Quick";
                                break;
                            case 4:
                                pessoas.setSort(new MergeSort());
                                sortEscolhido = "Merge";
                                break;
                            case 5:
                                pessoas.setSort(new HeapSort());
                                sortEscolhido = "Heap";
                                break;
                            case 6:
                                pessoas.setSort(new QuickMerge());
                                sortEscolhido = "QuickMerge";
                                break;
                            case 7:
                                pessoas.setSort(new SelectInsert());
                                sortEscolhido = "SelectInsert";
                                break;
                            case 8:

                                System.out.println("Saindo...");
                                System.exit(130);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }

                    } while ((opcao < 1 || opcao > 8));


                    String id;
                    String idReverso;
                    String cat;
                    String catReverso;

                    String criterio = "";
                    do {

                        PrintMenuOrdem();
                        opcao = Integer.parseInt(scanner.nextLine());

                        id = "id";
                        idReverso = "idReverso";
                        cat = "categoria";
                        catReverso = "categoriaReverso";

                        switch (opcao) {


                            case 1:
                                // Ordem Crescente

                                // Ordenar por id
                                criterio = id;
                                ArrayList<Produto> clone1 = (ArrayList<Produto>) v.clone();

                                inicio = System.currentTimeMillis();
                                pessoas.executeSort(clone1, criterio);
                                fim = System.currentTimeMillis();

                                tempoExecucao1 = fim - inicio;

                                System.out.print(sortEscolhido + " " + "Crescente " + "Numerico: " + tempoExecucao1 + "ms;  " );


                                cp.setCampo(id);
                                ArrayList<Produto> clone11 = (ArrayList<Produto>) v.clone();
                                long tempoColleccresc = runCollectionSort(clone11,cp,temposCollection);
                                System.out.println("Collections: " + tempoColleccresc + "ms;" );




                                //Checa se está ordenado
                                //cp.setCampo(criterio);
                                //System.out.println("\n" + estaOrdenado(clone1, cp, sortEscolhido) + "\n");


                                // Ordenar por categoria

                                criterio = cat;

                                ArrayList<Produto> clone2 = (ArrayList<Produto>) v.clone();

                                inicio = System.currentTimeMillis();
                                pessoas.executeSort(clone2, criterio);
                                fim = System.currentTimeMillis();

                                tempoExecucao2 = fim - inicio;

                                System.out.print(sortEscolhido + " " + "Crescente " + "Texto: " + tempoExecucao2 + "ms;  " );


                                criterio = "outroSort";
                                cp.setCampo(criterio);
                                ArrayList<Produto> clone12 = (ArrayList<Produto>) v.clone();
                                tempoColleccresc = runCollectionSort(clone12,cp,temposCollection);
                                System.out.println("Collections: " + tempoColleccresc + "ms;" );



                                //Checa se está ordenado
                                //cp.setCampo(criterio);
                                //System.out.println("\n" + estaOrdenado(clone2, cp, sortEscolhido) + "\n");




                                break;

                            case 2:
                            // Ordem Decrescente

                                // Ordenar por id

                                criterio = idReverso;
                                ArrayList<Produto> clone3 = (ArrayList<Produto>) v.clone();


                                inicio = System.currentTimeMillis();
                                pessoas.executeSort(clone3, criterio);
                                fim = System.currentTimeMillis();

                                tempoExecucao1 = fim - inicio;
                                System.out.print(sortEscolhido + " " + "Decrescente " + "Numerico: " + tempoExecucao1 + "ms;  " );

                                cp.setCampo(criterio);
                                ArrayList<Produto> clone21 = (ArrayList<Produto>) v.clone();
                                long tempoCollecdecresc = runCollectionSort(clone21,cp,temposCollection);

                                System.out.println("Collections: " + tempoCollecdecresc + "ms;" );


                                //Checa se está ordenado
                                //cp.setCampo(criterio);
                                //System.out.println("\n" + estaOrdenado(clone3, cp, sortEscolhido) + "\n");




                                // Ordenar por categoria

                                criterio = catReverso;
                                ArrayList<Produto> clone4 = (ArrayList<Produto>) v.clone();


                                inicio = System.currentTimeMillis();
                                pessoas.executeSort(clone4, criterio);
                                fim = System.currentTimeMillis();


                                tempoExecucao2 = fim - inicio;

                                System.out.print(sortEscolhido + " " + "Decrescente " + "Texto: " + tempoExecucao2 + "ms;  ");


                                criterio = "outroSort";
                                cp.setCampo(criterio);
                                ArrayList<Produto> clone22 = (ArrayList<Produto>) v.clone();
                                tempoCollecdecresc = runCollectionSort(clone22,cp,temposCollection);

                                System.out.println("Collections: " + tempoCollecdecresc + "ms;" );


                                //Checa se está ordenado
                                //cp.setCampo(criterio);

                                //System.out.println("\n" + estaOrdenado(clone4, cp, sortEscolhido) + "\n");


                                // Armazenando os tempos de execucao no vetor de long

                                System.out.print("\n");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    } while (opcao != 1 && opcao != 2);







            }


            //salvarTempoExecucaoEmArquivo (temposExecucao, temposCollection);



    } catch(NumberFormatException e) {
        e.printStackTrace();
    }
        }// fim main()

    public static void PrintMenuSort(){
        System.out.println("Escolha um método de ordenação:");
        System.out.println("1 - SelectSort");
        System.out.println("2 - InsertSort");
        System.out.println("3 - QuicSort");
        System.out.println("4 - MergeSort");
        System.out.println("5 - HeapSort");
        System.out.println("6 - QM-Sort");
        System.out.println("7 - SI-Sort");

        System.out.println("8 - Sair");
    }

    public static void PrintMenuOrdem(){
        System.out.println("Escolha o tipo de ordenação:");
        System.out.println("1 - Ordenar em ordem crescente");
        System.out.println("2 - Ordenar em ordem decrescente");
    }


    static class ReadCSV {
        public static ArrayList<Produto> leitura() {
            String path = "C:\\Users\\surul\\IdeaProjects\\T1\\src\\T1\\train_data.csv";

            BufferedReader buffer = null;
            String line = "";
            String csvDelimiter = ",";


            try {

                buffer = new BufferedReader(new FileReader(path));

                // pular a linha com os cabecalhos
                line = buffer.readLine();
                ArrayList<Produto> vetorObj = new ArrayList<>();
                // ((line = buffer.readLine()) != null)
                int cont = 0;
                while ( ++cont < 15000) {
                    line = buffer.readLine();
                    String[] data = line.split(csvDelimiter);
                    int id = parseInt(data[1]);
                    String din = data[3];
                    Produto p = new Produto(id, din);
                    vetorObj.add(p);
                }

                return vetorObj;

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }// fim leitura
    }// fim CSV


    public static boolean estaOrdenado(ArrayList<Produto> v, ComparadorProduto cp, String nome){
        String crit = cp.getCampo();
        System.out.print(nome + ": ");
        int i;
        for(i = 0; i < v.size() - 1; ++i){
            Produto p1 = v.get(i);
            Produto p2 = v.get(i + 1);
            if(cp.compare(p1,p2) > 0){
                if(crit.equals("id") || crit.equals("idReverso") ){
                    for(int j = i; j < v.size(); j++){
                        System.out.print(v.get(j).getId() + " ");
                    }
                }
                else{
                    for(int j = i; j < v.size(); j++){
                        System.out.print(v.get(j).getCategoria() + " ");
                    }
                }
                return false;
            }
            /*
            switch(crit){
                // case para inteiros (eh generalizavel)

                case "idReverso":

                    System.out.print(v.get(i).getIdade() + " ");
                    break;

                case "id":

                    System.out.print(v.get(i).getIdade() + " ");
                    break;

                    /// FALTA MODIFICAR PRA STRING
                case "categoria":

                    System.out.print(v.get(i).getDinheiro() + " ");
                    break;
                case "categoriaReverso":

                    System.out.print(v.get(i).getDinheiro() + " ");
                    break;

                default:
                    break;

            }

             */

        }
        /*
        switch(crit){
            // case para inteiros (eh generalizavel)

            case "idReverso":

                System.out.print(v.get(i).getIdade() + " ");
                break;

            case "id":

                System.out.print(v.get(i).getIdade() + " ");
                break;


            case "categoria":

                System.out.print(v.get(i).getDinheiro() + " ");
                break;
            case "categoriaReverso":

                System.out.print(v.get(i).getDinheiro() + " ");
                break;

            default:
                break;

        }

         */


        return true;


    }

    public static void salvarTempoExecucaoEmArquivo(long[] temposExecucao, ArrayList<Long> temposCollection) {
        int i = 1, j = 1, k = 1, indiceOrdenador = 0;
        String Ordem1 = "Crescente", Ordem2 = "Decrescente", Metodo1 = "Numérico", Metodo2 = "Texto", aux = "";
        String[] Ordenador = {"InsertSort", "SelectSort", "QuickSort", "MergeSort", "HeapSort", "QuickMergeSort", "SelectInsertSort"};

        try {
            FileWriter writer = new FileWriter("tempo_execucao.txt");

            int l = 0;
            String Ordem = Ordem1;
            String Metodo = Metodo1;
            while (l < 28) {

                if (i > 4) {
                    i = 1;
                    indiceOrdenador++;
                }

                if (j > 2) {
                    j = 1;
                    if (Ordem.equals(Ordem1)) {
                        aux = Ordem2;
                    }
                    if (Ordem.equals(Ordem2)) {
                        aux = Ordem1;
                    }
                    Ordem = aux;
                }

                if (k > 1) {
                    k = 1;
                    if (Metodo.equals(Metodo1)) {
                        aux = Metodo2;
                    }
                    if (Metodo.equals(Metodo2)) {
                        aux = Metodo1;
                    }
                    Metodo = aux;
                }

                writer.write(Ordenador[indiceOrdenador] + " "+ Ordem + " " + Metodo + ": " + temposExecucao[l] + " ms;  Collection.sort:" + temposCollection.get(i) +"ms\n");

                i++;
                j++;
                k++;
                l++;
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}






