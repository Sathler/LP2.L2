public class UsuarioNaoCadastradoEx extends Exception{
    String msg;

    public UsuarioNaoCadastradoEx(String e){
        this.msg = e;
    }

    public String ToString(){
        return msg;
    }
}