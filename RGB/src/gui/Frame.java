/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import gui.Control;
import java.awt.Color;

/**
 *
 * @author memol
 */
public class Frame extends JFrame {
    public Frame(){
        super("RGB");
        super.setLayout(new FlowLayout(FlowLayout.LEADING));
        super.setSize(400,300);
        Control rojo = new Control("ROJO");
        Control verde = new Control("VERDE");
        Control azul = new Control("AZUL");
        super.add(rojo);
        super.add(verde);
        super.add(azul);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
    
}
