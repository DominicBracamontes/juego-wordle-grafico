/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uabc_practica5B_1182812.Interfaces;
import java.awt.Canvas;
import java.awt.Graphics;
/**
 *
 * @author domi1
 */
public interface ITeclado {
    public void mostrarTeclado();
    public void marcarLetra(String palabra1, String palabra2, int i);
    public void marcarLetra(String letra);
    public void paint(Graphics g);
}
