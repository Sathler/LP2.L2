package lp2g37.biblioteca;

public class LivroNaoEmprestadoEx extends Exception{
    String msg;

    public LivroNaoEmprestadoEx(String e){
        this.msg = e;
    }

    public String ToString(){
        return msg;
    }
}