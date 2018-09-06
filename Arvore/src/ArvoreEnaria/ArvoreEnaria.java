/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArvoreEnaria;

import Model.Arvores;

/**
 *
 * @author nathan
 */
public class ArvoreEnaria {
    public static Arvores inserir(Arvores aux, int num) {
        if (aux == null) {
            aux = new Arvores();
            aux.num = num;
            aux.esq = null;
            aux.centr = null;
            aux.dir = null;
 
        } else if (num < aux.num) {
            aux.esq = inserir(aux.esq, num);
        } else if(num == aux.num) {
            aux.centr = inserir(aux.centr, num);
        }
        else {
            aux.dir = inserir(aux.dir, num);
        }
        return aux;
    }
 
    public static String imprimir(Arvores aux) {
    	String retorno;
    	retorno = "(";
        if (aux != null) {
        	retorno += "N" + aux.num; 
            retorno += imprimir(aux.esq);
            retorno += imprimir(aux.centr);
            retorno += imprimir(aux.dir);
            
        }
        retorno += ")";
        return retorno;
    }
    
    public static boolean localizar(Arvores aux, int num, boolean loc) {
        if (aux != null && loc == false) {
            if (aux.num == num) {
                loc = true;
            } else if (num < aux.num) {
                loc = localizar(aux.esq, num, loc);
            } else if(num == aux.num) {
                loc = localizar(aux.centr, num, loc);
            }   else {
                loc = localizar(aux.dir, num, loc);
            }
        }
        return loc;
    }
    
    public static Arvores excluir(Arvores aux, int num) {
        Arvores p, p2, r = null;
        if (aux.num == num) {
            if (aux.esq == aux.dir) {
                return null;
            } else if (aux.esq == null) {
                return aux.dir;
            } else if(aux.centr == null){
                
                if (aux.esq == null) {
                    return aux.dir;
                } else {
                    return aux.esq;
                }
                
            } else if (aux.dir == null) {
                return aux.esq;
            } else {
                p2 = aux.dir;
                p = aux.dir;
                while (p.esq != null) {
                    r = p;
                    p = p.esq;
                }
                aux.num = p.num;
                p = null;
                r.esq = null;
                return aux;
            }
        } else if (aux.num < num) {
            aux.dir = excluir(aux.dir, num);
        } else if(aux.num == num){
            aux.centr = excluir(aux.centr, num);
        } else {
            aux.esq = excluir(aux.esq, num);
        }
        return aux;
    } 
}
