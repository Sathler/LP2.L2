public class CopiaNaoDisponivelEx extends Exception{
    String msg;

    public CopiaNaoDisponivelEx(String e){
        this.msg = e;
    }

    public String ToString(){
        return msg;
    }
}