/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecucion;

import java.util.Scanner;
import clases.*;
/**
 *
 * @author pancho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        //char [] abcdario = {'A','B','C','D','E','F','G','H','I','J','K','M','N','O','P','Q','R','S','T','U'};
        int op=0;
        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador();
        while(op!= 9){
            System.out.println("1)Jugador vs Jugador");
            System.out.println("2)Jugador vs computador");
            System.out.println("9)Salir");
            System.out.print("Opcion:  ");
            op= scan.nextInt();
            scan.nextLine();
            System.out.println("");
            switch(op){
                /*
                Barcos -> #15
                1) Portaaviones -> 4 casillas #4 
                2) Submarinos / Acorazados -> 3 casillas #5
                3) Destructores -> 2 casillas #4
                4) Fragatas -> 1 casilla #2
                
                Terminologia en tablero
                Barco=  P - S/A - D - F
                Agua = #;
                Tocado = T;
                Jugada al agua = X
                Hundido = Barco full de T
                
                */
                
                case 1:
                    //Definir nicks de los jugadores
                    System.out.print("Nick Jugador 1:");
                    j1.setNick(scan.nextLine());
                    System.out.println("");
                    System.out.print("Nick Jugador 2:");
                    j2.setNick(scan.nextLine());
                    System.out.println("");
                    //Definir tablero j1
                    Punto ubicacionI;// Punto base de cualquier barco
                    String dato;
                    int barcos= 15;
                    String[] puntoUbicacion;
                    j1.setTableroPropio();
                    j1.setTableroJugadas();
                    while (barcos >0){
                        j1.verTableroPosicion();
                        System.out.println("");
                        System.out.println("Menu de Barcos Jugador 1: ");
                        System.out.println("1)Portaaviones (4)");
                        System.out.println("2)Submarinos/Acorazados(5)");
                        System.out.println("3)Destructores(4)");
                        System.out.println("4)Fragatas(2)");
                        System.out.print("Opcion: ");
                        String opBarco = scan.nextLine();
                        switch(opBarco){
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            case "1":
                                if(j1.getPortaaviones()==0){
                                    System.out.println("Cantidad de portaaviones completada");
                                }
                                else{
                                    ubicacionI = new Punto();
                                    System.out.print("Ubicacion del barco->(letra,#): ");
                                    dato= scan.nextLine();
                                    System.out.println("");
                                    puntoUbicacion = dato.split(",");///////////////////////////OJO
                                    if(Integer.parseInt(puntoUbicacion[1])>=1 && Integer.parseInt(puntoUbicacion[1])<21){//Verificacion de punto
                                        ubicacionI.setY(Integer.parseInt(puntoUbicacion[1]));
                                        if(ubicacionI.VerificarLetra(puntoUbicacion[0])!=-1){
                                            ubicacionI.setX(ubicacionI.VerificarLetra(puntoUbicacion[0]));
                                            Barco portaavion = new Barco("Portaavion",4);
                                            boolean n;
                                            n=j1.ubicarBarco(ubicacionI, portaavion);

                                            if(n){
                                                j1.reducePortaaviones();
                                                System.out.println("Barco ubicado exitosamente");
                                                barcos-=1; 
                                            }else{
                                                System.out.println("Barco no ubicado");
                                            }

                                        }else{
                                            System.out.println("Punto invalido, vuelva a intentarlo");
                                        }
                                    }else{
                                        System.out.println("Punto invalido, vuelva a intentarlo...");
                                    } 
                                }
                                break;
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
                            case "2":
                                if(j1.getSubmarinosA()==0){
                                    System.out.println("Cantidad de Submarinos/Acorazados completada");
                                }
                                else{
                                    ubicacionI = new Punto();
                                    System.out.print("Ubicacion del barco->(letra,#): ");
                                    dato= scan.nextLine();
                                    System.out.println("");
                                    puntoUbicacion = dato.split(",");///////////////////////////OJO
                                    if(Integer.parseInt(puntoUbicacion[1])>=1 && Integer.parseInt(puntoUbicacion[1])<21){//Verificacion de punto
                                        ubicacionI.setY(Integer.parseInt(puntoUbicacion[1]));
                                        if(ubicacionI.VerificarLetra(puntoUbicacion[0])!=-1){
                                            ubicacionI.setX(ubicacionI.VerificarLetra(puntoUbicacion[0]));
                                            int tipo = (int) (Math.random()*2 + 1) ;
                                        ///////////////////////////////////////////    
                                            if(tipo==1){
                                                Barco b = new Barco("Acorazado",3);
                                                boolean n;
                                                n=j1.ubicarBarco(ubicacionI, b);

                                                if(n){
                                                    j1.reduceSubmarinosA();
                                                    System.out.println("Barco ubicado exitosamente");
                                                    barcos-=1; 
                                                }else{
                                                    System.out.println("Barco no ubicado");
                                                }
                                            }else{
                                                Barco b = new Barco("Submarino",3);
                                                boolean n;
                                                n=j1.ubicarBarco(ubicacionI, b);

                                                if(n){
                                                    j1.reduceSubmarinosA();
                                                    System.out.println("Barco ubicado exitosamente");
                                                    barcos-=1; 
                                                }else{
                                                    System.out.println("Barco no ubicado");
                                                } 
                                            }
                                        ////////////////////////////////////////////    
                                        }else{
                                            System.out.println("Punto invalido, vuelva a intentarlo");
                                        }
                                    }else{
                                        System.out.println("Punto invalido, vuelva a intentarlo...");
                                    } 
                                }
                                break;
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            case "3":
                                if(j1.getDestructores()==0){
                                    System.out.println("Cantidad de destructores completada");
                                }
                                else{
                                    ubicacionI = new Punto();
                                    System.out.print("Ubicacion del barco->(letra,#): ");
                                    dato= scan.nextLine();
                                    System.out.println("");
                                    puntoUbicacion = dato.split(",");///////////////////////////OJO
                                    if(Integer.parseInt(puntoUbicacion[1])>=1 && Integer.parseInt(puntoUbicacion[1])<21){//Verificacion de punto
                                        ubicacionI.setY(Integer.parseInt(puntoUbicacion[1]));
                                        if(ubicacionI.VerificarLetra(puntoUbicacion[0])!=-1){
                                            ubicacionI.setX(ubicacionI.VerificarLetra(puntoUbicacion[0]));
                                            Barco destructor = new Barco("Destructor",2);
                                            boolean n;
                                            n=j1.ubicarBarco(ubicacionI, destructor);

                                            if(n){
                                                j1.reduceDestructores();
                                                System.out.println("Barco ubicado exitosamente");
                                                barcos-=1; 
                                            }else{
                                                System.out.println("Barco no ubicado");
                                            }

                                        }else{
                                            System.out.println("Punto invalido, vuelva a intentarlo");
                                        }
                                    }else{
                                        System.out.println("Punto invalido, vuelva a intentarlo...");
                                    } 
                                }
                                break;
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
                            case "4":
                                if(j1.getFragatas()==0){
                                    System.out.println("Cantidad de fragatas completada");
                                }
                                else{
                                    ubicacionI = new Punto();
                                    System.out.print("Ubicacion del barco->(letra,#): ");
                                    dato= scan.nextLine();
                                    System.out.println("");
                                    puntoUbicacion = dato.split(",");///////////////////////////OJO
                                    if(Integer.parseInt(puntoUbicacion[1])>=1 && Integer.parseInt(puntoUbicacion[1])<21){//Verificacion de punto
                                        ubicacionI.setY(Integer.parseInt(puntoUbicacion[1]));
                                        if(ubicacionI.VerificarLetra(puntoUbicacion[0])!=-1){
                                            ubicacionI.setX(ubicacionI.VerificarLetra(puntoUbicacion[0]));
                                            Barco fragata = new Barco("Fragata",1);
                                            boolean n;
                                            n=j1.ubicarBarco(ubicacionI, fragata);

                                            if(n){
                                                j1.reduceFragatas();
                                                System.out.println("Barco ubicado exitosamente");
                                                barcos-=1; 
                                            }else{
                                                System.out.println("Barco no ubicado");
                                            }

                                        }else{
                                            System.out.println("Punto invalido, vuelva a intentarlo");
                                        }
                                    }else{
                                        System.out.println("Punto invalido, vuelva a intentarlo...");
                                    } 
                                }
                                break;
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
                        }
                       
                     /////////////////////////////////////////////////////////////////////////////////////////////////////////metes 1 barco por pasada   
                    }
                    //Definir tablero j2
                    barcos= 15;
                    j2.setTableroPropio();
                    j2.setTableroJugadas();
                    while (barcos >0){
                        j2.verTableroPosicion();
                        System.out.println("Menu de Barcos Jugador 2: ");
                        System.out.println("1)Portaaviones (4)");
                        System.out.println("2)Submarinos/Acorazados(5)");
                        System.out.println("3)Destructores(4)");
                        System.out.println("4)Fragatas(2)");
                        System.out.print("Opcion: ");
                        String opBarco = scan.nextLine();
                        switch(opBarco){
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            case "1":
                                if(j2.getPortaaviones()==0){
                                    System.out.println("Cantidad de portaaviones completada");
                                }
                                else{
                                    ubicacionI = new Punto();
                                    System.out.print("Ubicacion del barco->(letra,#): ");
                                    dato= scan.nextLine();
                                    System.out.println("");
                                    puntoUbicacion = dato.split(",");///////////////////////////OJO
                                    if(Integer.parseInt(puntoUbicacion[1])>=1 && Integer.parseInt(puntoUbicacion[1])<21){//Verificacion de punto
                                        ubicacionI.setY(Integer.parseInt(puntoUbicacion[1]));
                                        if(ubicacionI.VerificarLetra(puntoUbicacion[0])!=-1){
                                            ubicacionI.setX(ubicacionI.VerificarLetra(puntoUbicacion[0]));
                                            Barco portaavion = new Barco("Portaavion",4);
                                            boolean n;
                                            n=j2.ubicarBarco(ubicacionI, portaavion);

                                            if(n){
                                                j2.reducePortaaviones();
                                                System.out.println("Barco ubicado exitosamente");
                                                barcos-=1; 
                                            }else{
                                                System.out.println("Barco no ubicado");
                                            }

                                        }else{
                                            System.out.println("Punto invalido, vuelva a intentarlo");
                                        }
                                    }else{
                                        System.out.println("Punto invalido, vuelva a intentarlo...");
                                    } 
                                }
                                break;
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
                            case "2":
                                if(j2.getSubmarinosA()==0){
                                    System.out.println("Cantidad de Submarinos/Acorazados completada");
                                }
                                else{
                                    ubicacionI = new Punto();
                                    System.out.print("Ubicacion del barco->(letra,#): ");
                                    dato= scan.nextLine();
                                    System.out.println("");
                                    puntoUbicacion = dato.split(",");///////////////////////////OJO
                                    if(Integer.parseInt(puntoUbicacion[1])>=1 && Integer.parseInt(puntoUbicacion[1])<21){//Verificacion de punto
                                        ubicacionI.setY(Integer.parseInt(puntoUbicacion[1]));
                                        if(ubicacionI.VerificarLetra(puntoUbicacion[0])!=-1){
                                            ubicacionI.setX(ubicacionI.VerificarLetra(puntoUbicacion[0]));
                                            int tipo = (int) (Math.random()*2 + 1) ;
                                        ///////////////////////////////////////////    
                                            if(tipo==1){
                                                Barco b = new Barco("Acorazado",3);
                                                boolean n;
                                                n=j2.ubicarBarco(ubicacionI, b);

                                                if(n){
                                                    j2.reduceSubmarinosA();
                                                    System.out.println("Barco ubicado exitosamente");
                                                    barcos-=1; 
                                                }else{
                                                    System.out.println("Barco no ubicado");
                                                }
                                            }else{
                                                Barco b = new Barco("Submarino",3);
                                                boolean n;
                                                n=j2.ubicarBarco(ubicacionI, b);

                                                if(n){
                                                    j2.reduceSubmarinosA();
                                                    System.out.println("Barco ubicado exitosamente");
                                                    barcos-=1; 
                                                }else{
                                                    System.out.println("Barco no ubicado");
                                                } 
                                            }
                                        ////////////////////////////////////////////    
                                        }else{
                                            System.out.println("Punto invalido, vuelva a intentarlo");
                                        }
                                    }else{
                                        System.out.println("Punto invalido, vuelva a intentarlo...");
                                    } 
                                }
                                break;
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            case "3":
                                if(j2.getDestructores()==0){
                                    System.out.println("Cantidad de destructores completada");
                                }
                                else{
                                    ubicacionI = new Punto();
                                    System.out.print("Ubicacion del barco->(letra,#): ");
                                    dato= scan.nextLine();
                                    System.out.println("");
                                    puntoUbicacion = dato.split(",");///////////////////////////OJO
                                    if(Integer.parseInt(puntoUbicacion[1])>=1 && Integer.parseInt(puntoUbicacion[1])<21){//Verificacion de punto
                                        ubicacionI.setY(Integer.parseInt(puntoUbicacion[1]));
                                        if(ubicacionI.VerificarLetra(puntoUbicacion[0])!=-1){
                                            ubicacionI.setX(ubicacionI.VerificarLetra(puntoUbicacion[0]));
                                            Barco destructor = new Barco("Destructor",2);
                                            boolean n;
                                            n=j2.ubicarBarco(ubicacionI, destructor);

                                            if(n){
                                                j2.reduceDestructores();
                                                System.out.println("Barco ubicado exitosamente");
                                                barcos-=1; 
                                            }else{
                                                System.out.println("Barco no ubicado");
                                            }

                                        }else{
                                            System.out.println("Punto invalido, vuelva a intentarlo");
                                        }
                                    }else{
                                        System.out.println("Punto invalido, vuelva a intentarlo...");
                                    } 
                                }
                                break;
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
                            case "4":
                                if(j2.getFragatas()==0){
                                    System.out.println("Cantidad de fragatas completada");
                                }
                                else{
                                    ubicacionI = new Punto();
                                    System.out.print("Ubicacion del barco->(letra,#): ");
                                    dato= scan.nextLine();
                                    System.out.println("");
                                    puntoUbicacion = dato.split(",");///////////////////////////OJO
                                    if(Integer.parseInt(puntoUbicacion[1])>=1 && Integer.parseInt(puntoUbicacion[1])<21){//Verificacion de punto
                                        ubicacionI.setY(Integer.parseInt(puntoUbicacion[1]));
                                        if(ubicacionI.VerificarLetra(puntoUbicacion[0])!=-1){
                                            ubicacionI.setX(ubicacionI.VerificarLetra(puntoUbicacion[0]));
                                            Barco fragata = new Barco("Fragata",1);
                                            boolean n;
                                            n=j2.ubicarBarco(ubicacionI, fragata);

                                            if(n){
                                                j2.reduceFragatas();
                                                System.out.println("Barco ubicado exitosamente");
                                                barcos-=1; 
                                            }else{
                                                System.out.println("Barco no ubicado");
                                            }

                                        }else{
                                            System.out.println("Punto invalido, vuelva a intentarlo");
                                        }
                                    }else{
                                        System.out.println("Punto invalido, vuelva a intentarlo...");
                                    } 
                                }
                                break;
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
                        }
                       
                     /////////////////////////////////////////////////////////////////////////////////////////////////////////metes 1 barco por pasada    
                    }
                    //jugar
                    String ganador= "";
                    String jugada;
                    Punto tiro;
                    int casillasG1=0,casillasG2=0; //41 casillas totales de barcos para determinar ganador
                    
                    int jugador=1;//para determinar turnos
                    String[] partes;
                    System.out.println("Comienza el juego: ");
                    
                    while("".equals(ganador)){
                        
                        if(jugador==1){
                            System.out.println("");
                            j1.verTableros();
                            System.out.println("");
                            System.out.println("Turno del jugador "+j1.getNick()+":");
                            System.out.print("Ubicacion del barco->(letra,#): ");
                            System.out.println("");
                            tiro=new Punto();
                            jugada= scan.nextLine();
                            partes = jugada.split(",");  
                            if(Integer.parseInt(partes[1])>=1 && Integer.parseInt(partes[1])<21){
                                tiro.setY(Integer.parseInt(partes[1]));
                                if(tiro.VerificarLetra(partes[0])!=-1){
                                    tiro.setX(tiro.VerificarLetra(partes[0]));
                                    //verificar tiro
                                    if(j2.UbicarTiroRival(tiro)){
                                        j1.UbicarTiroPropio(tiro, "T");
                                        casillasG1+=1;
                                        jugador=1;
                                    }else{
                                        System.out.println("FALLASTE");
                                        j1.UbicarTiroPropio(tiro, "X");
                                        jugador=2;
                                    }
                                    
                                    
                                }else{
                                    System.out.println("Penalizacion por tiro invalido pierde el turno..");
                                    jugador =2;
                                }
                            }else{
                                System.out.println("Penalizacion por tiro invalido pierde turno...");
                                jugador=2;
                            }
                            
                            
                        }
                        //Turno jugador 2
                        else{
                            System.out.println("");
                            System.out.println("Turno del jugador "+j2.getNick()+":");
                            
                            j2.verTableros();
                            System.out.println("");
                            System.out.print("Ubicacion del barco->(letra,#): ");
                            tiro=new Punto();
                            jugada= scan.nextLine();
                            partes = jugada.split(",");  
                            if(Integer.parseInt(partes[1])>=1 && Integer.parseInt(partes[1])<21){
                                tiro.setY(Integer.parseInt(partes[1]));
                                if(tiro.VerificarLetra(partes[0])!=-1){
                                    tiro.setX(tiro.VerificarLetra(partes[0]));
                                    //verificar tiro
                                    if(j1.UbicarTiroRival(tiro)){
                                        j2.UbicarTiroPropio(tiro, "T");
                                        casillasG2+=1;
                                        jugador=2;
                                    }else{
                                        j2.UbicarTiroPropio(tiro, "X");
                                        jugador=1;
                                    }
                                    
                                    
                                }else{
                                    System.out.println("Penalizacion por tiro invalido pierde el turno..");
                                    jugador =1;
                                }
                            }else{
                                System.out.println("Penalizacion por tiro invalido pierde turno...");
                                jugador=1;
                            }
                            
                        }
                        
                        //determinar ganador
                        if(casillasG1==41){
                               ganador = j1.getNick();
                               System.out.println("Ganador del juego "+j1.getNick());
                           }
                           
                        if(casillasG2==41){
                               ganador = j2.getNick();
                               System.out.println("Ganador del juego "+j2.getNick());
                           }
                           
                    }
                    break;
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
                case 2:
                    int casillasJ=0, casillasCPU=0;
                    Jugador j3 = new Jugador();
                    Cpu pc = new Cpu();
                    System.out.print("Nick Jugador: ");
                    j3.setNick(scan.nextLine());
                    System.out.println("");
                    pc.setTableroJugadas();
                    pc.setTableroPropio();
                    /*Definir tablero CPU
                    1) Portaaviones -> 4 casillas #4 
                    2) Submarinos / Acorazados -> 3 casillas #5
                    3) Destructores -> 2 casillas #4
                    4) Fragatas -> 1 casilla #2*/
                    boolean pu=false;
                    for (int i = 0; i < 4; i++) {
                        Barco portaA = new Barco("Portaaviones",4);
                        
                        while(pu==false){
                            pu=pc.ubicarBarco(pc.crearPuntoA(), portaA);
                        }
                        if(pu==true){/////////////solo de revision - borrar luego
                            System.out.println("Barco cpu creado!!");
                        }else{
                            System.out.println("Barco cpu no creado! ");
                        }
                        
                    }
                    pu=false;
                    for (int i = 0; i < 5; i++) {
                        int y = (int) (Math.random()*2 + 1) ;
                        if(y==2){
                            Barco barco = new Barco("Acorazado",3);
                            while(pu==false){
                            pu = pc.ubicarBarco(pc.crearPuntoA(), barco); 
                            }
                            if(pu==true){/////////////solo de revision - borrar luego
                            System.out.println("Barco cpu creado!!");
                            }else{
                                System.out.println("Barco cpu no creado! ");
                            }
                        }
                        if(y==1){
                            Barco barco = new Barco("Submarino",3);
                            while(pu==false){
                            pu = pc.ubicarBarco(pc.crearPuntoA(), barco); 
                            } 
                            if(pu==true){/////////////solo de revision - borrar luego
                            System.out.println("Barco cpu creado!!");
                            }else{
                                System.out.println("Barco cpu no creado! ");
                            }
                        }
                    }
                    pu=false;
                    for (int i = 0; i < 4; i++) {
                        Barco destructor =  new Barco("Destructor",2);
                        while(pu==false){
                            pu=pc.ubicarBarco(pc.crearPuntoA(), destructor);
                        }
                        if(pu==true){/////////////solo de revision - borrar luego
                            System.out.println("Barco cpu creado!!");
                        }else{
                            System.out.println("Barco cpu no creado! ");
                        }
                    }
                    pu = false;
                    for (int i = 0; i < 2; i++) {
                        Barco fragata = new Barco("Fragata",1);
                        while(pu==false){
                            pu=pc.ubicarBarco(pc.crearPuntoA(), fragata);
                        }
                        if(pu==true){/////////////solo de revision - borrar luego
                            System.out.println("Barco cpu creado!!");
                        }else{
                            System.out.println("Barco cpu no creado! ");
                        }
                        
                    }
                    //Definir tablero j3
                    barcos= 15;
                    j3.setTableroPropio();
                    j3.setTableroJugadas();
                    pc.setTableroPropio();
                    pc.setTableroJugadas();
                    while (barcos >0){
                        j3.verTableroPosicion();
                        System.out.println("");
                        System.out.println("Menu de Barcos Jugador 1: ");
                        System.out.println("1)Portaaviones (4)");
                        System.out.println("2)Submarinos/Acorazados(5)");
                        System.out.println("3)Destructores(4)");
                        System.out.println("4)Fragatas(2)");
                        System.out.print("Opcion: ");
                        String opBarco = scan.nextLine();
                        switch(opBarco){
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            case "1":
                                if(j3.getPortaaviones()==0){
                                    System.out.println("Cantidad de portaaviones completada");
                                }
                                else{
                                    ubicacionI = new Punto();
                                    System.out.print("Ubicacion del barco->(letra,#): ");
                                    dato= scan.nextLine();
                                    System.out.println("");
                                    puntoUbicacion = dato.split(",");///////////////////////////OJO
                                    if(Integer.parseInt(puntoUbicacion[1])>=1 && Integer.parseInt(puntoUbicacion[1])<21){//Verificacion de punto
                                        ubicacionI.setY(Integer.parseInt(puntoUbicacion[1]));
                                        if(ubicacionI.VerificarLetra(puntoUbicacion[0])!=-1){
                                            ubicacionI.setX(ubicacionI.VerificarLetra(puntoUbicacion[0]));
                                            Barco portaavion = new Barco("Portaavion",4);
                                            boolean n;
                                            n=j3.ubicarBarco(ubicacionI, portaavion);

                                            if(n){
                                                j3.reducePortaaviones();
                                                System.out.println("Barco ubicado exitosamente");
                                                barcos-=1; 
                                            }else{
                                                System.out.println("Barco no ubicado");
                                            }

                                        }else{
                                            System.out.println("Punto invalido, vuelva a intentarlo");
                                        }
                                    }else{
                                        System.out.println("Punto invalido, vuelva a intentarlo...");
                                    } 
                                }
                                break;
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
                            case "2":
                                if(j3.getSubmarinosA()==0){
                                    System.out.println("Cantidad de Submarinos/Acorazados completada");
                                }
                                else{
                                    ubicacionI = new Punto();
                                    System.out.print("Ubicacion del barco->(letra,#): ");
                                    dato= scan.nextLine();
                                    System.out.println("");
                                    puntoUbicacion = dato.split(",");///////////////////////////OJO
                                    if(Integer.parseInt(puntoUbicacion[1])>=1 && Integer.parseInt(puntoUbicacion[1])<21){//Verificacion de punto
                                        ubicacionI.setY(Integer.parseInt(puntoUbicacion[1]));
                                        if(ubicacionI.VerificarLetra(puntoUbicacion[0])!=-1){
                                            ubicacionI.setX(ubicacionI.VerificarLetra(puntoUbicacion[0]));
                                            int tipo = (int) (Math.random()*2 + 1) ;
                                        ///////////////////////////////////////////    
                                            if(tipo==1){
                                                Barco b = new Barco("Acorazado",3);
                                                boolean n;
                                                n=j3.ubicarBarco(ubicacionI, b);

                                                if(n){
                                                    j3.reduceSubmarinosA();
                                                    System.out.println("Barco ubicado exitosamente");
                                                    barcos-=1; 
                                                }else{
                                                    System.out.println("Barco no ubicado");
                                                }
                                            }else{
                                                Barco b = new Barco("Submarino",3);
                                                boolean n;
                                                n=j3.ubicarBarco(ubicacionI, b);

                                                if(n){
                                                    j3.reduceSubmarinosA();
                                                    System.out.println("Barco ubicado exitosamente");
                                                    barcos-=1; 
                                                }else{
                                                    System.out.println("Barco no ubicado");
                                                } 
                                            }
                                        ////////////////////////////////////////////    
                                        }else{
                                            System.out.println("Punto invalido, vuelva a intentarlo");
                                        }
                                    }else{
                                        System.out.println("Punto invalido, vuelva a intentarlo...");
                                    } 
                                }
                                break;
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            case "3":
                                if(j3.getDestructores()==0){
                                    System.out.println("Cantidad de destructores completada");
                                }
                                else{
                                    ubicacionI = new Punto();
                                    System.out.print("Ubicacion del barco->(letra,#): ");
                                    dato= scan.nextLine();
                                    System.out.println("");
                                    puntoUbicacion = dato.split(",");///////////////////////////OJO
                                    if(Integer.parseInt(puntoUbicacion[1])>=1 && Integer.parseInt(puntoUbicacion[1])<21){//Verificacion de punto
                                        ubicacionI.setY(Integer.parseInt(puntoUbicacion[1]));
                                        if(ubicacionI.VerificarLetra(puntoUbicacion[0])!=-1){
                                            ubicacionI.setX(ubicacionI.VerificarLetra(puntoUbicacion[0]));
                                            Barco destructor = new Barco("Destructor",2);
                                            boolean n;
                                            n=j3.ubicarBarco(ubicacionI, destructor);

                                            if(n){
                                                j3.reduceDestructores();
                                                System.out.println("Barco ubicado exitosamente");
                                                barcos-=1; 
                                            }else{
                                                System.out.println("Barco no ubicado");
                                            }

                                        }else{
                                            System.out.println("Punto invalido, vuelva a intentarlo");
                                        }
                                    }else{
                                        System.out.println("Punto invalido, vuelva a intentarlo...");
                                    } 
                                }
                                break;
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
                            case "4":
                                if(j3.getFragatas()==0){
                                    System.out.println("Cantidad de fragatas completada");
                                }
                                else{
                                    ubicacionI = new Punto();
                                    System.out.print("Ubicacion del barco->(letra,#): ");
                                    dato= scan.nextLine();
                                    System.out.println("");
                                    puntoUbicacion = dato.split(",");///////////////////////////OJO
                                    if(Integer.parseInt(puntoUbicacion[1])>=1 && Integer.parseInt(puntoUbicacion[1])<21){//Verificacion de punto
                                        ubicacionI.setY(Integer.parseInt(puntoUbicacion[1]));
                                        if(ubicacionI.VerificarLetra(puntoUbicacion[0])!=-1){
                                            ubicacionI.setX(ubicacionI.VerificarLetra(puntoUbicacion[0]));
                                            Barco fragata = new Barco("Fragata",1);
                                            boolean n;
                                            n=j3.ubicarBarco(ubicacionI, fragata);

                                            if(n){
                                                j3.reduceFragatas();
                                                System.out.println("Barco ubicado exitosamente");
                                                barcos-=1; 
                                            }else{
                                                System.out.println("Barco no ubicado");
                                            }

                                        }else{
                                            System.out.println("Punto invalido, vuelva a intentarlo");
                                        }
                                    }else{
                                        System.out.println("Punto invalido, vuelva a intentarlo...");
                                    } 
                                }
                                break;
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
                        }
                       
                     /////////////////////////////////////////////////////////////////////////////////////////////////////////metes 1 barco por pasada   
                    }
                    
                    
                    
                    //Jugar
                    int jugando =0;
                    String ganadorJuego="";
                    int tiroPc=0;
                    while("".equals(ganadorJuego)){
                        if(jugando ==0){
                            System.out.println("");
                            System.out.println("Turno Jugador "+j3.getNick());
                            j3.verTableros();
                            System.out.print("Ubicacion del barco->(letra,#): ");
                            tiro=new Punto();
                            jugada= scan.nextLine();
                            partes = jugada.split(",");  
                            if(Integer.parseInt(partes[1])>=1 && Integer.parseInt(partes[1])<21){
                                tiro.setY(Integer.parseInt(partes[1]));
                                if(tiro.VerificarLetra(partes[0])!=-1){
                                    tiro.setX(tiro.VerificarLetra(partes[0]));
                                    //verificar tiro
                                    if(pc.UbicarTiroRival(tiro)){
                                        j3.UbicarTiroPropio(tiro, "T");
                                        casillasJ+=1;
                                        jugando=0;
                                    }else{
                                        j3.UbicarTiroPropio(tiro, "X");
                                        jugando=1;
                                    }
                                    
                                    
                                }else{
                                    System.out.println("Penalizacion por tiro invalido pierde el turno..");
                                    jugando =1;
                                }
                            }else{
                                System.out.println("Penalizacion por tiro invalido pierde turno...");
                                jugando=1;
                            }
                            
                        }
                        if(jugando==1){//Turno CPU
                            System.out.println("");
                            System.out.println("Turno pc ");
                            System.out.println("");
                            int y=0;
                            int verificador=0;
                            boolean si;
                            if(tiroPc==0){
                               tiro=pc.crearPuntoA(); 
                               //verificar tiro
                                if(j3.UbicarTiroRival(tiro)){
                                    pc.UbicarTiroPropio(tiro, "T");
                                    casillasCPU+=1;
                                    while(tiroPc==0){
                                        y = (int) (Math.random()*4 + 1) ;
                                        switch(y){
                                            case 1://arriba
                                                verificador = tiro.getY()-1;
                                                if(verificador >=1 && verificador <= 20){
                                                    tiro.setY(verificador);
                                                    si= j3.UbicarTiroRival(tiro);
                                                    if(si==false){
                                                        tiroPc = 1;
                                                        jugando=0;
                                                        pc.UbicarTiroPropio(tiro, "X");
                                                        pc.verTableros(); 
                                                    }else{
                                                        pc.UbicarTiroPropio(tiro, "T");
                                                        pc.verTableros(); 
                                                    } 
                                                ////////////    
                                                }//Si no cae dentro debe ocupar otro punto así no desperdicia el turno
                                                break;
                                            case 2://abajo
                                                verificador = tiro.getY()+1;
                                                if(verificador >=1 && verificador <= 20){
                                                    tiro.setY(verificador);
                                                    si= j3.UbicarTiroRival(tiro);
                                                    if(si==false){
                                                        tiroPc = 1;
                                                        jugando = 0;
                                                        pc.UbicarTiroPropio(tiro, "X");
                                                        pc.verTableros(); 
                                                    }else{
                                                        pc.UbicarTiroPropio(tiro, "T");
                                                        pc.verTableros(); 
                                                    } 
                                                ////////////    
                                                }//Si no cae dentro del tablero debe ocupar otro punto así no desperdicia el turno
                                                break;
                                            case 3://derecha
                                                verificador = tiro.getX()+1;
                                                if(verificador >=1 && verificador <= 20){
                                                    tiro.setX(verificador);
                                                    si= j3.UbicarTiroRival(tiro);
                                                    if(si==false){
                                                        tiroPc = 1;
                                                        jugando = 0;
                                                        pc.UbicarTiroPropio(tiro, "X");
                                                        pc.verTableros(); 
                                                    }else{
                                                        pc.UbicarTiroPropio(tiro, "T");
                                                        pc.verTableros(); 
                                                        casillasCPU+=1;
                                                    } 
                                                ////////////    
                                                }//Si no cae dentro del tablero debe ocupar otro punto así no desperdicia el turno
                                                break;
                                            case 4://izquierda
                                                verificador = tiro.getX()-1;
                                                if(verificador >=1 && verificador <= 20){
                                                    tiro.setX(verificador);
                                                    si= j3.UbicarTiroRival(tiro);
                                                    if(si==false){
                                                        tiroPc = 1;
                                                        jugando = 0;
                                                        pc.UbicarTiroPropio(tiro, "X");
                                                        pc.verTableros(); 
                                                    }else{
                                                        pc.UbicarTiroPropio(tiro, "T");
                                                        pc.verTableros(); 
                                                        casillasCPU+=1;
                                                    } 
                                                ////////////    
                                                }//Si no cae dentro del tablero debe ocupar otro punto así no desperdicia el turno
                                                break;
                                        }
                                    }
                                    
                                }else{
                                    j3.UbicarTiroPropio(tiro, "X");
                                    jugando=0;
                                }
                            }else{
                                System.out.println("error 404 not found");
                            }
                            pc.verTableros(); 
                        }
                        //determinar ganador
                        if(casillasJ==41){
                               ganador = j3.getNick();
                               System.out.println("Ganador del juego "+j1.getNick());
                           }
                           
                        if(casillasCPU==41){
                               ganador = "cpu";
                               System.out.println("Ganador del juego CPU ");
                           }
                    }
                    break;
                case 9:
                    op=9;
                    break;
            }
        }
    }
    
}
