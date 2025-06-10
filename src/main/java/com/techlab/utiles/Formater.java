package com.techlab.utiles;

public class Formater {
    public static String formatearNombre(String nombre){
        StringBuilder nombreFormateado = new StringBuilder();
        String [] palabras = nombre.trim().toLowerCase().split(" ");
        for (String palabra: palabras){
            if(!palabra.isEmpty()){
                nombreFormateado.append(palabra.toUpperCase().charAt(0)).append(palabra.substring(1).toLowerCase());
                nombreFormateado.append(" ");
            }
        }
        return nombreFormateado.toString();
    }
}
