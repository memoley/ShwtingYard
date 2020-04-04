/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import exceptions.Nombrevacioexception;
import java.util.ArrayList;

/**
 *
 * @author memol
 */
public class Usuario2 {
    private ArrayList<String> nombre;

    public Usuario2() {
        nombre=new ArrayList<>();
    }
    
    public void agregar(String nombres) throws Nombrevacioexception{
        if(!nombres.isEmpty()){
            nombre.add(nombres);
        }else{
            throw new Nombrevacioexception();
        }
    }

    public ArrayList<String> getNombre() {
        return nombre;
    }

    public void setNombre(ArrayList<String> nombre) {
        this.nombre = nombre;
    }
}
