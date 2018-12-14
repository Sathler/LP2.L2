package lp2g37.biblioteca;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Emprestimo implements Serializable{
    private static final long serialVersionUID = 1L;
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

    public String imprime(){
        return codigo+"   "+Converte.imprimeGCalendar(emprestimo)+"   "+Converte.imprimeGCalendar(devolucao);
    }
}