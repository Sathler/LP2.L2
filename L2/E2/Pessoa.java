import java.util.GregorianCalendar;

public class Pessoa{
    String nome;
    GregorianCalendar dataNasc;
    
    public Pessoa(String nome, GregorianCalendar nasc){
        this.nome = nome;
        this.dataNasc = nasc;
    }
}