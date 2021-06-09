/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author GERSO
 */
public class Nodo {
    int dpi,n1,co=1;
    String nombre;
    int edad;
    int tiempo;
    Nodo siguiente;
    
    public Nodo(int n,int c,int d, String nom,int e, int tr) {
        n1=n;
        co=c;
        dpi = d;
        nombre = nom;
        edad=e;
        tiempo = tr;
        siguiente = null;
    }
}
