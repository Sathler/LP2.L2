package lp2g37.biblioteca;

public class LivroNaoCadastradoEx extends Exception{
    String msg;

    public LivroNaoCadastradoEx(String e){
        this.msg = e;
    }

    public String ToString(){
        return msg;
    }
}