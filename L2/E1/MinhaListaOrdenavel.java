import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MinhaListaOrdenavel{
    private ArrayList lista;

    public MinhaListaOrdenavel(){
        lista = new ArrayList<PessoaIMC>();
    }

    public void add(PessoaIMC p){
        lista.add(p);
    }

    public PessoaIMC get(int index){
        return (PessoaIMC)lista.get(index);
    }

    public Comparator pesoC = new Comparator () {
        public int compare (Object p1, Object p2){
            double pf1, pf2;
            pf2 = ((PessoaIMC)p2).getPeso();
            pf1 = ((PessoaIMC)p1).getPeso();
            return (int)Math.round (pf2-pf1);
        }
    };

    public Comparator alturaC = new Comparator () {
        public int compare (Object p1, Object p2){
            double af1, af2;
            af2 = ((PessoaIMC)p2).getAltura()*100;
            af1 = ((PessoaIMC)p1).getAltura()*100;
            return (int)Math.round (af2-af1);
        }
    };
    public Comparator imcC = new Comparator () {
        public int compare (Object p1, Object p2){
            double imc1, imc2;
            imc2 = ((PessoaIMC)p2).calculaIMC()*100;
            imc1 = ((PessoaIMC)p1).calculaIMC()*100;
            return (int)Math.round (imc2-imc1);
        }
    };
    public Comparator nomeC = new Comparator () {
        public int compare (Object p1, Object p2){
            String n1, n2;
            n2 = ((PessoaIMC)p2).getNome();
            n1 = ((PessoaIMC)p1).getNome();
            return n2.compareTo(n1);
        }
    };
    public Comparator genderC = new Comparator () {
        public int compare (Object p1, Object p2){
            PessoaIMC a1 = (PessoaIMC)p1;
            PessoaIMC a2 = (PessoaIMC)p2;
            int g1 = -1, g2 = -1;
            String n1, n2;
            if(a1 instanceof Homem){
                g1 = 1;
            }
            if(a2 instanceof Homem){
                g2 = 1;
            }
            if(g1 != g2){
                return g2-g1;
            }
            else{
                n1 = a1.getNome();
                n2 = a2.getNome();
                return n1.compareTo(n2);
            }
        }
    };

    public ArrayList Ordena(int param){
        switch (param){
            case 1:
                Collections.sort(this.lista, nomeC.reversed());   
                break;
            case 2:
                Collections.sort(this.lista, nomeC);   
                break;
            case 3:
                Collections.sort(this.lista, pesoC.reversed());   
                break;
            case 4:
                Collections.sort(this.lista, pesoC);   
                break;
            case 5:
                Collections.sort(this.lista, alturaC.reversed());   
                break;
            case 6:
                Collections.sort(this.lista, imcC.reversed());   
                break;
            case 7:
                Collections.sort(this.lista, genderC);   
                break;
            default:
                break;
        }
        return this.lista;
    }


}

// 1.Alfabetica (A-Z) – nome da pessoa
// 2.Alfabetica (Z-A) – nome da pessoa
// 3.Menor Peso - crescente
// 4.Maior Peso - decrescente
// 5.Menor Altura – crescente, do mais baixo para o mais alto
// 5.Menor IMC - crescente, do mais baixo para o mais alto
// 6.Homem / Mulher – ordenar por gênero * esse é desafio