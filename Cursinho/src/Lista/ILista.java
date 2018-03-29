/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import java.security.InvalidParameterException;

/**
 *
 * @author 1171139648
 */
public interface ILista<Tipo> extends Iterable<Tipo>{

    public void adicionar(Tipo elemento);
    
    public void adicionar(int posicao, Tipo elemento) throws InvalidParameterException;
    
    public void adicionarNoInicio(Tipo elemento);
    
    public boolean contem(Tipo elemento) throws InvalidParameterException;
    
    public Tipo obter(int posicao)  throws InvalidParameterException;
    
    public int tamanho();
    public int capacidade();
    
    public void remover(int posicao) throws InvalidParameterException;
    
    public int remover(Tipo elemento);
    public void removerDoInicio();
    
    public void limpar();

}

