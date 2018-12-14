import java.io.*;
import java.util.ArrayList;

public class Ex1{
    public static void main(String[] args){
        int opt;
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        MinhaListaOrdenavel lista = new MinhaListaOrdenavel();
        ArrayList ordenado = new ArrayList<PessoaIMC>();
        lista.add(new Homem("Vinicius", "27/03/1992" , 100, 1.80));
        lista.add(new Homem("Alberto", "14/04/1989", 75, 1.65));
        lista.add(new Homem("Gilberto", "13/05/1990", 70, 1.85));
        lista.add(new Homem("Gustavo", "02/06/1998", 90, 1.60));
        lista.add(new Homem("Leonardo", "30/07/1991", 80, 1.95));
        lista.add(new Mulher("Carlota", "22/08/1997", 60, 1.75));
        lista.add(new Mulher("Elizabeth", "15/09/1994", 65, 1.55));
        lista.add(new Mulher("Ingrid", "19/10/1993", 95, 2.00));
        lista.add(new Mulher("Jessica", "07/11/1970", 55, 1.70));
        lista.add(new Mulher("Marcela", "02/12/1985", 85, 1.90));

        while(true){
            try{
                System.out.println("Escolha uma opcao: ");
                System.out.println("---------------------");
                System.out.println("1 - Imprimir lista. ");
                System.out.println("2 - Sair. ");
                try{
                    opt = Integer.parseInt(inData.readLine());
                }
                catch(NumberFormatException e){
                    opt = 3;
                }
                if(opt == 1){
                    while(true){
                        System.out.println("Escolha uma opcao: ");
                        System.out.println("---------------------");
                        System.out.println("1 - Alfabetica (A-Z). ");
                        System.out.println("2 - Alfabetica (Z-A). ");
                        System.out.println("3 - Menor Peso. ");
                        System.out.println("4 - Maior Peso. ");
                        System.out.println("5 - Menor Altura. ");
                        System.out.println("6 - Menor IMC. ");
                        System.out.println("7 - Homem / Mulher. ");
                        System.out.println("8 - Sair. ");
                        try{
                            opt = Integer.parseInt(inData.readLine());
                        }
                        catch(NumberFormatException e){
                            opt = 9;
                        }
                        if(opt >= 1 && opt <= 7){
                            ordenado = lista.Ordena(opt);
                            for(int i=0; i<ordenado.size(); i++){
                                System.out.println(ordenado.get(i));
                            }
                        }
                        else if(opt == 8){
                            break;
                        }
                        else{
                            System.out.println("Opcao Invalida, tente novamente");
                        }
                        // 1.Alfabetica (A-Z) – nome da pessoa
                        // 2.Alfabetica (Z-A) – nome da pessoa
                        // 3.Menor Peso - crescente
                        // 4.Maior Peso - decrescente
                        // 5.Menor Altura – crescente, do mais baixo para o mais alto
                        // 5.Menor IMC - crescente, do mais baixo para o mais alto
                        // 6.Homem / Mulher – ordenar por gênero * esse é desafio
                    }
                }
                else if(opt == 2){
                    break;
                }
                else{
                    System.out.println("Opcao invalida, tente novamente.");
                }
            }
            catch(IOException e){
                System.out.println(e);
            }
        }
        
    }
}