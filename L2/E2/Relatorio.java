import java.io.*;
import java.util.*;
import lp2g37.biblioteca.*;

public class Relatorio{
    public static void main(String[] args){
        int opt, codigo;
        Usuario user;
        Livro book;
        Biblioteca biblioteca = new Biblioteca("users.tmp", "books.tmp");
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                System.out.println("Escolha uma opcao: ");
                System.out.println("---------------------");
                System.out.println("1 - Listar usuarios. ");
                System.out.println("2 - Listar livros. ");
                System.out.println("3 - Consultar usuario.");
                System.out.println("4 - Consultar Livro.");
                System.out.println("5 - Sair.");
                opt = Integer.parseInt(inData.readLine());
                if(opt == 1){
                    System.out.println(biblioteca.imprimeUsuarios());
                }
                else if(opt == 2){
                    System.out.println(biblioteca.imprimeLivros());
                }
                else if(opt == 3){
                    try{
                        System.out.println("Digite o codigo do usuario a ser consultado.");
                        codigo = Integer.parseInt(inData.readLine());
                        user = biblioteca.getUsuario(codigo);
                        user.consulta();
                    }
                    catch(UsuarioNaoCadastradoEx e){
                        System.out.println(e);
                    }
                }
                else if(opt == 4){
                    try{
                        System.out.println("Digite o codigo do livro a ser consultado");
                        codigo = Integer.parseInt(inData.readLine());
                        book = biblioteca.getLivro(codigo);
                        book.consulta();
                    }
                    catch(LivroNaoCadastradoEx e){
                        System.out.println(e);
                    }
                }
                else if(opt == 5){
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