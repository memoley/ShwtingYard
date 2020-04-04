/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
//import javax.swing.JSpinner;

/**
 *
 * @author memol
 */
public class Control extends JPanel{
    
    public Control (String color){
        JLabel label = new JLabel(color);
        JSlider slider = new JSlider(JSlider.HORIZONTAL,0,255,0);
        slider.setPaintLabels(true);
        slider.setInverted(false);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(50);
        JSpinner spinner = new JSpinner();
        
        super.add(label);
        super.add(slider);
        super.setVisible(true);
    }
}
