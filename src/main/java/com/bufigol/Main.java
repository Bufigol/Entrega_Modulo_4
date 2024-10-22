package com.bufigol;


import com.bufigol.vistas.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Menu mn = new Menu();
        mn.iniciarMenu(sc);
    }
}