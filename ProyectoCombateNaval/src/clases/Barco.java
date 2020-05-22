/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;


/**
 *
 * @author pancho
 */
public class Barco {
    private String etiqueta;
    private int casillas;
    private String orientacion;
    private Boolean estado;
    private ArrayList <Punto> puntos;
    
    public Barco(String etiqueta,int casillas){
        this.etiqueta=etiqueta;
        this.casillas=casillas;
        this.puntos = new ArrayList<Punto>();
    }
    public void agregarPunto(Punto e){
        puntos.add(e);
    }
    public int CantidadPuntos(){
        int n;
        n= puntos.size();
        return n;
    }
    public Boolean hundir(Punto p){
        if(puntos.contains(p)){
            puntos.remove(p);
            casillas-=1;
            if(casillas==0){
                System.out.println("Barco hundido...");
                return true;
            }
        }
        else{
        }
        return false;
    }
    public boolean ContienePunto(Punto p){
        return puntos.contains(p);
        
    }
    public Boolean getEstado() {
        if(casillas == 0){
            estado = false;
        }
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getCasillas() {
        return casillas;
    }

    public void setCasillas(int casillas) {
        this.casillas = casillas;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }
    
}
