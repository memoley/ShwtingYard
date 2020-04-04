/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shutingyard;

import java.util.Stack;

/**
 *
 * @author memol
 */
public abstract class ShutingYard {
    private static String resultado;
    private static Stack<String> pila=new Stack<>();
    public static String ShutingYard(String operacion){
        resultado="";
        for(int i=0; i<operacion.length();i++){
            String digito = operacion.substring(i, i+1);
            switch(digito){
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                case "(":
                    insertarPila(digito);
                    break;
                case ")":
                    while(!pila.isEmpty() && !pila.peek().equals("("))
                        resultado+=pila.pop();
                    if(!pila.isEmpty())
                        pila.pop();
                    break;
                default:
                    resultado+=digito;
            }
        }
        while(!pila.isEmpty())
            resultado+=pila.pop();
        return resultado;
    }
    
    private static void insertarPila(String digito){
        if(pila.isEmpty() || digito.equals("("))
            pila.push(digito);
        else if(isJerarquico(digito))
            pila.push(digito);
        else{
            resultado+=pila.pop();
            while(!isJerarquico(digito))
                resultado+=pila.pop();
            pila.push(digito);
        }
    }
    
    private static boolean isJerarquico(String digito){
        if(pila.isEmpty())
            return true;
        String top = pila.peek();       
        if((digito.equals("+") || digito.equals("-") || digito.equals("*") || digito.equals("+")) && top.equals("^")){
            return false;
        }else if((digito.equals("+") || digito.equals("-")) && (top.equals("*") || top.equals("/"))){
            return false;
        }else
        return true; 
    }
    
}
