/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.FuncionarioModel;
import presenter.FuncionarioPresenter;
import serviceState.TelaConsultaState;
import view.FuncionarioViewTelaConsulta;

/**
 *
 * @author USER
 */
public class ControladorTelaConsulta implements InterfaceConfiguracaoTela{
    private FuncionarioPresenter presenter;
    private FuncionarioViewTelaConsulta view;
    private TelaConsultaState telaConsulta;
    private String nome;
    private String cargo;
    private double salario;
    private ActionEvent e;

    public ControladorTelaConsulta(FuncionarioPresenter presenter, FuncionarioViewTelaConsulta view, TelaConsultaState telaConsulta) {
        this.presenter = presenter;
        this.view = view;
        this.telaConsulta = telaConsulta;
    }
    
    @Override
     public void configuraTela(){
        view.setVisible(false);
        view.getBtnVisualizar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                obterFuncionario();
            }
        });
        view.setVisible(true);
    }
    
    public void gerarTabela(){
        ArrayList<FuncionarioModel> funcionarios = presenter.retornarTodos();
        
        for(int i=0; i<funcionarios.size() && funcionarios.get(i)!= null; i++){
            view.getTblFuncionarios().setValueAt(funcionarios.get(i).getNome(), i, 0);
            view.getTblFuncionarios().setValueAt(funcionarios.get(i).getCargo(), i, 1);
            view.getTblFuncionarios().setValueAt(funcionarios.get(i).getSalario(), i, 2);
        }
    }
   
    public void obterFuncionario(){
        int linha = view.getTblFuncionarios().getSelectedRow();
                
                
            int colunaNome = view.getTblFuncionarios().getColumnModel().getColumnIndex("Nome");
            int colunaCargo = view.getTblFuncionarios().getColumnModel().getColumnIndex("Cargo");
            int colunaSalario = view.getTblFuncionarios().getColumnModel().getColumnIndex("Salario");
                    
            this.nome = (String) view.getTblFuncionarios().getValueAt(linha, colunaNome);
            this.cargo = (String) view.getTblFuncionarios().getValueAt(linha, colunaCargo);
            this.salario = (double) view.getTblFuncionarios().getValueAt(linha, colunaSalario);
                
            telaConsulta.proximoEstado(presenter, e);
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }
    
    
    
}
