/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafico;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import uabc_practica5B_1182812.Interfaces.ITeclado;
/**
 *
 * @author domi1
 */
public class TecladoGrafico extends JPanel implements ITeclado {
    
    private ArrayList<ArrayList<Letra>> teclado;
    private ArrayList<ArrayList<Boolean>> letrasMarcadas;
    
    private final int filaHeight = 40;
    private final int letraWidth = 40;
    private final int spacing=5;
    private final Font letraFont = new Font("Arial", Font.PLAIN, 20);
    private ArrayList<Letra> letras;
    
    private int rows ;
    private int columns;
    private Color[][] coloresTablero; 
    private final Color[] colors;
    private HashMap<Character, Letra> letrasTeclado;


    public TecladoGrafico() {
    inicializarTeclado();
    colors = new Color[]{Color.GREEN, Color.YELLOW, Color.GRAY};
    rows = teclado.size();
    columns = teclado.get(0).size();
    coloresTablero = new Color[rows][columns];
    letrasTeclado = new HashMap<>();

    setPreferredSize(new Dimension(getTecladoWidth(), getTecladoHeight()));
    }
    
    private int getTecladoWidth() {
        int columnas = teclado.get(0).size();
        return columnas * (letraWidth + spacing) + spacing;
    }
    
     private int getTecladoHeight() {
        int filas = teclado.size();
        return filas * (filaHeight + spacing) + spacing;
    }
    
     private void inicializarTeclado() {
         teclado = new ArrayList<>();
    letras = new ArrayList<>();

    // Fila 1
    ArrayList<Character> fila1 = new ArrayList<>();
    fila1.add('q');
    fila1.add('w');
    fila1.add('e');
    fila1.add('r');
    fila1.add('t');
    fila1.add('y');
    fila1.add('u');
    fila1.add('i');
    fila1.add('o');
    fila1.add('p');
    teclado.add(new ArrayList<>());

    for (char c : fila1) {
        Letra letra = new Letra(c, EstadoLetra.NORMAL);
        teclado.get(0).add(letra);
        letras.add(letra);
    }

    // Fila 2
    ArrayList<Character> fila2 = new ArrayList<>();
    fila2.add('a');
    fila2.add('s');
    fila2.add('d');
    fila2.add('f');
    fila2.add('g');
    fila2.add('h');
    fila2.add('j');
    fila2.add('k');
    fila2.add('l');
    teclado.add(new ArrayList<>());

    for (char c : fila2) {
        Letra letra = new Letra(c, EstadoLetra.NORMAL);
        teclado.get(1).add(letra);
        letras.add(letra);
    }

    // Fila 3
    ArrayList<Character> fila3 = new ArrayList<>();
    fila3.add('z');
    fila3.add('x');
    fila3.add('c');
    fila3.add('v');
    fila3.add('b');
    fila3.add('n');
    fila3.add('m');
    teclado.add(new ArrayList<>());

    for (char c : fila3) {
        Letra letra = new Letra(c, EstadoLetra.NORMAL);
        teclado.get(2).add(letra);
        letras.add(letra);
    }

    // Actualizar el número de filas y columnas del teclado
    rows = teclado.size();
    columns = teclado.get(0).size();

    // Mover la inicialización de coloresTablero aquí
    coloresTablero = new Color[rows][columns];

    setPreferredSize(new Dimension(getTecladoWidth(), getTecladoHeight()));
}

    


    public void marcarLetra(String letra) {
          for (int i = 0; i < teclado.size(); i++) {
        ArrayList<Letra> fila = teclado.get(i);
        for (int j = 0; j < fila.size(); j++) {
            if (fila.get(j).equals(letra)) {
                letrasMarcadas.get(i).set(j, true);
                letras.get(i).setEstado(EstadoLetra.CORRECTA); // Ejemplo de asignación de estado
                actualizarColores(); // Actualizar los colores de los botones
                return;
            }
        }
    }
    }

      @Override
    public void mostrarTeclado() {
        //
}
    
    protected void paintComponent(Graphics g) {
               super.paintComponent(g);

    g.setColor(Color.WHITE);
    g.fillRect(0, 0, getWidth(), getHeight());

    int startX = (getWidth() - getTecladoWidth()) / 2;
    int startY = (getHeight() - getTecladoHeight()) / 2;

    g.setColor(Color.BLACK);
    g.setFont(letraFont);

    int y = startY; // Variable para controlar la posición Y de cada fila

    for (int fila = 0; fila < teclado.size(); fila++) {
        ArrayList<Letra> filaTeclado = teclado.get(fila); // Obtener la fila actual del teclado
        int x = startX; // Reiniciar la posición X para cada fila

        for (int columna = 0; columna < filaTeclado.size(); columna++) {
            Letra letra = filaTeclado.get(columna);
            int letraX = x + (letraWidth - letraFont.getSize()) / 2; // Ajustar la posición X para centrar la letra
            int letraY = y + (filaHeight - letraFont.getSize()) / 2 + letraFont.getSize(); // Ajustar la posición Y para centrar la letra

            Color color = coloresTablero[fila][columna];
            g.setColor(color);

            g.drawRect(x, letraY - letraFont.getSize(), letraWidth, filaHeight);
            g.drawString(String.valueOf(letra.getLetra()), letraX, letraY);

            x += letraWidth + spacing; // Actualizar la posición X para la siguiente letra en la misma fila
        }

        y += filaHeight + spacing; // Actualizar la posición Y para la siguiente fila
    }
}
    
    
    
    
    private Color obtenerColorEstado(EstadoLetra estado) {
    switch (estado) {
        case CORRECTA:
            return Color.GREEN;
        case EXISTE:
            return Color.YELLOW;
        case INEXISTENTE:
            return Color.RED;
        default:
            return Color.BLACK;
        }
    }
    
    @Override
    public void marcarLetra(String palabra1, String palabra2, int i) {
    if (i >= 0 && i < letras.size()) {
        Letra letra = letras.get(i);
        if (palabra1.charAt(i) == palabra2.charAt(i)) {
            letra.setEstado(EstadoLetra.CORRECTA);
        } else if (palabra2.contains(String.valueOf(letra.getLetra()))) {
            letra.setEstado(EstadoLetra.EXISTE);
        } else {
            letra.setEstado(EstadoLetra.INEXISTENTE);
        }
        actualizarColores();
    }    }
   
    private void actualizarColores() {
            if (teclado != null && coloresTablero != null) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Letra letraTeclado;

                if (i < teclado.size() && j < teclado.get(i).size()) {
                    letraTeclado = teclado.get(i).get(j);
                } else {
                    letraTeclado = new Letra(' ', EstadoLetra.NORMAL);
                }

                Color color;

                if (letraTeclado.getEstado() == EstadoLetra.NORMAL) {
                    color = Color.WHITE;
                } else if (letraTeclado.getEstado() == EstadoLetra.CORRECTA) {
                    color = Color.GREEN;
                } else if (letraTeclado.getEstado() == EstadoLetra.EXISTE) {
                    color = Color.YELLOW;
                } else if (letraTeclado.getEstado() == EstadoLetra.INEXISTENTE) {
                    color = Color.GRAY;
                } else {
                    color = Color.BLACK;
                }

                coloresTablero[i][j] = color;
            }
        }

        repaint();
    }
}

    public void actualizarTeclado(String palabra, String referencia, int linea) {
        
     if (letras != null && palabra != null && referencia != null && palabra.length() == referencia.length()) {
        for (Letra letra : letras) {
            letra.setEstado(EstadoLetra.NORMAL);
        }

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            for (Letra letraTeclado : letras) {
                if (letraTeclado.getLetra() == letra) {
                    if (referencia.charAt(i) == palabra.charAt(i)) {
                        letraTeclado.setEstado(EstadoLetra.CORRECTA);
                    } else if (referencia.indexOf(letra) != -1) {
                        letraTeclado.setEstado(EstadoLetra.EXISTE);
                    } else {
                        letraTeclado.setEstado(EstadoLetra.INEXISTENTE);
                    }
                    break;
                }
            }
        }

        actualizarColores();
    }
}
    
    private Letra buscarLetra(char letra) {
    for (ArrayList<Letra> fila : teclado) {
        for (Letra letraTeclado : fila) {
            if (letraTeclado.getLetra() == letra) {
                return letraTeclado;
            }
        }
    }
    return null;
}
}


