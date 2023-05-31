/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uabc_practica5B_1182812.Interfaces;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
/**
 *
 * @author domi1
 */
public interface ITablero {
    public void actualizarTablero(String palabra, String referencia, int linea);
    public void mostrarTablero();
    public void colocarPalabra(String palabra, Graphics g);
    public void paint(Graphics g);
}
