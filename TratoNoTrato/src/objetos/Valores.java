/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author memol
 */
public class Valores {
    private ArrayList<Integer> valores;
    public Valores() {
        this.valores=new ArrayList<>();
        agregarvalores();
    }
    
    
    public void desordenar(){
        Collections.shuffle(this.valores);
    }

    public ArrayList<Integer> getValores() {
        return valores;
    }

    public void setValores(ArrayList<Integer> valores) {
        this.valores = valores;
    }
    
    public void agregarvalores(){
        valores.add(0,1);
        valores.add(1,3);
        valores.add(2,5);
        valores.add(3,10);
        valores.add(4,25);
        valores.add(5,50);
        valores.add(6,75);
        valores.add(7,100);
        valores.add(8,200);
        valores.add(9,300);
        valores.add(10,400);
        valores.add(11,500);
        valores.add(12,750);
        valores.add(13,1000);
        valores.add(14,5000);
        valores.add(15,10000);
        valores.add(16,25000);
        valores.add(17,50000);
        valores.add(18,75000);
        valores.add(19,100000);
        valores.add(20,200000);
        valores.add(21,300000);
        valores.add(22,400000);
        valores.add(23,500000);
        valores.add(24,750000);
        valores.add(25,1000000);
    }
}
