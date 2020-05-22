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
public class Jugador {
    private String nick;
    private ArrayList <Barco> barcos;
    String [][] tableroPosicion;
    String [][] tableroEnemiga;
    private  int portaaviones;
    private  int submarinosA;
    private  int destructores;
    private  int fragatas;
    
    
public Jugador() {
        this.fragatas = 2;
        this.destructores = 4;
        this.submarinosA = 5;
        this.portaaviones = 4;
        this.barcos= new ArrayList();
    }
    

    public ArrayList<Barco> getBarcos() {
        return barcos;
    }

    public void setBarcos(ArrayList<Barco> barcos) {
        this.barcos = barcos;
    }

    public int getPortaaviones() {
        return portaaviones;
    }

    public void reducePortaaviones() {
        this.portaaviones -=1;
    }

    public int getSubmarinosA() {
        return submarinosA;
    }

    public void reduceSubmarinosA() {
        this.submarinosA -=1;
    }

    public int getDestructores() {
        return destructores;
    }

    public void reduceDestructores() {
        this.destructores -=1 ;
    }

    public int getFragatas() {
        return fragatas;
    }

    public void reduceFragatas() {
        this.fragatas -= 1;
    }
    
    public void setTableroJugadas(){
        String [][] tablero = { 
                        {"  ","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t"},
                        {" 1","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 2","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 3","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 4","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 5","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 6","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 7","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 8","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 9","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"10","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"11","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"12","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"13","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"14","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"15","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"16","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"17","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"18","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"19","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"20","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"}};
        tableroEnemiga = tablero;
    }
    public void setTableroPropio(){
        String [][] tablero = {
                        {"  ","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t"},
                        {" 1","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 2","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 3","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 4","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 5","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 6","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 7","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 8","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {" 9","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"10","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"11","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"12","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"13","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"14","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"15","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"16","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"17","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"18","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"19","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
                        {"20","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"}};
        tableroPosicion = tablero;
    }
   /*
   Punto pos debe estar entre 20 y 1 ambos parametros.
   */
   public Boolean ubicarBarco(Punto pos, Barco b){
       int orientacion;
       int cantidadR;
       String x = b.getEtiqueta();
       cantidadR = b.getCasillas();
       /*
                1) Portaaviones -> 4 casillas #4 
                2) Submarinos / Acorazados -> 3 casillas #5
                3) Destructores -> 2 casillas #4
                4) Fragatas -> 1 casilla #2
       */
       if (tableroPosicion[pos.getY()][pos.getX()]!= "#"){
           return false;
       }
       String estado = "no-listo";
       int casos;
       int cantidadOpciones= 5;//en caso de que no se pueda ubicar el barco cantidadOpciones-1
                                // si llega a 0 return false;
       while("no-listo".equals(estado)){
           //////////////////////////////////////////////////
           orientacion = (int) (Math.random()*5 + 1) ;
           if(orientacion==1){
               cantidadOpciones--;
           }
           if(orientacion==2){
               cantidadOpciones--;
           }
           if(orientacion==3){
               cantidadOpciones--;
           }
           if(orientacion==4){
               cantidadOpciones--;
           }
           //////////////////////////////////////////////////
           
           casos=0;
           if(cantidadOpciones == 0){////Condicion de termino
               return false;
           }
           if(orientacion == 1){//Arriba [i++][0]
               for (int i = 0; i < cantidadR; i++) {
                   if(pos.getY()+i>=1&&pos.getY()+i<=20){
                        if (tableroPosicion[pos.getY()+i][pos.getX()]== "#"){
                           tableroPosicion[pos.getY()+i][pos.getX()]=x.charAt(0)+"";//Lo convierto a string para la comparacion
                           casos++;
                        }
                   }
                   
               }
               if(casos==cantidadR){
                   Punto agregar;//agregamos los puntos al barco.
                   for (int l = 0; l < casos; l++) {
                       int y = pos.getY()+l;
                       agregar = new Punto();
                       agregar.setY(y);
                       agregar.setX(pos.getX());
                       b.agregarPunto(agregar);   
                   }
                   barcos.add(b);//barco añadido
                   estado="";
                   return true;
               }else{
                   for (int j = 0; j < casos; j++) {
                               tableroPosicion[pos.getY()+j][pos.getX()]="#";//borra el trozo de barco incompleta
                           }
               }
           }
       
           if(orientacion == 2){//Abajo[i--][0]
               for (int i = 0; i < cantidadR; i++) {
                   if(pos.getY()-i>=1&&pos.getY()-i<=20){
                        if (tableroPosicion[pos.getY()-i][pos.getX()]== "#"){
                          tableroPosicion[pos.getY()-i][pos.getX()]=x.charAt(0)+"";
                          casos++;
                       } 
                   }
                   
               }
               if(casos==cantidadR){
                   Punto agregar;//agregamos los puntos al barco.
                   for (int l = 0; l < casos; l++) {
                       int y = pos.getY()+l;
                       agregar = new Punto();
                       agregar.setY(y);
                       agregar.setX(pos.getX());
                       b.agregarPunto(agregar);   
                   }
                   barcos.add(b);//barco añadido
                   estado="";
                   return true;
               }else{
                   for (int j = 0; j < casos; j++) {
                        tableroPosicion[pos.getY()-j][pos.getX()]="#";
                          }
               }

           }
           if(orientacion == 3){//Izquierda[0][j--]
               for (int i = 0; i < cantidadR; i++) {
                   if(pos.getX()-i>=1&&pos.getX()-i<=20){
                       if (tableroPosicion[pos.getY()][pos.getX()-i]== "#"){
                       tableroPosicion[pos.getY()][pos.getX()-i]=x.charAt(0)+"";
                       casos++;
                        }
                   }
                   
               }
               if(casos==cantidadR){
                   Punto agregar;//agregamos los puntos al barco.
                   for (int l = 0; l < casos; l++) {
                       int y = pos.getY()+l;
                       agregar = new Punto();
                       agregar.setY(y);
                       agregar.setX(pos.getX());
                       b.agregarPunto(agregar);   
                   }
                   barcos.add(b);//barco añadido
                   estado="";
                   return true;
               }else{
                   for (int j = 0; j < casos; j++) {
                        tableroPosicion[pos.getY()][pos.getX()-j]="#";
                           }
               }

           }
           if(orientacion == 4){//Derecha[0][i++]
               for (int i = 0; i < cantidadR; i++) {
                   if(pos.getX()+i>=1&&pos.getX()+i<=20){
                      if (tableroPosicion[pos.getY()][pos.getX()+i]== "#"){
                       tableroPosicion[pos.getY()][pos.getX()+i]=x.charAt(0)+"";
                       casos++;
                        }
                   }
                   
               }
               if(casos==cantidadR){
                   Punto agregar;//agregamos los puntos al barco.
                   for (int l = 0; l < casos; l++) {
                       int y = pos.getY()+l;
                       agregar = new Punto();
                       agregar.setY(y);
                       agregar.setX(pos.getX());
                       b.agregarPunto(agregar);   
                   }
                   barcos.add(b);//barco añadido
                   estado="";
                   return true;
               }else{
                   for (int j = 0; j < casos; j++) {
                        tableroPosicion[pos.getY()][pos.getX()+j]="#";
                    }
               }

           }
       }
       
      return true; 
   }
   public void verTableros(){
       System.out.println("");
       System.out.println("Tablero de Posicionamiento: ");
       System.out.println("");
       for (int i = 0; i < 21; i++) {
           System.out.println();
           for (int j = 0; j < 21; j++) {
               System.out.print(tableroPosicion[i][j]+" ");
           }
       }
       System.out.println("");
       System.out.println("Tablero enemigo: ");
       System.out.println("");
       for (int i = 0; i < 21; i++) {
           System.out.println();
           for (int j = 0; j < 21; j++) {
               System.out.print(tableroEnemiga[i][j]+" ");
           }
       }
   }
    public void verTableroPosicion(){
       System.out.println("Tablero de Posicionamiento: ");
       System.out.println("");
       for (int i = 0; i < 21; i++) {
           System.out.println();
           for (int j = 0; j < 21; j++) {
               System.out.print(tableroPosicion[i][j]+" ");
           }
       }
    }
   

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
    public boolean UbicarTiroRival(Punto n){//True si golpea, el tiro es ubicado siempre, esto para saber si repite turno
        //tableroEnemiga[n.getY()][n.getX()]=tipo;
        if("#".equals(tableroPosicion[n.getY()][n.getX()])){
            System.out.println("FALLASTE!!!!!!!!!");
            tableroPosicion[n.getY()][n.getX()]="Q";//Para tener en cuenta de donde ha tirado el rival
            return false;
        }
        for (int i = 0; i < barcos.size(); i++) {
            if(barcos.get(i).ContienePunto(n)){
                tableroPosicion[n.getY()][n.getX()]="T";//Daña el barco en el tablero 
                boolean x =barcos.get(i).hundir(n);// Quita el punto y revisa si lo hundió
                if(x){
                    System.out.println("Bien hecho...");
                    return true;
                    
                }
                return true;
                
            }
        
        
        }//ERRORES ENCONTRADOS EN CPU
        /*if("P".equals(tableroPosicion[n.getY()][n.getX()])){
            System.out.println("");
            System.out.println("Acertaste");
            System.out.println("");
            tableroPosicion[n.getY()][n.getX()]="T";//Para tener en cuenta de donde ha tirado el rival
            return true;
        }   
        if("A".equals(tableroPosicion[n.getY()][n.getX()])){
            System.out.println("");
            System.out.println("Acertaste");
            System.out.println("");
            tableroPosicion[n.getY()][n.getX()]="T";//Para tener en cuenta de donde ha tirado el rival
            return true;
        }
        if("S".equals(tableroPosicion[n.getY()][n.getX()])){
            System.out.println("");
            System.out.println("Acertaste");
            System.out.println("");
            tableroPosicion[n.getY()][n.getX()]="T";//Para tener en cuenta de donde ha tirado el rival
            return true;
        }
        if("F".equals(tableroPosicion[n.getY()][n.getX()])){
            System.out.println("");
            System.out.println("Acertaste");
            System.out.println("");
            tableroPosicion[n.getY()][n.getX()]="T";//Para tener en cuenta de donde ha tirado el rival
            return true;
        }
        if("D".equals(tableroPosicion[n.getY()][n.getX()])){
            System.out.println("");
            System.out.println("Acertaste");
            System.out.println("");
            tableroPosicion[n.getY()][n.getX()]="T";//Para tener en cuenta de donde ha tirado el rival
            return true;
        }*/
       return false; 
    }
    
    public void UbicarTiroPropio(Punto a, String tipo){
        tableroEnemiga[a.getY()][a.getX()]=tipo;
        
    }
   
   
}
