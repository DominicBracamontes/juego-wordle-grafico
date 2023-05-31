/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author domi1
 */
public class ContrastarPalabras {
    
    private String palabra;

    public ContrastarPalabras(String palabra) {
        this.palabra = palabra;
    }

    public boolean verificarLongitud() {
        return palabra.length() == 5;
    }

    public boolean verificarExistencia(DiccionarioDePalabrasDe5Letras diccionario) {
        return diccionario.obtenerPalabras().contains(palabra);
    }

}

