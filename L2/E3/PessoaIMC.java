abstract class PessoaIMC extends Pessoa{
    protected double peso, altura;

    public PessoaIMC(String nome, String data, double peso, double altura){
        super(nome, data);
        this.peso = peso;
        this.altura = altura;
    }

    public double getPeso(){
        return this.peso;
    }

    public double getAltura(){
        return this.altura;
    }

    public double calculaIMC(){
        return peso/(altura*altura);
    }

    public String getNome(){
        return this.nome;
    }

    protected abstract String resultIMC();

    public String toString(){
        String saida = String.format("Nome: %s\nData de Nascimento: %s\nPeso: %.2f\nAltura: %.2f\n", nome, dataNascimento, peso, altura);
        return saida;
    }

}
