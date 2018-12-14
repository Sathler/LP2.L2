package lp2g37.biblioteca;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;
    String nome;
    GregorianCalendar dataNasc;
    
    public Pessoa(String nome, GregorianCalendar nasc){
        this.nome = nome;
        this.dataNasc = nasc;
    }
}