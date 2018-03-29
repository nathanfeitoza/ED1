/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturalista;

import java.security.InvalidParameterException;

/**
 *
 * @author 1171139648
 */
public interface ILista extends Iterable<Object>{
    public void adicionar(Object elemento);
    public void adicionar(int posicao, Object elemento) throws InvalidParameterException;
    public void adicionarNoInicio(Object elemento);
    public boolean contem(Object elemento);
    public Object obter(int posicao);
    public int tamanho();
    public int capacidade();
    public void remover(int posicao);
    public void remover(Object elemento);
    public void removerDoInicio();
    public void limpar();
}
