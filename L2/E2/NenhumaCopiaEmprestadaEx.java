public class NenhumaCopiaEmprestadaEx extends Exception{
    String msg;

    public NenhumaCopiaEmprestadaEx(String e){
        this.msg = e;
    }

    public String ToString(){
        return msg;
    }
}