/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consola;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import uabc_practica5B_1182812.Interfaces.ITablero;

/**
 *
 * @author domi1
 */
public class TableroConsola implements ITablero {
    
    private ArrayList<ArrayList<String>> tablero;
    private int filas;
    private int columnas;
    private int lineaActual;

    public TableroConsola() {
        filas = 6;
        columnas = 5;
        lineaActual = 0;
        this.tablero = new ArrayList<>();
        for (int i = 0; i < filas; i++) {
            ArrayList<String> fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                fila.add("[ ]");
            }
            this.tablero.add(fila);
        }
    }

    public void actualizarTablero(String palabra, String referencia, int linea) {
        char[] letrasPalabra = palabra.toCharArray();
        char[] letrasReferencia = referencia.toCharArray();
        for (int i = 0; i < letrasPalabra.length; i++) {
            char letraPalabra = letrasPalabra[i];
            boolean existeEnReferencia = false;
            boolean mismaPosicion = false;
            int posTablero = i; // nueva variable para la posición en el tablero
            for (int j = 0; j < letrasReferencia.length; j++) {
                char letraReferencia = letrasReferencia[j];
                if (letraReferencia == letraPalabra) {
                    if (i == j) {
                        mismaPosicion = true;
                    } else {
                        existeEnReferencia = true;
                    }
                }
            }
            if (mismaPosicion) {
                this.tablero.get(linea).set(posTablero, "(" + letraPalabra + ")");
            } else if (existeEnReferencia) {
                this.tablero.get(linea).set(posTablero, "{" + letraPalabra + "}");
            } else {
                this.tablero.get(linea).set(posTablero, "[" + letraPalabra + "]");
            }
        }
        lineaActual = linea + 1;
    }

    public void mostrarTablero() {
         for (int i = 0; i < filas; i++) {
        ArrayList<String> fila = tablero.get(i);
        String filaStr = String.join("", fila);
        System.out.println(filaStr);
    }
    for (int i = filas; i < 6; i++) {
        String filaStr = String.join("", Collections.nCopies(columnas, "[ ]"));
        System.out.println(filaStr);
    }
    }

    @Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void colocarPalabra(String palabra, Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}

