/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
/**
 *
 * @author domi1
 */
public class Intento {
    private int contadorIntentos;
    private ArrayList<String> intentosAnteriores;
    

    public Intento() {
        
        this.contadorIntentos = 0;
        this.intentosAnteriores = new ArrayList<>();
    }

    public int getContadorIntentos() {
        return contadorIntentos;
    }

    private boolean contrastarPalabras(String palabra1, String palabra2) {
        for (int i = 0; i < palabra1.length(); i++) {
            if (palabra1.charAt(i) != palabra2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}