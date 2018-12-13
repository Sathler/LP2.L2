import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Usuario extends Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;
    String endereco;
    int codigoUsuario;
    ArrayList<Emprestimo> Historico;

    public Usuario(String endereco, int codigo, String nome, GregorianCalendar nasc){
        super(nome, nasc);
        this.endereco = endereco;
        this.codigoUsuario = codigo;
        Historico = new ArrayList<Emprestimo>();
    }

    public int getCodigo(){
        return codigoUsuario;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getNome(){
        return nome;
    }

    public GregorianCalendar getNasc(){
        return dataNasc;
    }

    public String getNascString(){
        String txt;
        txt = dataNasc.get(Calendar.DAY_OF_MONTH)+"/"+dataNasc.get(Calendar.MONTH)+"/"+dataNasc.get(Calendar.YEAR);
        return txt;
    }

    public void addLivroHist(GregorianCalendar loc, GregorianCalendar dev, int cod){
        Emprestimo emp = new Emprestimo(loc, dev, cod);
        Historico.add(emp);
    }
}