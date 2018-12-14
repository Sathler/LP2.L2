package lp2g37.biblioteca;

import java.util.*;

public class Converte{
    final static String regex = "^(\\d{2}\\/{1}){2}\\d{4}$";

    public static GregorianCalendar cvtStringGCalendar(String txt) throws StringInvalidaEx{
        GregorianCalendar date;
        if(txt.matches(regex)){
            date = new GregorianCalendar(Integer.parseInt(txt.substring(6,10)), Integer.parseInt(txt.substring(3,5)), Integer.parseInt(txt.substring(0,2)));
            return date;
        }
        else{
            throw new StringInvalidaEx("Escreva uma data valida para continuar.");
        }
    }
}