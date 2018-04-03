/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit.ed1.lista.encadeada;

/**
 *
 * @author 11645
 */
class NoDuplamenteEncadeado<Tipo> {
    private Tipo valor;
    private NoDuplamenteEncadeado<Tipo> proximo, anterior;

    public NoDuplamenteEncadeado() {
    }
    
    
    public NoDuplamenteEncadeado(Tipo valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
    

    public NoDuplamenteEncadeado(Tipo valor, NoDuplamenteEncadeado<Tipo> proximo, NoDuplamenteEncadeado<Tipo> anterior) {
        this.valor = valor;
        this.proximo = proximo;
        this.anterior = anterior;
    }
    
    

    /**
     * @return the valor
     */
    public Tipo getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Tipo valor) {
        this.valor = valor;
    }

    /**
     * @return the proximo
     */
    public NoDuplamenteEncadeado<Tipo> getProximo() {
        return proximo;
    }
    
    /**
     * @return the anterior
     */
    public NoDuplamenteEncadeado<Tipo> getAnterior() {
        return anterior;
    }

    /**
     * @param proximo the proximo to set
     */
    public void setProximo(NoDuplamenteEncadeado<Tipo> proximo) {
        this.proximo = proximo;
    }
    /**
     * @param anterior the proximo to set
     */
    public void setAnterior(NoDuplamenteEncadeado<Tipo> anterior) {
        this.anterior = anterior;
    }
}
