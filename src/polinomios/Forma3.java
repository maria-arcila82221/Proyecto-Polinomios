
package polinomios;

import javax.swing.JOptionPane;

public class Forma3 {
    private Nodo Punta;

    public Forma3() {
        Punta = null;
    }
       
    public void Construir(int[] V){
        Nodo x, p;
        int i, j, Va[];
        
        p = new Nodo();
        
        if (V.length > 2)
        {
            Va = new int[2];
            
            for (i=1; i<V.length; i+=2)
            {
                for (j=(i+2); j<V.length; j+=2)
                {
                    if (V[j] > V[i])
                    {
                        Va[0] = V[i-1];
                        Va[1] = V[i];
                        V[i-1] = V[j-1];
                        V[i] = V[j];
                        V[j-1] = Va[0];
                        V[j] = Va[1];
                    }
                }
            }
        }
        
        for (i=1; i<V.length; i+=2)
        {
            x = new Nodo(V[i-1], V[i]);
            
            if (i == 1)
            {
                Punta = x;
                p = x;
            }
            else
            {
                p.setLiga(x);
                p = p.getLiga();
            }
        }
   }
    
    public boolean PolinomioVacio(){
        return Punta == null;
    }
    
    public void Mostrar(){
        Nodo p;
        String s;
        
        s = "";
            
        for (p=Punta; p!=null; p=p.getLiga())
        {
            if (p.getLiga() != null)
            {
                s = s + "[" + p.getCoe() + "]" + p.getExp() + "] -> ";
            }
            else
            {
                s = s + "[" + p.getCoe() + "]" + p.getExp() + "]";
            }
        }
        
        JOptionPane.showMessageDialog(null, s);
    }

    public void InsertarFinal(int c, int e){
        Nodo p, x;
        
        x = new Nodo(c, e);
        
        if (Punta == null)
        {
            Punta = x;
        }
        else
        {
            p = Punta;
            
            while(p.getLiga() != null)
            {
                p = p.getLiga();
            }
            
            p.setLiga(x);
        }
    }
    
    public void Sumar(){
        int i, V[];
        boolean b;
        Nodo p, x, q;
        
        V = Polinomios.Ingreso();
        q = new Nodo();
        
        for (i=1; i<V.length; i+=2)
        {
            b = true;
            
            for (p=Punta; (p!=null) && b; p=p.getLiga())
            {
                if (p.getExp() == V[i])
                {
                    p.setCoe(p.getCoe()+V[i-1]);
                    
                    b = false;
                }
                else
                {
                    if (p.getExp() < V[i])
                    {
                        x = new Nodo(V[i-1], V[i]);
                        
                        if (p==Punta)
                        {
                            x.setLiga(p);
                            
                            Punta = x;
                        }
                        else
                        {
                            if (p.getLiga() != null)
                            {
                                q.setLiga(x);
                                x.setLiga(p);
                            }
                            else
                            {
                                p.setLiga(x);
                            }
                        }
                        
                        b = false;
                    }
                }
                
                q = p;
            }
        }
        
        Mostrar();
    }
}
