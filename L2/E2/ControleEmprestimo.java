import java.io.*;
import java.util.*;
import lp2g37.biblioteca.*;

public class ControleEmprestimo{
    public static void main(String[] args){
        int opt, codigoUsuario, codigoLivro;
        Usuario user;
        Livro book;
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        Biblioteca biblioteca = new Biblioteca("users.tmp", "books.tmp");
        while(true){
            try{
                System.out.println("Escolha uma opcao: ");
                System.out.println("---------------------");
                System.out.println("1 - Listar livros. ");
                System.out.println("2 - Realizar emprestimo. ");
                System.out.println("3 - Sair.");
                opt = Integer.parseInt(inData.readLine());
                if(opt == 1){
                    System.out.println(biblioteca.imprimeLivros());
                }
                else if(opt == 2){
                    while(true){
                        try{
                            System.out.println(biblioteca.imprimeUsuarios());
                            System.out.println("Digite o codigo do usuario que realizara o emprestimo: ");
                            codigoUsuario = Integer.parseInt(inData.readLine());
                            user = biblioteca.getUsuario(codigoUsuario);
                            break;
                        }
                        catch(UsuarioNaoCadastradoEx e){
                            System.out.println(e);
                        }
                    }
                    while(true){
                        try{
                            System.out.println(biblioteca.imprimeLivros());
                            System.out.println("Digite o codigo do livro que sera emprestado: ");
                            codigoLivro = Integer.parseInt(inData.readLine());
                            book = biblioteca.getLivro(codigoLivro);
                            break;
                        }
                        catch(LivroNaoCadastradoEx e){
                            System.out.println(e);
                        }
                    }
                    while(true){
                    
                            biblioteca.emprestaLivro(user, book);
                            biblioteca.Usuarios.remove(codigoUsuario);
                            biblioteca.Usuarios.put(user.getCodigo(), user);
                            biblioteca.Livros.remove(codigoLivro);
                            biblioteca.Livros.put(book.getCodigo(), book);
                            biblioteca.salvaArquivo("users.tmp", biblioteca.Usuarios);
                            biblioteca.salvaArquivo("books.tmp", biblioteca.Livros);
                            user.imprimeHist();
                            break;
                        
                    }
                }
                else if(opt == 3){
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