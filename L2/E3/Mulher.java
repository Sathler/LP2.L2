class Mulher extends PessoaIMC{

    public Mulher(String nome, String data, double peso, double altura){
        super(nome, data, peso, altura);
    }
    
    protected String resultIMC(){
        double imc = calculaIMC();
        if(imc < 19){
            return "Abaixo do peso ideal.";
        }
        else if(imc <= 25.8){
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
