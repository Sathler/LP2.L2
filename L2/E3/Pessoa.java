class Pessoa{
    protected String nome, dataNascimento;

    public Pessoa(String nome, String data){
        this.nome = nome;
        this.dataNascimento = data;
    }

    public String toString(){
        String saida = String.format("Nome: %s\nData de Nascimento: %s\n", nome, dataNascimento);
        return saida;
    }
}
