package com.bufigol.utils;

import java.util.Scanner;

public class Entrada_Por_Teclado {

    public static int pedirEntero(Scanner sc) {
        try{
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Error: Debe ser un numero entero");
            return pedirEntero(sc);
        }
    }
    public static double pedirDouble(Scanner sc) {
        try{
            return sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Error: Debe ser un numero entero");
            return pedirDouble(sc);
        }
    }
}
