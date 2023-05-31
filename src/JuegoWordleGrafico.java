/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Grafico.TableroGrafico;
import Grafico.TecladoGrafico;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import uabc_practica5B_1182812.Interfaces.ITablero;
import uabc_practica5B_1182812.Interfaces.ITeclado;

/**
 *
 * @author domi1
 */
public class JuegoWordleGrafico extends JFrame{
    TableroGrafico tablero= new TableroGrafico();
    TecladoGrafico teclado= new TecladoGrafico();
    
    public JuegoWordleGrafico(ITablero tablero, ITeclado teclado){
        
        this.tablero = (TableroGrafico) tablero;
        this.teclado = (TecladoGrafico) teclado;
    }
    
    public void iniciar(){
       
     // Mostrar el juego
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(tablero, BorderLayout.CENTER);
        panel.add(teclado, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Juego Wordle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        // Crear todos los objetos
        DiccionarioDePalabrasDe5Letras diccionario = new DiccionarioDePalabrasDe5Letras("palabrasDe5Letras.txt");
        PalabraAlAzar palabraAlAzar = new PalabraAlAzar(diccionario);
        ArrayList<String> palabras = diccionario.obtenerPalabras();
        BuscadorDePalabras buscador = new BuscadorDePalabras(palabras);

        Intento intento = new Intento();

        // Juego
        boolean ganaste = false;
        int numIntentos = 0;
        int posicion = 0;
        int lineas = 0;
        String palabra= "mundo";
        
        while (!ganaste && numIntentos < 6) {
            // Pedir palabra
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa una palabra de 5 letras:");
            String palabraUsuario = scanner.nextLine();

            ContrastarPalabras comparador = new ContrastarPalabras(palabraUsuario);
            boolean longitudDeCinco = comparador.verificarLongitud();

            if (longitudDeCinco) {
                boolean existencia = false;
                existencia = comparador.verificarExistencia(diccionario);
                
                if (existencia) {
                   
                    tablero.colocarPalabra(palabraUsuario);
                    tablero.actualizarTablero(palabraUsuario, palabra, lineas);
                    teclado.actualizarTeclado(palabraUsuario, palabra, posicion);
                    lineas++;

                    if (palabraUsuario.equals(palabra)) {
                        ganaste = true;
                        numIntentos = 6;
                        System.out.println("Â¡Felicidades, ganaste el juego!");
                    }

                    numIntentos++;
                    if (numIntentos == 6) {
                        System.out.println("Lo siento, perdiste el juego.\nLa palabra era:");
                        System.out.println(palabra);
                    }
                } else {
                    System.out.println("La palabra no existe en el diccionario.");
                }
            } else {
                System.out.println("La palabra debe tener 5 letras.");
            }
        }
    }
 
}



