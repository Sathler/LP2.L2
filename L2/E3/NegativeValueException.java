class NegativeValueException extends Exception{
    String mensagem;
    
    public NegativeValueException(String s){
        mensagem = s;
    }

    public String toString(){
        return mensagem;
    }
}
