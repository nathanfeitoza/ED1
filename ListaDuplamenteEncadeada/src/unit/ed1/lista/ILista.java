/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit.ed1.lista;

import java.security.InvalidParameterException;

/**
 *
 * @author 11645
 */
public interface ILista<Tipo> extends Iterable<Tipo>{

    public void adicionar(Tipo elemento);
    
    public void adicionar(int posicao, Tipo elemento) throws InvalidParameterException;
    
    public void adicionarNoInicio(Tipo elemento);
    
    public boolean contem(Tipo elemento) throws InvalidParameterException;
    
    public Tipo obter(int posicao)  throws InvalidParameterException;
    
    public int tamanho();
    
    public default int capacidade(){
        return Integer.MAX_VALUE;
    }
    
    public void remover(int posicao) throws InvalidParameterException;
    
    public int remover(Tipo elemento);
    public void removerDoInicio();
    
    public void limpar();

}
