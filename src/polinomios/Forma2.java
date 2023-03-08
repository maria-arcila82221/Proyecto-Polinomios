package polinomios;
import javax.swing.JOptionPane;

public class Forma2 {

    private int Du, VPF2[];

    public Forma2() {
        Du = 0;
        VPF2 = new int[20];
    }

    public Forma2(int NTer) {
        Du = NTer * 2;
        VPF2 = new int[Du + 1];
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public int[] getVPF2() {
        return VPF2;
    }

    public void setVPF2(int[] VPF2) {
        this.VPF2 = VPF2;
    }

    public int getVPF2(int pos) {
        return VPF2[pos];
    }

    public void setVPF2(int pos, int d) {
        VPF2[pos] = d;
    }

    public void Construir(int[] V) {
        int Va[], i, j, c;
        Forma2 p;
        String s;

        s = "";

        if (V.length > 1)
        {
            Va = new int[2];
            c = 0;

            for (i = 1; i < V.length; i += 2)
            {
                for (j = (i + 2); j < V.length; j += 2)
                {
                    if (V[j] > V[i])
                    {
                        Va[0] = V[i - 1];
                        Va[1] = V[i];
                        V[i - 1] = V[j - 1];
                        V[i] = V[j];
                        V[j - 1] = Va[0];
                        V[j] = Va[1];
                    }
                }

                c++;
            }
            p = new Forma2(c);
            p.VPF2[0] = c;

            for (i = 0; i < V.length; i++)
            {
                p.VPF2[i + 1] = V[i];
            }
            this.setVPF2(p.VPF2);
        }
    }

    public void Evaluar(int n) {
        int i, exp = 0;
        int r = 0;
        for (i = 1; i < this.VPF2.length; i += 2)
        {

            r = r + (this.VPF2[i] * (int) Math.pow(n, this.VPF2[i + 1]));
        }
        JOptionPane.showMessageDialog(null, "El resultado es: " + r, "Evaluar", 3);
    }

    public void Multiplicar(Forma2 P1, Forma2 P2) {
        int r = 0, j, i = 0, ExC, pos;

        Forma2 P3 = new Forma2((P1.VPF2[0]*P2.VPF2[0]));
        

        P3.VPF2[0] = P1.VPF2[0]*P2.VPF2[0];

        for (i = 1; i < P1.VPF2.length; i+=2)
        {
            for (j = 1; j < P2.VPF2.length; j+=2)
            {
                
                 r = P1.VPF2[i] * P2.VPF2[j];
                    pos=Math.abs(P3.Du-(P1.VPF2[i+1]+P2.VPF2[j+1]));
                    if( P3.VPF2[pos]==0 &&P3.VPF2[pos-1]==0)
                    {
                    P3.VPF2[pos-1] =P3.VPF2[pos-1]+r;
                    P3.VPF2[pos]=P1.VPF2[i+1]+P2.VPF2[j+1];
                    }
                    else
                    {
                        if(pos==0)
                        {
                             P3.VPF2[pos+1] =P3.VPF2[pos+1]+r;
                             P3.VPF2[pos+2]=P1.VPF2[i+1]+P2.VPF2[j+1]; 
                        }else
                        {
                            P3.VPF2[pos] =P3.VPF2[pos]+r;
                            P3.VPF2[pos+1]=P1.VPF2[i+1]+P2.VPF2[j+1]; 
                        }
                       
                    }
            }
        }
        P3.Reconstruir();
        P3.Mostrar();
        P2.setDu(0);
        P3.setDu(0);

    }
      public void RedimensionarP(){
        int V[], i;
        
        V = new int[Du+1];
        
        for (i=0; i<V.length; i++)
        {
            V[i] = VPF2[i];
        }
        
        VPF2 = V;
    }
    
    public void RedimensionarG(){
        int V[], i;
        
        V = new int [Du+1];
        
        for (i=0; i<VPF2.length; i++)
        {
            V[i] = VPF2[i];
        }
        
        VPF2 = V;
    }
    public void Sumar(){
        int i, j, k, V[];
        boolean b;
        
        V = Polinomios.Ingreso();
        
        for (j=1; j<V.length; j+=2)
        {
            b = true;
            
            for (i=2; (i<VPF2.length) && b; i+=2)
            {
                if (VPF2[i] == V[j])
                {
                    VPF2[i-1] += V[j-1];
                    
                    b = false;
                }
                else
                {
                    if (VPF2[i] < V[j])
                    {
                        Du += 2;
                        
                        RedimensionarG();
                        
                        k = i-1;
                        
                        while(VPF2[k] != 0)
                        {
                            k += 2;
                        }
                        
                        for (k-=1; k!=(i-2); k--)
                        {
                            VPF2[k+2] = VPF2[k];
                        }
                        
                        VPF2[i-1] = V[j-1];
                        VPF2[i] = V[j];
                        
                        b = false;
                    }
                }
            }
        }
        
        VPF2[0] = Du/2;
        
        this.Mostrar();
    }
    
    public void Reconstruir()
    {
        int i;

        String s = "";

        for (i = 1; i < this.VPF2.length; i+=2)
        {
             if (this.VPF2[i+1] != 0)
                {
                    if (this.VPF2[i+1] != 1 && this.VPF2[i] < 0)
                    {
                        if (this.VPF2[i] != -1)
                        {
                            s = s + "" + this.VPF2[i] + 'x' + '^' + this.VPF2[i+1];
                        } else
                        {
                            s = s + "-" + 'x' + '^' + this.VPF2[i+1];
                        }
                    } else
                    {
                        if (this.VPF2[i+1] == 1 && this.VPF2[i] > 0 && i != 1)
                        {
                            if (this.VPF2[i] != 1)
                            {
                                s = s + "+" + this.VPF2[i] + 'x';
                            } else
                            {
                                if(this.VPF2[i+1]!=1)
                                {
                                    s = s + "+" + 'x' + '^' + this.VPF2[i+1];
                                }else
                                {
                                    s = s + "+" + 'x';
                                }
                            }
                        } else
                        {
                            if (this.VPF2[i+1] != 1 && this.VPF2[i] > 0 && i != 1)
                            {
                                if (this.VPF2[i] != 1)
                                {
                                    s = s + "+" + this.VPF2[i] + 'x' + '^' + this.VPF2[i+1];
                                } else
                                {
                                    s = s + "+" + 'x' + '^' + this.VPF2[i+1];
                                }
                            } else
                            {
                                if (this.VPF2[i+1] != 1 && this.VPF2[i] > 0 && i == 1)
                                {
                                    if (this.VPF2[i] != 1)
                                    {
                                        s = s + "" + this.VPF2[i] + 'x' + '^' + this.VPF2[i+1];
                                    } else
                                    {
                                        s = s + "" + 'x' + '^' + this.VPF2[i+1];
                                    }
                                } else
                                {
                                    if (this.VPF2[i] > 0 && i == 1)
                                    {
                                        if(this.VPF2[i]!=1)
                                        {
                                             s = s + "" + this.VPF2[i] + 'x';
                                        }
                                        else
                                        {
                                            s = s + "" + 'x';
                                        }
                                        
                                    } else
                                    {
                                        if (i != 1)
                                        {
                                            if(this.VPF2[i]!=-1)
                                            {
                                                s = s + "" + this.VPF2[i] + 'x';
                                            }else
                                            {
                                                s = s + "-" + 'x';
                                            }
                                        } else
                                        {
                                            if(this.VPF2[i]!=-1)
                                            {
                                                s = s + "" + this.VPF2[i] + 'x';
                                            }else
                                            {
                                                s = s + "-" + 'x';
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                } else
                {
                    if (this.VPF2[i] > 0)
                    {
                        if (i == 1)
                        {
                            s = s + "" + this.VPF2[i];
                        } else
                        {
                            s = s + "+" + this.VPF2[i];
                        }

                    } else
                    {
                        s = s + "" + this.VPF2[i];
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Polinomio: " + s, "Reconstruir", 3);
        }
        
        

    public boolean PolinomioVacio() {
        int i, c;

        c = 0;

        for (i = 1; i < VPF2.length; i++)
        {
            if (VPF2[i] == 0)
            {
                c++;
            }
        }

        if (c == (VPF2.length - 1))
        {
            return true;
        } else
        {
            return false;
        }
    }

    public void Mostrar() {
        int i;
        String s = "";
        for (i = 0; i < this.VPF2.length; i++)
        {
            s += "[" + this.VPF2[i] + "] ";
        }
        JOptionPane.showMessageDialog(null, s);
    }
    
    public void Insertar(){
        int i, j, k, V[];
        boolean b;
        
        V = Polinomios.Ingreso();
        
        for (j=1; j<V.length; j+=2)
        {
            b = true;
            
            for (i=2; (i<VPF2.length) && b; i+=2)
            {
                if (VPF2[i] == V[j])
                {
                    VPF2[i-1] = V[j-1];
                    
                    b = false;
                }
                else
                {
                    if (VPF2[i] < V[j])
                    {
                        Du += 2;
                        
                        RedimensionarG();
                        
                        k = i-1;
                        
                        while(VPF2[k] != 0)
                        {
                            k += 2;
                        }
                        
                        for (k-=1; k!=(i-2); k--)
                        {
                            VPF2[k+2] = VPF2[k];
                        }
                        
                        VPF2[i-1] = V[j-1];
                        VPF2[i] = V[j];
                        
                        b = false;
                    }
                }
            }
        }
        
        VPF2[0] = Du/2;
        
        Mostrar();
    }
}
