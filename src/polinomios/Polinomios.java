package polinomios;

import javax.swing.JOptionPane;

public class Polinomios {

    public static void main(String[] args) {
        Validar Val = new Validar();

        int op = 0, x, coef, exp;
        Forma1 P1 = new Forma1(), P2 = new Forma1(), P3 = new Forma1(),P=new Forma1();
        Forma2 F2 = new Forma2(), F=new Forma2();
        Forma3 F3 = new Forma3();

        do
        {
            op = Val.Validar_int("""   
                                                Menú Polinomios  
                                                                                                                                   
                                            1. Polinomios Forma 1.
                                            2. Polinomios Forma 2.
                                            3. Polinomios Forma 3.
                                            4. Operaciones con formas.
                                            5. Salir.
                                            """);
            switch (op)
            {
                case 1 ->
                {
                    P1.Construir(Ingreso());
                    do
                    {

                        op = Val.Validar_int("""   
                                                Menú Forma 1 
                                                                                                                                   
                                            1. Mostrar Polinomio Forma 1
                                            2. Insertar un término
                                            3. Eliminar un término
                                            4. Mostrar Polinomio (Reconstruir)
                                            5. Evaluar según valor de x;
                                            6. Sumar
                                            7. Multiplicar
                                            0. Salir
                                            """);
                        switch (op)
                        {
                            case 1 ->
                            {
                                P1.Mostrar();
                            }
                            case 2 ->
                            {
                                coef = Val.Validar_int("""   
                                                Ingresa coeficiente del nuevo término: 
                                            """);
                                exp = Val.Validar_int("""   
                                                Ingresa el exponente del nuevo término: 
                                            """);
                                P1.Insertar(coef, exp);
                                P1.Reconstruir();

                            }
                            case 3 ->
                            {
                                exp = Val.Validar_int("""   
                                                Ingresa el exponente del término a eliminar:
                                            """);
                                P1.Eliminar(exp);
                            }
                            case 4 ->
                            {
                                P1.Reconstruir();
                            }
                            case 5 ->
                            {
                                x = Val.Validar_int("""   
                                                ¿Por qué valor quieres reemplazar a x?
                                            """);
                                P1.Evaluar(x);

                            }
                            case 6 ->
                            {
                                JOptionPane.showMessageDialog(null, "A continuación ingresa el polinomio a sumar", "Suma de polinomios", 3);
                                P2.Construir(Ingreso());
                                P.Sumar(P1, P2);

                            }
                            case 7 ->
                            {
                                JOptionPane.showMessageDialog(null, "A continuación ingresa el polinomio a multiplicar", "Multiplicación de polinomios", 3);
                                P2.Construir(Ingreso());
                                P3.Multiplicar(P1, P2);
                            }
                            case 0 ->
                            {
                                JOptionPane.showMessageDialog(null, "De vuelta al menú principal", "Salida", 2);
                            }
                            default ->
                            {
                                JOptionPane.showMessageDialog(null, "Opción inválida", "Dato incorrecto", 0);
                            }

                        }
                    } while (op != 0);
                }
                case 2 ->
                {
                    F2.Construir(Ingreso());
                    do
                    {
                        op = Val.Validar_int("""   
                                                Menú Forma 2 
                                                                                                                                   
                                            1. Mostrar Polinomio Forma 2
                                            2. Insertar un término
                                            3. Eliminar un término
                                            4. Mostrar Polinomio (Reconstruir)
                                            5. Evaluar según valor de x;
                                            6. Sumar
                                            7. Multiplicar
                                            0. Salir
                                            """);

                        switch (op)
                        {
                            case 1 ->
                            {
                                F2.Mostrar();
                            }

                            case 2 ->
                            {
                                if (F2.PolinomioVacio())
                                {
                                    JOptionPane.showMessageDialog(null, "No hay polinomio");
                                } else
                                {
                                     F2.Insertar();
                                }
                            }

                            case 3 ->
                            {
                                if (F2.PolinomioVacio())
                                {
                                    JOptionPane.showMessageDialog(null, "No hay polinomio");
                                } else
                                {
                                    // F2.Eliminar();
                                    JOptionPane.showMessageDialog(null, "", "En mantenimiento :)", 0);
                                }
                            }

                            case 4 ->
                            {
                               
                                    F2.Reconstruir();
                              
                            }

                            case 5 ->
                            {
                                if (F2.PolinomioVacio())
                                {
                                    JOptionPane.showMessageDialog(null, "No hay polinomio");
                                } else
                                {
                                    x = Val.Validar_int("""   
                                                ¿Por qué valor quieres reemplazar a x?
                                                """);
                                    F2.Evaluar(x);
                                }
                            }

                            case 6 ->
                            {
                                if (F2.PolinomioVacio())
                                {
                                    JOptionPane.showMessageDialog(null, "No hay polinomio");
                                } else
                                {
                                    F2.Sumar();
                                }
                            }

                            case 7 ->
                            {
                                if (F2.PolinomioVacio())
                                {
                                    JOptionPane.showMessageDialog(null, "No hay polinomio");
                                } else
                                {
                                     JOptionPane.showMessageDialog(null, "A continuación ingresa el polinomio a multiplicar", "Multiplicación de polinomios", 3);
                                     F.Construir(Ingreso());
                                     F2.Multiplicar(F2, F);
                                }
                            }

                            case 0 ->
                            {
                                JOptionPane.showMessageDialog(null, "De vuelta al menú principal", "Salida", 2);
                            }
                            default ->
                            {
                                JOptionPane.showMessageDialog(null, "Opción inválida", "Dato incorrecto", 0);
                            }
                        }
                    } while (op != 0);
                }
                case 3 ->
                {
                    F3.Construir(Ingreso());
                    do
                    {
                        op = Val.Validar_int("""   
                                                Menú Forma 3 
                                                                                                                                   
                                            1. Mostrar Polinomio Forma 3
                                            2. Insertar un término
                                            3. Eliminar un término
                                            4. Mostrar Polinomio (Reconstruir)
                                            5. Evaluar según valor de x;
                                            6. Sumar
                                            7. Multiplicar
                                            0. Salir
                                            """);
                        switch (op)
                        {
                            case 1 ->
                            {
                                F3.Mostrar();
                            }

                            case 2 ->
                            {
                                if (F3.PolinomioVacio())
                                {
                                    JOptionPane.showMessageDialog(null, "No hay polinomio");
                                } else
                                {
                                    //F3.Insertar();
                                    JOptionPane.showMessageDialog(null, "", "En mantenimiento :)", 0);
                                }
                            }

                            case 3 ->
                            {
                                if (F3.PolinomioVacio())
                                {
                                    JOptionPane.showMessageDialog(null, "No hay polinomio");
                                } else
                                {
                                    //F3.Eliminar();
                                    JOptionPane.showMessageDialog(null, "", "En mantenimiento :)", 0);
                                }
                            }

                            case 4 ->
                            {
                                if (F3.PolinomioVacio())
                                {
                                    JOptionPane.showMessageDialog(null, "No hay polinomio");
                                } else
                                {
                                    //F3.Reconstruir();
                                    JOptionPane.showMessageDialog(null, "", "En mantenimiento :)", 0);
                                }
                            }

                            case 5 ->
                            {
                                if (F3.PolinomioVacio())
                                {
                                    JOptionPane.showMessageDialog(null, "No hay polinomio");
                                } else
                                {
                                    //F3.Evaluar();
                                    JOptionPane.showMessageDialog(null, "", "En mantenimiento :)", 0);
                                }
                            }

                            case 6 ->
                            {
                                if (F3.PolinomioVacio())
                                {
                                    JOptionPane.showMessageDialog(null, "No hay polinomio");
                                } else
                                {
                                     F3.Sumar();
                                }
                            }

                            case 7 ->
                            {
                                if (F3.PolinomioVacio())
                                {
                                    JOptionPane.showMessageDialog(null, "No hay polinomio");
                                } else
                                {
                                    //F3.Multiplicar();
                                    JOptionPane.showMessageDialog(null, "", "En mantenimiento :)", 0);
                                }
                            }

                            case 0 ->
                            {
                                JOptionPane.showMessageDialog(null, "De vuelta al menú principal", "Salida", 2);
                            }
                            default ->
                            {
                                JOptionPane.showMessageDialog(null, "Opción inválida", "Dato incorrecto", 0);
                            }
                        }
                    } while (op != 0);

                }

                case 4 ->
                {

                }
                case 5 ->
                {
                    JOptionPane.showMessageDialog(null, "Adiós, gracias por usar nuestro menú :)", "Salir :(", 3);
                }
                default ->
                {
                    JOptionPane.showMessageDialog(null, "Opción inválida", "Dato incorrecto", 0);
                }
            }

        } while (op != 5);
    }

    public static int[] Ingreso() {
        String sp, Vs[], s;
        char Vc[];
        int i, j, Vp[], n = 0;
        s = "";
        j = 0;
        sp = JOptionPane.showInputDialog(null, "Ingresa un polinomio: ", "Ingreso del Polinomio", 3);
        Vc = sp.toCharArray();
        Vs = new String[Vc.length + 1];
        for (i = 0; i < Vc.length; i++)
        {
            s += "[" + Vc[i] + "] ";
        }
        s = "";

        for (i = 0; i < Vc.length; i++)
        {
            if (Character.isDigit(Vc[i]) || (Vc[i] == '-') || (Vc[i] == '+'))
            {
                if (Vc[i] == '+' || Vc[i] == '-')
                {
                    if ((i > 0) && Character.isDigit(Vc[i - 1]))
                    {
                        if (((i > 1) && (Vc[i - 2] != '^')) || (i == 1))
                        {
                            Vs[j] = s;
                            s = "";
                            j++;
                            Vs[j] = "0";
                            j++;
                        }
                        if (Vc[i] == '-')
                        {
                            s += Vc[i];
                        }
                    } else
                    {
                        if (Vc[i] == '-')
                        {
                            s += Vc[i];
                        }
                    }
                } else
                {
                    s += Vc[i];
                }
            } else
            {
                if (Vc[i] == 'x')
                {
                    if (i == 0)
                    {
                        Vs[j] = "1";

                        j++;
                    } else
                    {
                        if (Vc[i - 1] == '+')
                        {
                            Vs[j] = "1";

                            j++;
                        } else
                        {
                            if (s.equals("-"))
                            {
                                Vs[j] = "-1";
                                s = "";

                                j++;
                            } else
                            {
                                Vs[j] = s;
                                s = "";

                                j++;
                            }
                        }
                    }
                    if ((i < (Vc.length - 1)) && (Vc[i + 1] == '^'))
                    {
                        Vs[j] = Character.toString(Vc[i + 2]);
                        i += 2;
                        j++;
                    } else
                    {
                        Vs[j] = "1";
                        j++;
                    }
                }
            }
            if ((i == (Vc.length - 1)) && (!s.equals("")))
            {
                Vs[j] = s;
                j++;
                Vs[j] = "0";
                j++;
            }
        }
        s = "";
        for (i = 0; i < Vs.length; i++)
        {
            if (Vs[i] == null)
            {
                n++;
            }
        }
        Vp = new int[Vs.length - n];
        for (i = 0; i < Vs.length - n; i++)
        {
            Vp[i] = Integer.parseInt(Vs[i]);
            s += "[" + Vp[i] + "] ";
        }

        return Vp;
    }

}
