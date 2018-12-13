import java.util.GregorianCalendar;

public class Emprestimo{
    GregorianCalendar emprestimo, devolucao;
    int codigo;

    public Emprestimo(GregorianCalendar emp, GregorianCalendar dev, int cod){
        this.codigo = cod;
        this.emprestimo = emp;
        this.devolucao = dev;
    }

    public int getCodigo(){
        return codigo;
    }
}