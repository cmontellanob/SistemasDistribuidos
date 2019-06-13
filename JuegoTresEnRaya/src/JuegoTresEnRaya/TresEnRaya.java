/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoTresEnRaya;

/**
 *
 * @author Carlos
 */
public class TresEnRaya {
    private String[][] marcado=new String[3][3];
    private int turno;
    public TresEnRaya(int pturno)
    {
        this.turno=pturno;
        this.limpiar();
    }
    private void limpiar()
        {
            marcado[0][0]="";
            marcado[0][1]="";
            marcado[0][2]="";
            marcado[1][0]="";
            marcado[1][1]="";
            marcado[1][2]="";
            marcado[2][0]="";
            marcado[2][1]="";
            marcado[2][2]="";      
        }
    public String jugada(int x, int y, int jugador)
    {
    String marca=(jugador==1)?"X":"O";
    int resultado=0;
    if (jugador==turno)
    {   
        if (marcar(x,y,marca))
           {
                resultado=ganador();
                if (resultado==0){
                    if (empate())
                        return "fin:empate";
                    else
                    {
                        turno=(turno%2)+1;
                        return "jugada:ok";
                    }
                }
                else
                {
                    return "ganador:"+resultado;
                }
           }    
            else    
                return "error:La casilla ya esta marcada";
    }
        
        else return "error:No corresponde el turno al jugador "+marca;
    }
    private boolean marcar(int x, int y, String marca)
        { 
            if("".equals(marcado[x][y]))
                {
                marcado[x][y]=marca;
                return true;
                }
            else
                {
                System.out.println("Casilla ya marcada");
                return false;
                }
           }
            
    private int  ganador()
        {
            //Casillas:
            /*[1    2   3]*/
            /*[4    5   6]*/
            /*[7    8   9]*/
        if((("X".equals(marcado[0][0])) && ("X".equals(marcado[0][1])) && ("X".equals(marcado[0][2])))
                        || (("X".equals(marcado[1][0])) && ("X".equals(marcado[1][1])) && ("X".equals(marcado[1][2])))
                        || (("X".equals(marcado[2][0])) && ("X".equals(marcado[2][1])) && ("X".equals(marcado[2][2])))
                        || (("X".equals(marcado[0][0])) && ("X".equals(marcado[1][0])) && ("X".equals(marcado[2][0])))
                        || (("X".equals(marcado[0][1])) && ("X".equals(marcado[1][1])) && ("X".equals(marcado[2][1])))
                        || (("X".equals(marcado[0][2])) && ("X".equals(marcado[1][2])) && ("X".equals(marcado[2][2])))
                        || (("X".equals(marcado[0][0])) && ("X".equals(marcado[1][1])) && ("X".equals(marcado[2][2])))
                        || (("X".equals(marcado[0][2])) && ("X".equals(marcado[1][1])) && ("X".equals(marcado[2][0]))))
                        {
                             System.out.println("El ganador es el juagdor 1");
                            return 1;
                        }
        else if((("O".equals(marcado[0][0])) && ("O".equals(marcado[0][1])) && ("O".equals(marcado[0][2])))
                        || (("O".equals(marcado[1][0])) && ("O".equals(marcado[1][1])) && ("O".equals(marcado[1][2])))
                        || (("O".equals(marcado[2][0])) && ("O".equals(marcado[2][1])) && ("O".equals(marcado[2][2])))
                        || (("O".equals(marcado[0][0])) && ("O".equals(marcado[1][0])) && ("O".equals(marcado[2][0])))
                        || (("O".equals(marcado[0][1])) && ("O".equals(marcado[1][1])) && ("O".equals(marcado[2][1])))
                        || (("O".equals(marcado[0][2])) && ("O".equals(marcado[1][2])) && ("O".equals(marcado[2][2])))
                        || (("O".equals(marcado[0][0])) && ("O".equals(marcado[1][1])) && ("O".equals(marcado[2][2])))
                        || (("O".equals(marcado[0][2])) && ("O".equals(marcado[1][1])) && ("O".equals(marcado[2][0]))))
                        {
                             System.out.println("El ganador es el juagdor 2");
                            return 2;
                        }
        else
        { return 0;
        }
        }
        private boolean empate()
        {
            if((!"".equals(marcado[0][0])) && (!"".equals(marcado[0][0])) && (!"".equals(marcado[0][1])) && (!"".equals(marcado[0][2])) && (!"".equals(marcado[1][0])) 
                    && (!"".equals(marcado[1][1])) && (!"".equals(marcado[1][2])) && (!"".equals(marcado[2][0])) && (!"".equals(marcado[2][1])) && (!"".equals(marcado[2][2])))
            {
                System.out.print("Es un empate");
                return true;
            }
            else
                return false;
        }
}
