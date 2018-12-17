class NoGenderException extends Exception{
    String mensagem;
    
    public NoGenderException(String s){
        mensagem = s;
    }

    public String toString(){
        return mensagem;
    }
}
