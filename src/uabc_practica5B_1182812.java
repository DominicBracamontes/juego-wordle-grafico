/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import Grafico.TableroGrafico;
import Grafico.TecladoGrafico;
import uabc_practica5B_1182812.Interfaces.ITablero;
import uabc_practica5B_1182812.Interfaces.ITeclado;

/**
 *
 * @author domi1holi
 */
public class uabc_practica5B_1182812 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ITablero tablero = (ITablero) new TableroGrafico();
        ITeclado teclado = (ITeclado) new TecladoGrafico();

        JuegoWordleGrafico JW = new JuegoWordleGrafico(tablero, teclado);
        JW.iniciar();
    }
}
