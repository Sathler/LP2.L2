package lp2g37.biblioteca;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class EmprestadoPara implements Serializable{
    private static final long serialVersionUID = 1L;
    GregorianCalendar emprestimo, devolucao;
    int codigoUsuario;

    public EmprestadoPara(GregorianCalendar emp, GregorianCalendar dev, int cod){
        this.emprestimo = emp;
        this.devolucao = dev;
        this.codigoUsuario = cod;
    }

    public int getCodigo(){
        return codigoUsuario;
    }

    public String imprime(){
        return codigoUsuario+"   "+Converte.imprimeGCalendar(emprestimo)+"   "+Converte.imprimeGCalendar(devolucao);
    }

}

// A classe EmprestadoPara deve conter a data do empréstimo, data de devolução e o código do
// usuário que pegou o livro emprestado.