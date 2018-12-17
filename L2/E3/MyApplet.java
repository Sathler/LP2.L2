import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

import javax.swing.*;

public class MyApplet extends JApplet implements ActionListener{
    // #####################################################################
    JButton salvar;
    JRadioButton homem, mulher;
    String[] botaoDeSelecaoString={"1.Alfabetica (A-Z)","2.Alfabetica (Z-A)","3.Menor Peso","4.Maior Peso","5.Menor Altura","6.Menor IMC","7.Homem / Mulher"};
    JComboBox ordenacao;
    ButtonGroup genderG;
    JTextField NomeT, DataT, AlturaT, PesoT;
    JTextArea listagem;
    JLabel NomeL, DataL, AlturaL, PesoL;
    JPanel NomeP, DataP, AlturaP, PesoP, salvarP, genderP;
    Panel p;
    Container cp;

    JFrame frame = new JFrame("FrameDemo");

    // #####################################################################

    MinhaListaOrdenavel lista = new MinhaListaOrdenavel();
    
    PessoaIMC pessoa;
    int opt;
    ArrayList<PessoaIMC> ordenado;
    final String regex = "^\\d{2}\\/{1}\\d{2}\\/{1}\\d{4}$";
    
    public void init(){
        lista.add(new Homem("Vinicius", "27/03/1992" , 100, 1.80));
        lista.add(new Homem("Alberto", "14/04/1989", 75, 1.65));
        lista.add(new Homem("Gilberto", "13/05/1990", 70, 1.85));
        lista.add(new Homem("Gustavo", "02/06/1998", 90, 1.60));
        lista.add(new Homem("Leonardo", "30/07/1991", 80, 1.95));
        lista.add(new Mulher("Carlota", "22/08/1997", 60, 1.75));
        lista.add(new Mulher("Elizabeth", "15/09/1994", 65, 1.55));
        lista.add(new Mulher("Ingrid", "19/10/1993", 95, 2.00));
        lista.add(new Mulher("Jessica", "07/11/1970", 55, 1.70));
        lista.add(new Mulher("Marcela", "02/12/1985", 85, 1.90));
        genderG = new ButtonGroup();
        genderP = new JPanel();
        homem = new JRadioButton("Homem");
        mulher = new JRadioButton("Mulher");
        genderG.add(homem);
        genderG.add(mulher);
        genderP.add(homem);
        genderP.add(mulher);
        NomeT = new JTextField(20);
        DataT = new JTextField(20);
        AlturaT = new JTextField(20);
        PesoT = new JTextField(20);
        NomeL = new JLabel("Nome: ");
        DataL = new JLabel("Data: ");
        AlturaL = new JLabel("Altura: ");
        PesoL = new JLabel("Peso: ");
        NomeP = new JPanel();
        DataP = new JPanel();
        AlturaP = new JPanel();
        PesoP = new JPanel();
        NomeP.add(NomeL);
        NomeP.add(NomeT);
        DataP.add(DataL);
        DataP.add(DataT);
        AlturaP.add(AlturaL);
        AlturaP.add(AlturaT);
        PesoP.add(PesoL);
        PesoP.add(PesoT);
        salvar = new JButton("Salvar");
        salvar.addActionListener(this);
        salvarP = new JPanel();
        salvarP.add(salvar);
        ordenacao = new JComboBox(botaoDeSelecaoString);
        ordenacao.addActionListener(this);
        listagem = new JTextArea();
        listagem.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listagem, 
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(300, 450));
        p = new Panel();
        p.add(genderP);
        p.add(NomeP);
        p.add(DataP);
        p.add(AlturaP);
        p.add(PesoP);
        p.add(salvarP);
        p.add(ordenacao);
        p.add(scrollPane);
        cp = getContentPane();
        cp.add(p);
        
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof JButton){
            try{
                if(NomeT.getText().isEmpty()){
                    throw new NoNameEx("");
                }
                if(!DataT.getText().matches(regex)){
                    throw new DateFormatEx("");
                }
                if(Double.parseDouble(PesoT.getText()) <= 0 || Double.parseDouble(AlturaT.getText()) <= 0){
                    throw new NegativeValueException("");
                }
                if(homem.isSelected()){
                    pessoa = new Homem(NomeT.getText(), DataT.getText(), Double.parseDouble(PesoT.getText()), Double.parseDouble(AlturaT.getText()));
                    lista.add(pessoa);
                }
                else if(mulher.isSelected()){
                    pessoa = new Mulher(NomeT.getText(), DataT.getText(), Double.parseDouble(PesoT.getText()), Double.parseDouble(AlturaT.getText()));
                    lista.add(pessoa);
                }
                else{
                    throw new NoGenderException("");
                }
                listagem.setText("");
                ordenado = lista.Ordena(ordenacao.getSelectedIndex()+1);
                for(int i=0; i<ordenado.size(); i++){
                    listagem.append(ordenado.get(i).toString());
                    listagem.append("-------------------\n");
                    
                }
            }
            catch(NumberFormatException f){
                JOptionPane.showMessageDialog(frame, "Valores de peso e altura devem ser numeros");
            }
            catch(DateFormatEx f){
                JOptionPane.showMessageDialog(frame, "Data em formato invalido.");
            }
            catch(NegativeValueException f){
                JOptionPane.showMessageDialog(frame, "Numeros nao podem ser negativos.");
            }
            catch(NoNameEx f){
                JOptionPane.showMessageDialog(frame, "Nome nao pode estar vazio.");
            }
            catch(NoGenderException f){
                JOptionPane.showMessageDialog(frame, "Deve selecionar um sexo.");
            }
        }

        if(e.getSource() instanceof JComboBox){
            listagem.setText("");
            ordenado = lista.Ordena(ordenacao.getSelectedIndex()+1);
            for(int i=0; i<ordenado.size(); i++){
                listagem.append(ordenado.get(i).toString());
                listagem.append("-------------------\n");
                
            }
        }

    }

    class Panel extends JPanel {

        public void paintComponent (java.awt.Graphics g) {
               super.paintComponent(g);
        }
    }
}