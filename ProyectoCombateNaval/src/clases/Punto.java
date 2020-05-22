/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author pancho
 */
public class Punto {
    private int y, x;
    public Punto(){
     //birigidooooo   
    }

    public int getY() {
        
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int VerificarLetra(String letra){
        int n=-1;
        if("a".equals(letra)){
            return 1;
        }
        if("b".equals(letra)){
            return 2;
        }
        if("c".equals(letra)){
            return 3;
        }
        if("d".equals(letra)){
            return 4;
        }
        if("e".equals(letra)){
            return 5;
        }
        if("f".equals(letra)){
            return 6;
        }
        if("g".equals(letra)){
            return 7;
        }
        if("h".equals(letra)){
            return 8;
        }
        if("i".equals(letra)){
            return 9;
        }
        if("j".equals(letra)){
            return 10;
        }
        if("k".equals(letra)){
            return 11;
        }
        if("l".equals(letra)){
            return 12;
        }
        if("m".equals(letra)){
            return 13;
        }
        if("n".equals(letra)){
            return 14;
        }
        if("o".equals(letra)){
            return 15;
        }
        if("p".equals(letra)){
            return 16;
        }
        if("q".equals(letra)){
            return 17;
        }
        if("r".equals(letra)){
            return 18;
        }
        if("s".equals(letra)){
            return 19;
        }
        if("t".equals(letra)){
            return 20;
        }

        return n;
    }
    
}
