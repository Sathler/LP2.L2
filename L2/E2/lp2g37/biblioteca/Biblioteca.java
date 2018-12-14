package lp2g37.biblioteca;

import java.io.*;
import java.util.*;

public class Biblioteca{
    public Hashtable Usuarios, Livros;

    public Biblioteca(){
        this.Usuarios = new Hashtable<Integer, Usuario>();
        this.Livros = new Hashtable<Integer, Livro>();
    }

    public Biblioteca(String users, String books){
        Hashtable hu = new Hashtable<Integer, Usuario>();
        Hashtable hl = new Hashtable<Integer, Livro>();
        try{
            FileInputStream f = new FileInputStream(users);
            ObjectInputStream o = new ObjectInputStream(f);
            hu = (Hashtable)o.readObject();
            this.Usuarios = hu;
            f = new FileInputStream(books);
            o = new ObjectInputStream(f);
            hl = (Hashtable)o.readObject();
            this.Livros = hl;
            o.close();
            f.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }

    public void cadastraUsuario(Usuario user){
        Usuarios.put(user.getCodigo(), user);
    }

    public void cadastraLivro(Livro book){
        Livros.put(book.getCodigo(), book);
    }

    public void salvaArquivo(String arq, Hashtable table){
        try{
            FileOutputStream f = new FileOutputStream(arq);
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(table);

            o.close();
            f.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public void leArquivo(){

    }

    public void emprestaLivro(Usuario user, Livro book){
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar deadline = new GregorianCalendar();
        deadline.add(Calendar.DAY_OF_MONTH, 3);
        try{
            book.empresta(); 
            user.addLivroHist(today, deadline, book.codigo);
            book.addUsuarioHist(today, deadline, user.codigoUsuario);
        }
        catch(CopiaNaoDisponivelEx e){
            System.out.println(e);
        }
    }

    public void devolveLivro(Usuario user, Livro book) throws LivroNaoEmprestadoEx{
        Emprestimo emp = new Emprestimo(new GregorianCalendar(), new GregorianCalendar(), 0);
        int index;
        boolean cond = false;
        GregorianCalendar today = new GregorianCalendar();
        for(int i=user.Historico.size()-1; i>=0; i++){
            emp = user.Historico.get(i);
            if(emp.codigo == book.codigo){
                cond = true;
                index = i;
                break;
            }
        }
        if(cond){
            try{
                book.devolve();
                if(today.compareTo(emp.devolucao) < 0){
                    System.out.println("Devolucao realizada com sucesso.");
                }
                else{
                    System.out.println("Devolucao realizada com atraso, multa sera aplicada.");
                }
            }
            catch(NenhumaCopiaEmprestadaEx e){
                System.out.println(e);
            }
        }
        else{
            throw new LivroNaoEmprestadoEx("Livro nao foi emprestado para o usuario.");
        }
    }

    public Comparator tituloC = new Comparator(){
        public int compare(Object p1, Object p2){
            String ttl1, ttl2;
            ttl2 = ((Livro)p2).getTitle();
            ttl1 = ((Livro)p1).getTitle();
            return ttl1.compareTo(ttl2);
        }
    };

    public String imprimeLivros(){
        Livro livro;
        String txt = "";
        ArrayList<Livro> books = new ArrayList<Livro>(Livros.values());
        Collections.sort(books, tituloC);
        for(int i=0; i<books.size(); i++){
            livro = books.get(i);
            txt+= "--------------------\n"+(i+1)+" "+livro.getTitle()+"\n--------------------\nCodigo: "+livro.getCodigo()+"\nCategoria: "+livro.getCategoria()+"\nQuantidade: "+livro.getQuantidade()+"\nEmprestados: "+livro.getEmprestados()+"\n--------------------\n";
        }
        return txt;
    }

    public Comparator nomeC = new Comparator(){
        public int compare(Object p1, Object p2){
            String n1, n2;
            n2 = ((Usuario)p2).getNome();
            n1 = ((Usuario)p1).getNome();
            return n1.compareTo(n2);
        }
    };

    public String imprimeUsuarios(){
        Usuario user;
        String txt = "";
        ArrayList<Usuario> users = new ArrayList<Usuario>(Usuarios.values());
        Collections.sort(users, nomeC);
        for(int i=0; i<users.size();i++){
            user = users.get(i);
            txt+="--------------------\n"+(i+1)+" "+user.getNome()+"\n--------------------\nCodigo: "+user.getCodigo()+"\nEndereco: "+user.getEndereco()+"\nNascimento: "+user.getNascString()+"\n--------------------\n";
        }
        return txt;
    }

    public Livro getLivro(int cod) throws LivroNaoCadastradoEx{
        Livro livro = (Livro)Livros.get(cod);
        if(livro != null){
            return livro;
        }
        else{
            throw new LivroNaoCadastradoEx("Livro nao cadastrado.");
        }
    }

    public Usuario getUsuario(int cod) throws UsuarioNaoCadastradoEx{
        Usuario user = (Usuario)Usuarios.get(cod);
        if(user != null){
            return user;
        }
        else{
            throw new UsuarioNaoCadastradoEx("Usuario nao cadastrado.");
        }
    }



}