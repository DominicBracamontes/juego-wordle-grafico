/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consola;
import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import uabc_practica5B_1182812.Interfaces.ITeclado;
/**
 *
 * @author domi1
 */
public class TecladoConsola implements ITeclado{
    private ArrayList<ArrayList<String>> teclado;
    
    public TecladoConsola() {
        teclado = new ArrayList<>();
        ArrayList<String> fila1 = new ArrayList<>();
        fila1.add("q");
        fila1.add("w");
        fila1.add("e");
        fila1.add("r");
        fila1.add("t");
        fila1.add("y");
        fila1.add("u");
        fila1.add("i");
        fila1.add("o");
        fila1.add("p");
        ArrayList<String> fila2 = new ArrayList<>();
        fila2.add("a");
        fila2.add("s");
        fila2.add("d");
        fila2.add("f");
        fila2.add("g");
        fila2.add("h");
        fila2.add("j");
        fila2.add("k");
        fila2.add("l");
        ArrayList<String> fila3 = new ArrayList<>();
        fila3.add("z");
        fila3.add("x");
        fila3.add("c");
        fila3.add("v");
        fila3.add("b");
        fila3.add("n");
        fila3.add("m");
        teclado.add(fila1);
        teclado.add(fila2);
        teclado.add(fila3);
    }
    
    public void marcarLetra(String palabra1, String palabra2, int i) {
        ArrayList<ArrayList<String>> tecladoActualizado = new ArrayList<>(teclado);
        char[] letrasPalabra1 = palabra1.toCharArray();
        char[] letrasPalabra2 = palabra2.toCharArray();
        for (char letra : letrasPalabra1) {
            boolean existeEnPalabra2 = false;
            boolean mismaPosicion = false;
            for ( i = 0; i < letrasPalabra2.length; i++) {
                if (letrasPalabra2[i] == letra) {
                    if (i == (letrasPalabra1.length - letrasPalabra2.length + i)) {
                        mismaPosicion = true;
                    } else {
                        existeEnPalabra2 = true;
                    }
                }
            }
            if (mismaPosicion) {
                for (ArrayList<String> fila : tecladoActualizado) {
                    if (fila.contains(Character.toString(letra))) {
                        int index = fila.indexOf(Character.toString(letra));
                        fila.set(index, "(" + letra + ")");
                    }
                }
            } else if (existeEnPalabra2) {
                for (ArrayList<String> fila : tecladoActualizado) {
                    if (fila.contains(Character.toString(letra))) {
                        int index = fila.indexOf(Character.toString(letra));
                        fila.set(index, "{" + letra + "}");
                    }
                }
            } else {
                for (ArrayList<String> fila : tecladoActualizado) {
                    if (fila.contains(Character.toString(letra))) {
                        int index = fila.indexOf(Character.toString(letra));
                        fila.set(index, "[" + letra + "]");
                    }
                }
            }
        }
        teclado = tecladoActualizado;
    }
    
    public void mostrarTeclado() {
         for (int i = 0; i < 3; i++) {
        ArrayList<String> fila = teclado.get(i);
        String filaStr = String.join(" ", fila);
        System.out.println(filaStr);
    }
    }
    
   public void mostrarTeclado(Canvas canvas){
       
   }

    @Override
    public void marcarLetra(String letra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
