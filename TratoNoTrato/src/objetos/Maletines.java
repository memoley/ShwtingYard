/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author memol
 */
public class Maletines {
    private ArrayList<JButton> maletines;
    private Imagenes imagenes;

    public Maletines() {
        maletines=new ArrayList<>();
        agregar();
    }

    public ArrayList<JButton> getMaletines() {
        return maletines;
    }

    public void setMaletines(ArrayList<JButton> maletines) {
        this.maletines = maletines;
    }
    
    public void agregar(){
        imagenes=new Imagenes();
        for(int i=0;i<=25;i++){
         maletines.add(new JButton(imagenes.getImagenes().get(i)));   
        }
        
    }
}
