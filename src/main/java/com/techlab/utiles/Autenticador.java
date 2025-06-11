package com.techlab.utiles;

import java.util.Scanner;

public class Autenticador {
    private static final String USUARIO = "admin";
    private static final String CONTRASEÑA = "1234";

    public static boolean autenticarSuperUsuario(Scanner scanner) {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String clave = scanner.nextLine();

        return usuario.equals(USUARIO) && clave.equals(CONTRASEÑA);
    }
}
