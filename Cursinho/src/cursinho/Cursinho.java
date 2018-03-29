/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursinho;

import javax.swing.JOptionPane;

/**
 *
 * @author 1171139648
 */
public class Cursinho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc = 0;
        Turmas turma = new Turmas();
        Aluno aluno = new Aluno();
        while(opc != 8)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog(""+
                    "Cursinho Passadinho\n\n"+
                    "1 - Cadastrar Turmas\n"+
                    "2 - Cadastrar Aluno\n"+
                    "3 - Efetuar Matrícula\n"+
                    "4 - Cancelar Matrícula\n"+
                    "5 - Cancelar Turma\n"+
                    "6 - Listar Alunos na Turma\n"+                    
                    "7 - Listar Turmas\n"+                    
                    "8 - Sair\n"                    
                    ));
     
        
            switch(opc){
                case 1:
                    String codigo_turma = JOptionPane.showInputDialog(null,"Código da turma");
                    String max_alunos = JOptionPane.showInputDialog(null,"Máximo de alunos");
                    try
                    {
                        turma.Cadastrar(codigo_turma, max_alunos);
                        JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso");
                    } catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 2:
                    String nome_aluno = JOptionPane.showInputDialog(null,"Nome do aluno");
                    String rg_aluno = JOptionPane.showInputDialog(null,"RG do Aluno");
                    try
                    {
                        aluno
                             .NomeAluno(nome_aluno)
                             .RG(rg_aluno)
                             .Cadastrar();
                        JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
                    } catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 3:
                    String cod_turma = JOptionPane.showInputDialog(null,"Código da turma");
                    String aluno_rg = JOptionPane.showInputDialog(null,"RG do Aluno");
                    try
                    {
                        turma.EfetuarMatricula(cod_turma, aluno_rg, aluno);
                        JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso");
                    } catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 4:
                    cod_turma = JOptionPane.showInputDialog(null,"Código da turma");
                    aluno_rg = JOptionPane.showInputDialog(null,"RG do Aluno");
                    try
                    {
                        turma.CancelarMatricula(cod_turma, aluno_rg, aluno);
                        JOptionPane.showMessageDialog(null, "Aluno desmatriculado com sucesso");
                    } catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 5:
                    cod_turma = JOptionPane.showInputDialog(null,"Código da turma");
                    try
                    {
                        turma.CancelarTurma(cod_turma);
                        JOptionPane.showMessageDialog(null, "Turma cancelada com sucesso");
                    } catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 6:
                    cod_turma = JOptionPane.showInputDialog(null,"Código da turma");
                    try
                    {
                        JOptionPane.showMessageDialog(null, turma.ListarAlunosNaTurma(cod_turma, aluno));
                    } catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 7:
                    cod_turma = JOptionPane.showInputDialog(null,"Código da turma");
                    try
                    {
                        JOptionPane.showMessageDialog(null, turma.ListarTurmas(cod_turma));
                    } catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar!");
                    
            }
        }
    
    }
}
/*
                for (String[] lista : this.alunos_cadastrar) 
                {
                    for (String lista2 : lista) {
                        System.out.println(lista2);
                    }
                }
*/