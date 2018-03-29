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
class NoSimplesmenteEncadeado<Tipo> {
    private Tipo valor;
    private NoSimplesmenteEncadeado<Tipo> proximo;

    public NoSimplesmenteEncadeado() {
    }
    
    
    public NoSimplesmenteEncadeado(Tipo valor) {
        this.valor = valor;
        this.proximo = null;
    }
    

    public NoSimplesmenteEncadeado(Tipo valor, NoSimplesmenteEncadeado<Tipo> proximo) {
        this.valor = valor;
        this.proximo = proximo;
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
    public NoSimplesmenteEncadeado<Tipo> getProximo() {
        return proximo;
    }

    /**
     * @param proximo the proximo to set
     */
    public void setProximo(NoSimplesmenteEncadeado<Tipo> proximo) {
        this.proximo = proximo;
    }
}
