/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.HashSet;
import javax.swing.JPanel;
import uabc_practica5B_1182812.Interfaces.ITablero;

/**
 *
 * @author domi1
 */
public class TableroGrafico extends JPanel implements ITablero {

    private final int rows;
    private final int columns;
    private final int squareSize;
    private final int spacing;
    private final Color[] colors;
    private int lineaActual = 0;
    private String[][] tablero;
    private Color[][] coloresTablero; 
    

    public TableroGrafico() {
        
        rows = 6;
        columns = 5;
        squareSize = 50;
        spacing = 10;
        colors = new Color[]{Color.GREEN, Color.YELLOW, Color.GRAY};

        tablero = new String[rows][columns];
        coloresTablero = new Color[rows][columns]; 

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tablero[i][j] = "";
                coloresTablero[i][j] = Color.WHITE; 
            }
        }
    }

    public void colocarPalabra(String palabra) {
         if (lineaActual < rows) {
        String[] letras = palabra.split("");
        for (int i = 0; i < letras.length; i++) {
            if (i < columns) {
                tablero[lineaActual][i] = letras[i];
            } else {
                break;
            }
        }
        lineaActual++;

        // Asegúrate de volver a pintar todo el componente
        repaint();
    } else {
        System.out.println("El tablero está completo. No se puede colocar más palabras.");
    }
    }

    public void cambiarColorCuadro(int fila, int columna, int estado) {
       if (fila >= 0 && fila < rows && columna >= 0 && columna < columns) {
            coloresTablero[fila][columna] = colors[estado];
            repaint(); // Vuelve a dibujar el tablero
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        
        
        // Dibujar el título "JUEGO WORDLE"
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        FontMetrics titleMetrics = g.getFontMetrics();
        int titleWidth = titleMetrics.stringWidth("JUEGO WORDLE");
        int titleX = (getWidth() - titleWidth) / 2;
        int titleY = 50;
        g.drawString("JUEGO WORDLE", titleX, titleY);
    
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        int startX = (getWidth() - columns * (squareSize + spacing)) / 2;
        int startY = spacing;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int x = startX + j * (squareSize + spacing);
                int y = startY + i * (squareSize + spacing);

                g.setColor(coloresTablero[i][j]);
                g.fillRect(x, y, squareSize, squareSize);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, squareSize, squareSize);

                String letra = tablero[i][j];
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                FontMetrics fm = g.getFontMetrics();
                int letraX = x + (squareSize - fm.stringWidth(letra)) / 2;
                int letraY = y + ((squareSize - fm.getHeight()) / 2) + fm.getAscent();
                g.drawString(letra, letraX, letraY);
            }
        }
    }
    
    public Dimension getPreferredSize() {
        int width = columns * (squareSize + spacing) + spacing;
        int height = rows * (squareSize + spacing) + spacing;
        return new Dimension(width, height);
    } 
    
    @Override
    public void actualizarTablero(String palabra, String referencia, int linea) {
        
       char[] letrasPalabra = palabra.toCharArray();
    char[] letrasReferencia = referencia.toCharArray();

    // Almacena las letras que ya han sido encontradas en la palabra oculta
    HashSet<Character> letrasEncontradasOculta = new HashSet<>();

    for (int i = 0; i < letrasPalabra.length; i++) {
        char letraPalabra = letrasPalabra[i];
        boolean mismaPosicion = false;
        boolean existeEnReferencia = false;
        int posTablero = i; // nueva variable para la posición en el tablero

        for (int j = 0; j < letrasReferencia.length; j++) {
            char letraReferencia = letrasReferencia[j];

            if (letraReferencia == letraPalabra) {
                if (i == j) {
                    mismaPosicion = true;
                    break; // Sale del bucle si la letra está en la posición correcta
                } else {
                    existeEnReferencia = true;
                }
            }
        }

        // Verifica si la letra ya ha sido encontrada previamente en la palabra oculta
        boolean letraEncontradaOculta = letrasEncontradasOculta.contains(letraPalabra);

        if (posTablero < columns && linea < rows) {
            if (mismaPosicion) {
                coloresTablero[linea][posTablero] = Color.GREEN;
                letrasEncontradasOculta.add(letraPalabra);
            } else if (existeEnReferencia && !letraEncontradaOculta) {
                coloresTablero[linea][posTablero] = Color.YELLOW;
                letrasEncontradasOculta.add(letraPalabra);
            } else {
                coloresTablero[linea][posTablero] = Color.GRAY;
            }
        }
    }

    repaint(); // Vuelve a dibujar el tablero con los nuevos colores
}
    
   
    @Override
    public void mostrarTablero() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void colocarPalabra(String palabra, Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }

