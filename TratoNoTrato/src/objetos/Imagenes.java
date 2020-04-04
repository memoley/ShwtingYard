/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author memol
 */
public class Imagenes {
    private ArrayList<ImageIcon> imagenes;

    public Imagenes() {
        imagenes=new ArrayList<>();
        agregar();
    }

    public ArrayList<ImageIcon> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<ImageIcon> imagenes) {
        this.imagenes = imagenes;
    }
    
    public void agregar(){
        ImageIcon m1=new ImageIcon((getClass().getResource("../Imagenes/m1.png")));
        ImageIcon mm1= new ImageIcon(m1.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m2=new ImageIcon((getClass().getResource("../Imagenes/m2.png")));
        ImageIcon mm2= new ImageIcon(m2.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m3=new ImageIcon((getClass().getResource("../Imagenes/m3.png")));
        ImageIcon mm3= new ImageIcon(m3.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m4=new ImageIcon((getClass().getResource("../Imagenes/m4.png")));
        ImageIcon mm4= new ImageIcon(m4.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m5=new ImageIcon((getClass().getResource("../Imagenes/m5.png")));
        ImageIcon mm5= new ImageIcon(m5.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m6=new ImageIcon((getClass().getResource("../Imagenes/m6.png")));
        ImageIcon mm6= new ImageIcon(m6.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m7=new ImageIcon((getClass().getResource("../Imagenes/m7.png")));
        ImageIcon mm7= new ImageIcon(m7.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m8=new ImageIcon((getClass().getResource("../Imagenes/m8.png")));
        ImageIcon mm8= new ImageIcon(m8.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m9=new ImageIcon((getClass().getResource("../Imagenes/m9.png")));
        ImageIcon mm9= new ImageIcon(m9.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m10=new ImageIcon((getClass().getResource("../Imagenes/m10.png")));
        ImageIcon mm10= new ImageIcon(m10.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m11=new ImageIcon((getClass().getResource("../Imagenes/m11.png")));
        ImageIcon mm11= new ImageIcon(m11.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m12=new ImageIcon((getClass().getResource("../Imagenes/m12.png")));
        ImageIcon mm12= new ImageIcon(m12.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m13=new ImageIcon((getClass().getResource("../Imagenes/m13.png")));
        ImageIcon mm13= new ImageIcon(m13.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m14=new ImageIcon((getClass().getResource("../Imagenes/m14.png")));
        ImageIcon mm14= new ImageIcon(m14.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m15=new ImageIcon((getClass().getResource("../Imagenes/m15.png")));
        ImageIcon mm15= new ImageIcon(m15.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m16=new ImageIcon((getClass().getResource("../Imagenes/m16.png")));
        ImageIcon mm16= new ImageIcon(m16.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m17=new ImageIcon((getClass().getResource("../Imagenes/m17.png")));
        ImageIcon mm17= new ImageIcon(m17.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m18=new ImageIcon((getClass().getResource("../Imagenes/m18.png")));
        ImageIcon mm18= new ImageIcon(m18.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m19=new ImageIcon((getClass().getResource("../Imagenes/m19.png")));
        ImageIcon mm19= new ImageIcon(m19.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m20=new ImageIcon((getClass().getResource("../Imagenes/m20.png")));
        ImageIcon mm20= new ImageIcon(m20.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m21=new ImageIcon((getClass().getResource("../Imagenes/m21.png")));
        ImageIcon mm21= new ImageIcon(m21.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m22=new ImageIcon((getClass().getResource("../Imagenes/m22.png")));
        ImageIcon mm22= new ImageIcon(m22.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m23=new ImageIcon((getClass().getResource("../Imagenes/m23.png")));
        ImageIcon mm23= new ImageIcon(m23.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m24=new ImageIcon((getClass().getResource("../Imagenes/m24.png")));
        ImageIcon mm24= new ImageIcon(m24.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m25=new ImageIcon((getClass().getResource("../Imagenes/m25.png")));
        ImageIcon mm25= new ImageIcon(m25.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        ImageIcon m26=new ImageIcon((getClass().getResource("../Imagenes/m26.png")));
        ImageIcon mm26= new ImageIcon(m26.getImage().getScaledInstance(60,45,Image.SCALE_DEFAULT));
        imagenes.add(0,mm1);
        imagenes.add(1,mm2);
        imagenes.add(2,mm3);
        imagenes.add(3,mm4);
        imagenes.add(4,mm5); 
        imagenes.add(5,mm6);
        imagenes.add(6,mm7);
        imagenes.add(7,mm8);
        imagenes.add(8,mm9);
        imagenes.add(9,mm10);
        imagenes.add(10,mm11);
        imagenes.add(11,mm12);
        imagenes.add(12,mm13);
        imagenes.add(13,mm14);
        imagenes.add(14,mm15);
        imagenes.add(15,mm16);
        imagenes.add(16,mm17);
        imagenes.add(17,mm18);
        imagenes.add(18,mm19);
        imagenes.add(19,mm20); 
        imagenes.add(20,mm21);
        imagenes.add(21,mm22);
        imagenes.add(22,mm23);
        imagenes.add(23,mm24);
        imagenes.add(24,mm25);
        imagenes.add(25,mm26);    
    }
}
