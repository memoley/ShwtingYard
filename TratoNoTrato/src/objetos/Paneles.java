/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author memol
 */
public class Paneles {
    private ArrayList<JLabel> paneles;

    public Paneles() {
        this.paneles=new ArrayList<>();
        
    }

    public ArrayList<JLabel> getPaneles() {
        return paneles;
    }

    public void setPaneles(ArrayList<JLabel> paneles) {
        this.paneles = paneles;
    }
    
    public void agregar(JLabel panel){
        this.paneles.add(panel);
    }
}
