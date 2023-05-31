/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import uabc_practica5B_1182812.Interfaces.ITablero;
import java.util.ArrayList;
import java.util.Scanner;

import uabc_practica5B_1182812.Interfaces.ITeclado;

/**
 *
 * @author domi1
 */
public class JuegoWordle {
    ITablero tablero;
    ITeclado teclado;
    //JFrame ventana= new JFrame("Tablero");
    //Canvas canvas= new Canvas();
    
    public JuegoWordle(ITablero tablero, ITeclado teclado){
        this.tablero = tablero;
        this.teclado = teclado;
    }
    
        public void iniciar(){
            tablero.mostrarTablero();
            teclado.mostrarTeclado();
        
        DiccionarioDePalabrasDe5Letras diccionario = new DiccionarioDePalabrasDe5Letras("palabrasDe5Letras.txt");
        PalabraAlAzar palabraAlAzar = new PalabraAlAzar(diccionario);
        ArrayList<String> palabras = diccionario.obtenerPalabras();
        BuscadorDePalabras buscador = new BuscadorDePalabras(palabras);

        Intento intento = new Intento();

        // Inicializar arraylists
        ArrayList<String> intentos = new ArrayList<String>();
        ArrayList<Character> tecladoQWERTY = new ArrayList<Character>();
        ArrayList<Character> tecladoASDFGH = new ArrayList<Character>();
        ArrayList<Character> tecladoZXCVBNM = new ArrayList<Character>();

        // Agregar letras a los teclados
        String qwerty = "qwertyuiop";
        for (int i = 0; i < qwerty.length(); i++) {
            tecladoQWERTY.add(qwerty.charAt(i));
        }
        String asdfgh = "asdfghjkl";
        for (int i = 0; i < asdfgh.length(); i++) {
            tecladoASDFGH.add(asdfgh.charAt(i));
        }
        String zxcvbnm = "zxcvbnm";
        for (int i = 0; i < zxcvbnm.length(); i++) {
            tecladoZXCVBNM.add(zxcvbnm.charAt(i));
        }
        

        // Juego
        System.out.println("Bienvenido al juego de adivinar la palabra de 5 letras!");
        boolean ganaste = false;
        int numIntentos = 0;
        int posicion=0;
        int lineas=0;
        String palabra = palabraAlAzar.obtenerPalabra();
        
        while (!ganaste && numIntentos < 6) {

            // Pedir palabra
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa una palabra de 5 letras:");
            String palabraUsuario = scanner.nextLine();
            ContrastarPalabras comparador = new ContrastarPalabras(palabraUsuario);
            boolean longitudDeCinco=false;
            longitudDeCinco= comparador.verificarLongitud();
            
            if(longitudDeCinco=true){
                boolean existencia=false;
                existencia= comparador.verificarExistencia(diccionario);
                if (existencia=true){
            teclado.marcarLetra( palabraUsuario, palabra, posicion );
            tablero.actualizarTablero(palabraUsuario,palabra,lineas );
            tablero.mostrarTablero();
           
            lineas++;
                if (palabraUsuario == null ? palabra == null : palabraUsuario.equals(palabra)) {
                    ganaste = true;
                    numIntentos=6;
                    System.out.println("Felicidades, ganaste el juego!");
                }
            teclado.mostrarTeclado();
            intentos.add(palabraUsuario);
            numIntentos++;
            if (numIntentos == 6) {
                System.out.println("Lo siento, perdiste el juego.\nLa palabra era:");
                System.out.println(palabra);
            }
                }else if (existencia=false) {
                    System.out.println("la palabra no existe en el diccionario");
                }
        }else if(longitudDeCinco=false) {
                System.out.println("La palabra es invalida");
            }
    }
}
}
