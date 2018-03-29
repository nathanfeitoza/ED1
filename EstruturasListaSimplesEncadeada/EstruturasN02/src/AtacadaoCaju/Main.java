/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtacadaoCaju;
import javax.swing.JOptionPane;
import unit.ed1.lista.encadeada.ListaSimplesmenteEncadeada;

/**
 *
 * @author 1171139648
 */
public class Main {
    public static void main(String[] args) throws Exception
    {
        int opc = 0;
        Produto produto = new Produto();
        while(opc != 7)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog(""+
                    "Atacadão Caju\n\n"+
                    "1 - Cadastrar Produto\n"+
                    "2 - Registrar Compra\n"+
                    "3 - Registrar Venda\n"+
                    "4 - Exibir informações de um produto\n"+
                    "5 - Imprimir Compras\n"+
                    "6 - Imprimir Vendas\n"+                    
                    "7 - Sair do Sistema\n"                    
                    ));
     
        
        switch(opc){
            case 1:
                String cod_prod = JOptionPane.showInputDialog(null,"Código do produto");
                String nome_prod = JOptionPane.showInputDialog(null,"Nome do produto");
                produto.CadastrarProduto(cod_prod, nome_prod);
                break;
            case 2:
                String prod_cod = JOptionPane.showInputDialog(null,"Código do produto");
                if(produto.ExisteProduto(prod_cod) != -1)
                {
                    String data_compra = JOptionPane.showInputDialog(null,"Data da compra");
                    String qntd_comprada = JOptionPane.showInputDialog(null,"Quantidade comprada");
                    String valor_compra = JOptionPane.showInputDialog(null,"Valor da compra");
                    if( produto.RegistrarCompra(prod_cod, data_compra, qntd_comprada, valor_compra))
                    {
                        JOptionPane.showMessageDialog(null, "Compra realizada com sucesso"); 
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Erro ao realizar compra"); 
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Código inválido");
                }
                break;
            case 3:
               String c_prod = JOptionPane.showInputDialog(null,"Código do produto");
                if(produto.ExisteProduto(c_prod) != -1)
                {
                    String data_venda = JOptionPane.showInputDialog(null,"Data da venda");
                    String qntd_vendida = JOptionPane.showInputDialog(null,"Quantidade vendida");
                    String valor_venda = JOptionPane.showInputDialog(null,"Valor da venda");
                   if(produto.RegistrarVenda(c_prod, data_venda, qntd_vendida, valor_venda))
                   {
                        JOptionPane.showMessageDialog(null, "Venda realizada com sucesso"); 
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null, "Erro ao realizar venda"); 
                   }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Código inválido");
                }
                break;
            case 4:
                String codigo_produto = JOptionPane.showInputDialog(null,"Código do produto");
                try
                {
                    JOptionPane.showMessageDialog(null, produto.RetornarProduto(codigo_produto));
                } catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;
            case 5:
                JOptionPane.showMessageDialog(null, produto.ImprimirCompras());
                break;
            case 6:
                JOptionPane.showMessageDialog(null, produto.ImprimirVendas());
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "Tchau... Até mais!");
                break;
            default:
                 JOptionPane.showMessageDialog(null,"Opção Inválida");
                 break;
                
        }
      }
        
        ListaSimplesmenteEncadeada<String> teste = new ListaSimplesmenteEncadeada();
        
        teste.adicionar("algo");
       // teste.adicionar("algo2");
       // teste.adicionar("algo3");
       // teste.adicionar("algo4");
        //teste.adicionarNoInicio("algo5");
        //teste.adicionar(1,"teste");
        
        //teste.remover(3);
        //teste.remover(2);
        //System.out.println("Contem: "+teste.contem("algo2"));
        /*for(int i = 0; i < teste.tamanho(); i++)
        {
           System.out.println(teste.obter(i)); 
        }*/
        
        //System.out.println(teste.tamanho());
                
        /*for (String elemento : teste) {
            System.out.println(elemento);
        }*/
        //System.out.println(teste.tamanho());
    }
}
