
package polinomios;

import javax.swing.JOptionPane;

public class Validar {
    
    
    
    public String Validar_String(String t){
        String s;
        
        s = "";
        
        while (s.equals(""))
        {
            s = JOptionPane.showInputDialog(t);
            
            if (!s.matches("^[A-Za-z ]+$")) // *:puede tener mas de un caracter, $:puede tener espacios, ^:no se XD
            {
                s = "";
                
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un dato válido", "Validar", 0);
            }
        }
        
        return s;
    }
    
    
    public int Validar_int(String t){
        int i;
        boolean B;
        
        i = 0;
        B = false;
        
        while (!B)
        {
            try
            {
                i = Integer.parseInt(JOptionPane.showInputDialog(null,t, "INGRESO DE DATOS",3));
                B = true;
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un dato válido", "Validación", 0);
            }
        }
        
        return i;
    }
    
    
    public String Validar_char(String t){
        String c;
        
        c = "";
        
        while (c.equals(""))
        {
            c = JOptionPane.showInputDialog(t);
            
            if (!c.matches("[0-9]*")) // *:puede tener mas de un caracter
            {
                c = "";
                
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un dato válido", "Validar", 0);
            }
        }
        
        return c;
    }
      public long ValidarLong(String t){
        long i;
        boolean B;
        
        i = 0;
        B = false;
        
        while (!B)
        {
            try
            {
                i = Long.parseLong(JOptionPane.showInputDialog(null,t,"Cédula",3));
                B = true;
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un dato válido", "Validar", 0);
            }
        }
        
        return i;
    }

     public float ValidarFloat(String t){
        float i;
        boolean B;
        
        i = 0;
        B = false;
        
        while (!B)
        {
            try
            {
                i = Float.parseFloat(JOptionPane.showInputDialog(null,t, "INGRESO DE DATOS",3));
                B = true;
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un dato válido", "Validación", 0);
            }
        }
        
        return i;
    }
     
    

    
}
