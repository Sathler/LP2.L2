package lp2g37.biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import lp2g37.biblioteca.EmprestadoPara;

public class Livro implements Serializable{
    private static final long serialVersionUID = 1L;
    String titulo, categoria;
    int quantidade, emprestados, codigo;
    ArrayList<EmprestadoPara> Historico;

    public Livro(int cod, String titulo, String categoria, int qtd){
        this.codigo = cod;
        this.titulo = titulo;
        this.categoria = categoria;
        this.quantidade = qtd;
        this.emprestados = 0;
        Historico = new ArrayList<EmprestadoPara>();
    }

    public int getCodigo(){
        return codigo;
    }

    public String getTitle(){
        return titulo;
    }

    public String getCategoria(){
        return categoria;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public int getEmprestados(){
        return emprestados;
    }

    public void empresta() throws CopiaNaoDisponivelEx{
        if(emprestados < quantidade){
            emprestados++;
        }
        else{
            throw new CopiaNaoDisponivelEx("Copia nao disponivel.");
        }
    }
    public void devolve() throws NenhumaCopiaEmprestadaEx{
        if(emprestados > 0){
            emprestados--;
        }
        else{
            throw new NenhumaCopiaEmprestadaEx("Nenhuma copia emprestada.");
        }
    }

    public void addUsuarioHist(GregorianCalendar emp, GregorianCalendar dev, int cod){
        EmprestadoPara empr = new EmprestadoPara(emp, dev, cod);
        Historico.add(empr);
    }

    public void imprimeHist(){
        EmprestadoPara emp;
        System.out.println("Historico de emprestimos de "+titulo);
        System.out.println("---------------------");
        System.out.println("Usuario Emprestimo Devolucao");
        System.out.println("---------------------");
        for(int i=0; i<Historico.size();i++){
            emp = Historico.get(i);
            System.out.println(emp.imprime());
        }
    }

    public void consulta(){
        System.out.println("--------------------\n"+titulo+"\n--------------------\nCodigo: "+codigo+"\nCategoria: "+categoria+"\nQuantidade: "+quantidade+"\nEmprestados: "+emprestados+"\n\n");
        imprimeHist();
    }
}