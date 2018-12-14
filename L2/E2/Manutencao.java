import lp2g37.biblioteca.*;

public class Manutencao{
    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.salvaArquivo("users.tmp", biblioteca.Usuarios);
        biblioteca.salvaArquivo("books.tmp", biblioteca.Livros);
    }
}