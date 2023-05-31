/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author domi1
 */
public class PalabraAlAzar {
    private String palabra;

    public PalabraAlAzar(DiccionarioDePalabrasDe5Letras diccionario) {
        ArrayList<String> palabras = diccionario.obtenerPalabras();
        Random rand = new Random();
        palabra = palabras.get(rand.nextInt(palabras.size()));
    }

    public String obtenerPalabra() {
        return palabra;
    }
}

