import lp2g37.biblioteca.*;
import java.io.*;
import java.util.*;

public class Cadastro{
    public static void main(String[] args){
        
        String nome, endereco, nasc, categoria;
        GregorianCalendar nascg;
        Usuario user;
        Livro book;
        Biblioteca biblioteca = new Biblioteca("users.tmp", "books.tmp");
        int opt, codigo, qntd;
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            
            System.out.println("Escolha uma opcao: ");
            System.out.println("---------------------");
            System.out.println("1 - Salvar usuario. ");
            System.out.println("2 - Salvar livro. ");
            System.out.println("3 - Salvar em arquivo. ");
            System.out.println("4 - Sair.");
            try{
                try{
                    opt = Integer.parseInt(inData.readLine());
                }
                catch(NumberFormatException e){
                    opt = 5;
                }
                if(opt == 1){
                    System.out.println("Cadastro de usuario.");
                    System.out.println("---------------------");
                    System.out.println("Digite o nome: ");
                    nome = inData.readLine();
                    System.out.println("Digite o endereco: ");
                    endereco = inData.readLine();
                    while(true){
                        try{
                            System.out.println("Digite a data de nasc:(00/00/0000) ");
                            nasc = inData.readLine();
                            nascg = Converte.cvtStringGCalendar(nasc);
                            break;
                        }
                        catch(StringInvalidaEx e){
                            System.out.println(e);
                        }
                    }
                    System.out.println("Digite o codigo: ");
                    while(true){
                        try{
                            codigo = Integer.parseInt(inData.readLine());
                            if(codigo <= 0){
                                System.out.println("Codigo deve ser um valor inteiro positivo.");
                            }
                            else{
                                if(!biblioteca.Usuarios.containsKey(codigo)){
                                    break;
                                }
                                else{
                                    System.out.println("Codigo ja cadastrado.");
                                }
                            }
                        }
                        catch(NumberFormatException e){
                            System.out.println("Codigo deve ser um valor inteiro positivo.");
                        }
                    }
                    user = new Usuario(endereco, codigo, nome, nascg);
                    biblioteca.cadastraUsuario(user);
                    
                }
                else if(opt == 2){
                    System.out.println("Cadastro de livros.");
                    System.out.println("---------------------");
                    System.out.println("Digite o titulo: ");
                    nome = inData.readLine();
                    System.out.println("Digite a categoria: ");
                    categoria = inData.readLine();
                    System.out.println("Digite a quantidade: ");
                    while(true){
                        try{
                            qntd = Integer.parseInt(inData.readLine());
                            if(qntd <= 0){
                                System.out.println("Valor deve ser um inteiro maior do que zero");
                            }
                            else{
                                break;
                            }
                        }
                        catch(NumberFormatException e){
                            System.out.println("Valor deve ser um inteiro maior do que zero.");
                        }
                    }
                    System.out.println("Digite o codigo: ");
                    while(true){
                        try{
                            codigo = Integer.parseInt(inData.readLine());
                            if(codigo <= 0){
                                System.out.println("Codigo deve ser um valor inteiro positivo.");
                            }
                            else{
                                if(!biblioteca.Livros.containsKey(codigo)){
                                    break;
                                }
                                else{
                                    System.out.println("Esse codigo ja foi cadastrado.");
                                }
                            }
                        }
                        catch(NumberFormatException e){
                            System.out.println("Codigo deve ser um valor inteiro positivo.");
                        }
                    }
                    book = new Livro(codigo, nome, categoria, qntd);
                    biblioteca.cadastraLivro(book);
                }
                else if(opt == 3){
                    while(true){
                        System.out.println("Escolha a tabela a ser salva. ");
                        System.out.println("---------------------");
                        System.out.println("1 - Usuarios.");
                        System.out.println("2 - Livros.");
                        System.out.println("3 - Voltar.");
                        System.out.println("---------------------");
                        try{
                            opt = Integer.parseInt(inData.readLine());
                        }
                        catch(NumberFormatException e){
                            opt = 4;
                        }
                        if(opt == 1){
                            biblioteca.salvaArquivo("users.tmp", biblioteca.Usuarios);
                            System.out.println("arquivo salvo com sucesso.");
                        }
                        else if(opt == 2){
                            biblioteca.salvaArquivo("books.tmp", biblioteca.Livros);
                            System.out.println("arquivo salvo com sucesso.");
                        }
                        else if(opt == 3){
                            break;
                        }
                        else{
                            System.out.println("Opcao invalida, escolha novamente.");
                        }
                    }
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
        }
    }
}