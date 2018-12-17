class Homem extends PessoaIMC{

    public Homem(String nome, String data, double peso, double altura){
        super(nome, data, peso, altura);
    }
    
    protected String resultIMC(){
        double imc = calculaIMC();
        if(imc < 20.7){
            return "Abaixo do peso ideal.";
        }
        else if(imc <= 26.4){
            return "Peso ideal";
        }
        else{
            return "Acima do peso ideal.";
        }
    }

    public String toString(){
        String saida = String.format("Nome: %s\nData de Nascimento: %s\nPeso: %.2f\nAltura: %.2f\nIMC: %.2f %s\n", nome, dataNascimento, peso, altura, calculaIMC(), resultIMC());
        return saida;
    }
}
