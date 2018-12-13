import java.io.*;
import java.util.*;

public class Ex2{
    public static void main(String[] args){
        final String regex = "^(\\d{2}\\/{1}){2}\\d{4}$";
        String nome, endereco, nasc;
        GregorianCalendar nascg;
        Usuario user;
        Biblioteca biblioteca = new Biblioteca();
        int opt, codigo;
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Escolha uma opcao: ");
            System.out.println("---------------------");
            System.out.println("1 - Salvar usuario. ");
            System.out.println("2 - Salvar livro. ");
            System.out.println("3 - Salvar em arquivo. ");
            System.out.println("4 - Sair.");
            try{
                opt = Integer.parseInt(inData.readLine());
                if(opt == 1){
                    System.out.println("Cadastro de usuario.");
                    System.out.println("---------------------");
                    System.out.println("Digite o nome: ");
                    nome = inData.readLine();
                    System.out.println("Digite o endereco: ");
                    endereco = inData.readLine();
                    while(true){
                        System.out.println("Digite a data de nasc:(00/00/0000) ");
                        nasc = inData.readLine();
                        if(nasc.matches(regex)){
                            nascg = new GregorianCalendar(Integer.parseInt(nasc.substring(6,10)), Integer.parseInt(nasc.substring(3,5)), Integer.parseInt(nasc.substring(0,2))); 
                            break;

                        }
                        else{
                            System.out.println("Data em formato invalido, tente novamente.");
                        }
                    }
                    System.out.println("Digite o codigo: ");
                    codigo = Integer.parseInt(inData.readLine());
                    user = new Usuario(endereco, codigo, nome, nascg);
                    biblioteca.cadastraUsuario(user);
                    System.out.println(biblioteca.imprimeUsuarios());
                }
                else if(opt == 2){

                }
                else if(opt == 3){

                }
                else if(opt == 4){
                    break;
                }
                else{
                    System.out.println("Opcao invalida, tente novamente.");
                }
            }
            catch(IOException e){
                System.out.println(e);
            }
            catch(NumberFormatException e){
                System.out.println(e);
            }
        }
    }
}