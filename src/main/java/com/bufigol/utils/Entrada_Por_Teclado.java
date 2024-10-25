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
    public static int pedirEntero(String mensaje) {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println(mensaje);
            return pedirEntero(sc);
        } catch (Exception e) {
            System.out.println("Error: Debe ser un numero entero");
            return pedirEntero(mensaje);
        }
    }
    public static String pedirCadena(String mensaje){
        try{
        String out;
        System.out.print(mensaje);
        Scanner sc = new Scanner(System.in);
        out = sc.nextLine();
        return out;
        } catch (Exception e) {
            System.out.println("Error en la entrada de datos.");
            return pedirCadena(mensaje);
        }
    }
}
