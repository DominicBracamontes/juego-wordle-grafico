/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author domi1
 */
public class BuscadorDePalabras {
    
   private ArrayList<String> palabras;

    public BuscadorDePalabras(ArrayList<String> palabras) {
        this.palabras = palabras;
    }

    public boolean buscarPalabra(String palabra) {
        return palabras.contains(palabra);
    }

    
}

