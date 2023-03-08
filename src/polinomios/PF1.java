
package polinomios;

import javax.swing.JOptionPane;

/**
 *
 * @author Mariana M
 */
public class PF1 {
    private int Grado, Vp1[], Du , Pos;
    
    
    
    public PF1(int n, int exp)
    {
        Grado = 0;
        Du=Grado+1;
        Vp1 = new int [Du+1];
        Pos = Du-exp;
    }

    public int getGrado() {
        return Grado;
    }

    public void setGrado(int Grado) {
        this.Grado = Grado;
    }

    public int[] getVp1() {
        return Vp1;
    }

    public void setVp1(int[] Vp1) {
        this.Vp1 = Vp1;
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public int getPos() {
        return Pos;
    }

    public void setPos(int Pos) {
        this.Pos = Pos;
    }
    
  
      
  
   
   public void Llenar( int [] Vp)
   {
      

       
   }
    
}
    
  
  
    

