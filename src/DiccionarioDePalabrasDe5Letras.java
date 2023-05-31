/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author domi1
 */
public class DiccionarioDePalabrasDe5Letras {
    private ArrayList<String> palabras;

    public DiccionarioDePalabrasDe5Letras(String archivo) {
        palabras = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(new File(archivo));
            while (sc.hasNextLine()) {
                String palabra = sc.nextLine();
                if (palabra.length() == 5) {
                    palabras.add(palabra);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + archivo);
        }
    }

    public ArrayList<String> obtenerPalabras() {
        return palabras;
    }
    
    }


