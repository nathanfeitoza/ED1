/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtacadaoCaju;

import unit.ed1.lista.encadeada.ListaSimplesmenteEncadeada;

/**
 *
 * @author 1171139648
 */
public class Produto {
    
    private ListaSimplesmenteEncadeada<String[]> produtos = new ListaSimplesmenteEncadeada();
    private ListaSimplesmenteEncadeada<Integer> produtos_codigos = new ListaSimplesmenteEncadeada();
    
    private ListaSimplesmenteEncadeada<String[]> registrar_compra = new ListaSimplesmenteEncadeada();
    private ListaSimplesmenteEncadeada<Integer> comprados_codigo = new ListaSimplesmenteEncadeada();
    
    private ListaSimplesmenteEncadeada<String[]> registrar_venda = new ListaSimplesmenteEncadeada();
    private ListaSimplesmenteEncadeada<Integer> vendidos_codigo = new ListaSimplesmenteEncadeada();
    private int pos = 0;
    
    public void CadastrarProduto(String codigo, String nome)
    {
       String[] produto_add = {codigo, nome, "0","0"}; 
       int posicao_codigo = Integer.parseInt( codigo );
       this.produtos.adicionar(produto_add);
       this.produtos_codigos.adicionar(posicao_codigo);
    }
    
    public int ExisteProduto(String cod_prod)
    {
        return this.produtos_codigos.PosicaoContem(Integer.parseInt(cod_prod));
    }
    
    public String RetornarProduto(String cod_prod) throws Exception
    {
        String retorno = "";
        int posicao_elemento = this.ExisteProduto(cod_prod);
        if(posicao_elemento != -1)
        {
            String[] produto = this.produtos.obter(posicao_elemento);
            for(int i = 0; i < produto.length; i++)
            {
                switch(i)
                {
                    case 0:
                        retorno += "Cod. Prod: ";
                        break;
                    case 1:
                        retorno += "Nome Prod: ";
                        break;
                    case 2:
                        retorno += "Quant. Estoque: ";
                        break;
                    default:
                        retorno += "Custo Unitário: ";      
                }
                retorno += produto[i]+"\n";
                System.out.println("testando -> "+produto[i]);
            } 
        }
        else
        {
            throw new Exception("Codigo não encontrado");
        }
        
        return retorno;
    }
    
    public void GravarEstoqueCustoUnitario(String cod_prod,String custoUnitario, String QntdEstoque) throws Exception
    {
        int codigo_prod = Integer.parseInt(cod_prod);
        int posicao_elemento = this.produtos_codigos.PosicaoContem(codigo_prod);
        if(posicao_elemento != -1)
        {
            String[] produto = this.produtos.obter(posicao_elemento);
            double qntd_estoque = Double.parseDouble(produto[2]);
            double qntd_adicionar = Double.parseDouble(QntdEstoque);
            double qntd_atualizar = qntd_estoque + qntd_adicionar;
            produto[2] = ""+qntd_atualizar;
            produto[3] = custoUnitario;
            this.produtos.remover(posicao_elemento);
            this.produtos.adicionar(posicao_elemento, produto);
        }
        else
        {
            throw new Exception("Codigo não encontrado");
        }
    }
    
    public boolean RegistrarCompra(String cod_produto,String data_compra, String qntd_comprada, String valor_compra) throws Exception
    {
        boolean retorno = false;
        try
        {
            double qntd_c = Double.parseDouble(qntd_comprada);
            double valor_c = Double.parseDouble(valor_compra);
            double custo_unitario = valor_c / qntd_c;
            String[] compra = {cod_produto,data_compra,qntd_comprada,valor_compra};
            this.registrar_compra.adicionar(compra);
            int cod_registrar = Integer.parseInt(cod_produto);
            this.comprados_codigo.adicionar(cod_registrar);
            this.GravarEstoqueCustoUnitario(cod_produto, ""+custo_unitario+"", qntd_comprada);
            
            retorno = true;
        }
        finally
        {
            return retorno;
        }
        
    }
    
    public boolean RegistrarVenda(String cod_produto,String data_venda, String qntd_vendida, String valor_venda)
    {
        boolean retorno = false;
        try
        {
          int posicao_produto = this.ExisteProduto(cod_produto);
          if(posicao_produto != -1)
          {
            double qntd_c = Double.parseDouble(qntd_vendida); 
            String[] venda = {cod_produto,data_venda,qntd_vendida,valor_venda};
            this.registrar_venda.adicionar(venda);
            int cod_registrar = Integer.parseInt(cod_produto);
            this.vendidos_codigo.adicionar(cod_registrar);
            
            String[] produto_att = this.produtos.obter(posicao_produto);
            
            double qntd_antiga = Double.parseDouble(produto_att[2]);
            double qntd_nova = (qntd_antiga - qntd_c) > 0 ? (qntd_antiga - qntd_c) : 0;
            produto_att[2] = ""+qntd_nova;
            this.produtos.remover(posicao_produto);
            this.produtos.adicionar(posicao_produto, produto_att);
            retorno = true;
            System.out.println("tudo certo");
          }
          else
          {
              System.out.println(posicao_produto);
          }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            return retorno;
        }
    }
    
    public String ImprimirCompras()
    {
       String retorno = "";
        for (String[] compras : this.registrar_compra) 
        {
            int posic = 0;
            for(String compra : compras)
            {
                switch(posic)
                {
                    case 0:
                        retorno += "Cód. Prod: ";
                        break;
                    case 1:
                        retorno += "Data Compra: ";
                        break;
                    case 2:
                        retorno += "Qntd. Comprada: ";
                        break;
                    default:
                        retorno += "Valor compra: ";
                }
                retorno += compra+"\n";
                posic++;
            }
            retorno += "\n";
        }
        
        return retorno;
    }
    
        public String ImprimirVendas()
    {
       String retorno = "";
        for (String[] vendas : this.registrar_venda) 
        {
            int posic = 0;
            for(String venda : vendas)
            {
                switch(posic)
                {
                    case 0:
                        retorno += "Cód. Prod: ";
                        break;
                    case 1:
                        retorno += "Data Venda: ";
                        break;
                    case 2:
                        retorno += "Qntd. Vendida: ";
                        break;
                    default:
                        retorno += "Valor Vendido: ";
                }
                retorno += venda+"\n";
                posic++;
            }
            retorno += "\n";
        }
        
        return retorno;
    }
}
