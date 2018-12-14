import lp2g37.biblioteca.*;

public class Manutencao{
    public static void main(String[] args){
        //final String users_path = ".."+File.separator+"data"+File.separator+"users.data";
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.salvaArquivo("users.tmp", biblioteca.Usuarios);
        biblioteca.salvaArquivo("books.tmp", biblioteca.Livros);
    }
}

//".."+File.separator+"data"+File.separator+"users.data"