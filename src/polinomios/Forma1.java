
package polinomios;

import javax.swing.JOptionPane;

public class Forma1 {
    private int Du, VPF1[];

    public Forma1() {
        Du=0;
        VPF1 = new int[20];
    }
    
    public Forma1(int Expm) {
        Du = Expm+1;
        VPF1 = new int[Du+1];
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public int[] getVPF1() {
        return VPF1;
    }

    public void setVPF1(int[] VAux) {
        VPF1 = VAux;
    }

    public int getVPF1(int pos) {
        return VPF1[pos];
    }

    public void setVPF1(int pos, int d) {
        VPF1[pos] = d;
    }
    //Métodos
    
       public void Construir (int []vp)
    {
         int i,exp=0, Pos=0, coef=0;
         String s="";
         Forma1 P = new Forma1(Grado(vp));
         Du=P.Du;
         P.VPF1= new int [Du+1];
         P.VPF1[0]=Grado(vp);
         
         for(i=0; i<vp.length; i++)
         {
             if (i%2==0)
             {
                 coef= vp[i]; 
             }else
             {
                exp=vp[i];
                Pos=Du-exp;
                P.VPF1[Pos]=coef;
             }
         }
         this.setVPF1(P.VPF1);
    }   
       public void Mostrar()
       {
           int i;
           String s ="";
           for(i=0; i<this.VPF1.length; i++)
           {
               s += "[" + this.VPF1[i] + "] ";
           }
             JOptionPane.showMessageDialog(null, s);
       }
       
    public void Sumar(Forma1 P1, Forma1 P2) {
        int Pos, i, j, n, m, exA, exB, k = 1, r;
        Forma1 P;
        if (P1.Du > P2.Du)
        {
            P = new Forma1(P1.VPF1[0]); P.VPF1[0] = P1.VPF1[0];
            n = P1.Du; m = P2.Du;
        } else
        {
            P = new Forma1(P2.VPF1[0]); P.VPF1[0] = P2.VPF1[0];
            n = P2.Du; m = P1.Du;
        }
        if (P2.Du != P1.Du)
        {
            r = n - m;
            for (k = 1; k <= r; k++)
            {
                if (P1.Du == n)
                {
                    P.VPF1[k] = P1.VPF1[k];
                } else
                {
                    P.VPF1[k] = P2.VPF1[k];
                }
            }
        }
        for (i = k; i < n+1; i++)
        {
            for (j = 1; j < m+1; j++)
            {
                exA = n - i;
                exB = m - j;

                if (exA == exB)
                {
                    if (P1.Du == n)
                    {
                        P.VPF1[i] = P1.VPF1[i] + P2.VPF1[j];
                    } else
                    {
                        P.VPF1[i] = P1.VPF1[j] + P2.VPF1[i];
                    }
                }

            }
        }

        P.Reconstruir();
        P.Mostrar();
        P2.setDu(0);
       
    }

    public void Evaluar(int n) {
        int i, exp = 0;
        double r = 0;
        int re = 0;
        for (i = 1; i < this.VPF1.length; i++)
        {
            exp = this.Du - i;
            r = r + (this.VPF1[i] * Math.pow(n, exp));
            re = (int) Math.round(r);
        }
        JOptionPane.showMessageDialog(null, "El resultado es: " + re, "Evaluar", 3);
    }

    public void Multiplicar(Forma1 P1, Forma1 P2) {
        int r = 0, j, i = 0, expA, expB, expC, pos;

        Forma1 P3 = new Forma1(P1.VPF1[0] + P2.VPF1[0]);

        P3.VPF1[0] = P1.VPF1[0] + P2.VPF1[0];

        for (i = 1; i < P1.VPF1.length; i++)
        {
            for (j = 1; j < P2.VPF1.length; j++)
            {
                expA = P1.Du - i;
                expB = P2.Du - j;
                expC = expA + expB;
                pos = P3.Du - expC;
                r = P1.VPF1[i] * P2.VPF1[j];
                P3.VPF1[pos] = P3.VPF1[pos] + r;
            }
        }
        P3.Reconstruir();
        P3.Mostrar();
        P2.setDu(0);
        
    }
    public void Insertar(int coef, int exp)
    {
        int pos=0;
        if(this.VPF1[0]<exp)
        {
           this.Redimencionar(exp, coef);
        }
        else
        {
            pos=this.Du-exp;
            
            if(this.VPF1[pos]==0)
            {
                this.VPF1[pos]=coef;
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Ya existe un dato con este exponente","Exponente repetido",3);
            }
        }
    }
      
    public void Eliminar(int exp)
    {
        boolean r=true;
        int i=0, ex1, pos;
        for (i=0;i<this.VPF1.length;i++)
        {
            ex1=this.Du-i;
            pos=this.Du-ex1;
            
            if(ex1==exp && this.VPF1[i] != 0)
            {
               if(this.Du-1>exp)
               {
                       this.VPF1[pos] = 0;
               }
               else
               {
                   this.Ajustar();
               }
                JOptionPane.showMessageDialog(null, "Término eliminado correctamente ", "Eliminar", 3);
                r = false;
            }
        }  
        if(r)
        {
            JOptionPane.showMessageDialog(null,"El término a eliminar, no está en el polinomio: ","Dato no encontrado",0);
        }
        this.Reconstruir();
    }
    public void Redimencionar(int exp, int coef)
     {
        int i, j=exp- this.VPF1[0];
       
        Forma1 P= new Forma1(exp);
        P.VPF1[0]=exp;
        P.VPF1[1]=coef;
        for(i=1;i<this.VPF1.length;i++)
        {
            P.VPF1[j+i]=this.VPF1[i];
        }
        this.setDu(P.Du);
        this.setVPF1(P.VPF1);
    }
    
    public void RedimensionarP(){
        int V[], i;
        
        V = new int[Du+1];
        
        for (i=0; i<V.length; i++)
        {
            V[i] = VPF1[i];
        }
        
        VPF1 = V;
    }
    
    public void RedimensionarG(){
        int V[], i, Pos;
        
        V = new int [Du+1];
        
        for (i=1; i<VPF1.length; i++)
        {
            Pos = Du-((VPF1[0]+1)-i);
            V[Pos] = VPF1[i];
        }
        
        VPF1 = V;
    }
    
    public void Ajustar() {
        int i = 2, j = 0;
        Forma1 P;

        if (this.Du < 2)
        {
            P = new Forma1(0);
            P.VPF1[1] = 0;
        } else
        {
            while (this.VPF1[i] == 0 && i < this.VPF1.length - 1)
            {
                i++;
            }
            P = new Forma1(this.Du - i);
            if (i != this.VPF1.length)
            {
                for (j = 0; j < P.VPF1.length; j++)
                {
                    if (j == 0)
                    {
                        P.VPF1[j] = this.Du - i;
                    } else
                    {
                        P.VPF1[j] = this.VPF1[i];
                        i++;
                    }
                }
            }
        }
        this.setVPF1(P.VPF1);
        this.Du = P.Du;
    }
      
    public void Reconstruir() {
        int i, exp;

        String s = "";

        for (i = 1; i < this.VPF1.length; i++)
        {
            exp = this.Du - i;
            if (this.VPF1[i] != 0)
            {
                if (exp != 0)
                {
                    if (exp != 1 && this.VPF1[i] < 0)
                    {
                        if (this.VPF1[i] != -1)
                        {
                            s = s + "" + this.VPF1[i] + 'x' + '^' + exp;
                        } else
                        {
                            s = s + "-" + 'x' + '^' + exp;
                        }
                    } else
                    {
                        if (exp == 1 && this.VPF1[i] > 0 && i != 1)
                        {
                            if (this.VPF1[i] != 1)
                            {
                                s = s + "+" + this.VPF1[i] + 'x';
                            } else
                            {
                                if(exp!=1)
                                {
                                    s = s + "+" + 'x' + '^' + exp;
                                }else
                                {
                                    s = s + "+" + 'x';
                                }
                            }
                        } else
                        {
                            if (exp != 1 && this.VPF1[i] > 0 && i != 1)
                            {
                                if (this.VPF1[i] != 1)
                                {
                                    s = s + "+" + this.VPF1[i] + 'x' + '^' + exp;
                                } else
                                {
                                    s = s + "+" + 'x' + '^' + exp;
                                }
                            } else
                            {
                                if (exp != 1 && this.VPF1[i] > 0 && i == 1)
                                {
                                    if (this.VPF1[i] != 1)
                                    {
                                        s = s + "" + this.VPF1[i] + 'x' + '^' + exp;
                                    } else
                                    {
                                        s = s + "" + 'x' + '^' + exp;
                                    }
                                } else
                                {
                                    if (this.VPF1[i] > 0 && i == 1)
                                    {
                                        if(this.VPF1[i]!=1)
                                        {
                                             s = s + "" + this.VPF1[i] + 'x';
                                        }
                                        else
                                        {
                                            s = s + "" + 'x';
                                        }
                                        
                                    } else
                                    {
                                        if (i != 1)
                                        {
                                            if(this.VPF1[i]!=-1)
                                            {
                                                s = s + "" + this.VPF1[i] + 'x';
                                            }else
                                            {
                                                s = s + "-" + 'x';
                                            }
                                        } else
                                        {
                                            if(this.VPF1[i]!=-1)
                                            {
                                                s = s + "" + this.VPF1[i] + 'x';
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
                    if (this.VPF1[i] > 0)
                    {
                        if (i == 1)
                        {
                            s = s + "" + this.VPF1[i];
                        } else
                        {
                            s = s + "+" + this.VPF1[i];
                        }

                    } else
                    {
                        s = s + "" + this.VPF1[i];
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Polinomio: " + s, "Reconstruir", 3);
    }
    
    
      public int Grado( int[] Vp)
   {
       int i, n=0;
       for(i=0;i<Vp.length;i++)
       {
           if(i%2==1 && Vp[i]>n)
           {
              n=Vp[i];
           }
       }  
       return n;
   }

  
}
