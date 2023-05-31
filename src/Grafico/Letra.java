/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafico;

/**
 *
 * @author domi1
 */
public class Letra {
    private char letra;
    private EstadoLetra estado;

    public Letra(char letra, EstadoLetra estado) {
        this.letra = letra;
        this.estado = EstadoLetra.NORMAL;
    }

    public char getLetra() {
        return letra;
    }

    public EstadoLetra getEstado() {
        return estado;
    }

    public void setEstado(EstadoLetra estado) {
        this.estado = estado;
    }
    
    
    
   
}

